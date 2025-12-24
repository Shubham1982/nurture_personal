package com.nurturepersonal.nurturepersonal.implementation;

import com.nurturepersonal.nurturepersonal.helper.PayoutFileFormat;
import com.nurturepersonal.nurturepersonal.repo.PaymentTransfersInfoRepository;
import com.nurturepersonal.nurturepersonal.service.PaymentTransfersInfoService;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.FileOutputStream;
import java.io.InputStream;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.*;
import java.util.stream.Collectors;

@Service
public class paymentTransfersInfoServiceImpl implements PaymentTransfersInfoService {

    private final PaymentTransfersInfoRepository paymentTransfersInfoRepository;

    public paymentTransfersInfoServiceImpl(PaymentTransfersInfoRepository paymentTransfersInfoRepository) {
        this.paymentTransfersInfoRepository = paymentTransfersInfoRepository;
    }

    @Override
    public String paymentTrasferNotCreated(List<String> orderIDs, String paymentType) {
        List<String> requiredNotSettledOrderIDs = new ArrayList<>();
        List<String> existPayoutOrderIDs =
                Optional.ofNullable(paymentTransfersInfoRepository
                                .payoutCreatedOrderIDsForSeller(orderIDs, paymentType))
                        .orElse(Collections.emptyList());
        for (String each : orderIDs) {
            if (!existPayoutOrderIDs.contains(each)) {
                requiredNotSettledOrderIDs.add(each);
                System.out.println(each);
            }
        }
        System.out.println(requiredNotSettledOrderIDs);
        return String.join(",", requiredNotSettledOrderIDs);
    }

    @Override
    public void processExcel(MultipartFile file) {
        try (InputStream is = file.getInputStream();
             Workbook workbook = new XSSFWorkbook(is)) {

            Sheet sheet = workbook.getSheetAt(0);
            Map<String, List<String>> paymentIdToOrderIds = new HashMap<>();
            Map<String, List<String>> filteredPaymentIdToOrderIds = new HashMap<>();

            for (Row row : sheet) {
                if (row.getRowNum() == 0) continue; // skip header

                String appOrderId = row.getCell(0).getStringCellValue();
                String excelPaymentType = row.getCell(1).getStringCellValue();

                paymentIdToOrderIds
                        .computeIfAbsent(excelPaymentType, k -> new ArrayList<>())
                        .add(appOrderId);
            }

            for (Map.Entry<String, List<String>> entry : paymentIdToOrderIds.entrySet()) {

                String paymentType = entry.getKey();
                List<String> excelOrderIds = entry.getValue();

                List<String> existingOrderIds =
                        Optional.ofNullable(
                                paymentTransfersInfoRepository
                                        .payoutCreatedOrderIDsForSeller(
                                                excelOrderIds,
                                                paymentType
                                        )
                        ).orElse(Collections.emptyList());

                List<String> newOrderIds = excelOrderIds.stream()
                        .filter(id -> !existingOrderIds.contains(id)).collect(Collectors.toList());

                if (!newOrderIds.isEmpty()) {
                    filteredPaymentIdToOrderIds.put(paymentType, newOrderIds);
                }
            }

            writeFilteredDataToExcel(filteredPaymentIdToOrderIds);

        } catch (Exception e) {
            throw new RuntimeException("Failed to process Excel file", e);
        }
    }

    private void writeFilteredDataToExcel(
            Map<String, List<String>> filteredPaymentIdToOrderIds) {

        String todayDate = getTodayDate();
        List<String> validPayoutPaymentType = Arrays.asList("0", "2", "4");
        String filePath = "/home/lt-444/Downloads/Daily Payout Failed Cases/" + todayDate + "_output.xlsx";

        try (Workbook workbook = new XSSFWorkbook();
             FileOutputStream fos = new FileOutputStream(filePath)) {

            Sheet sheet = workbook.createSheet("Filtered Orders");

            // Header
            Row header = sheet.createRow(0);
            header.createCell(0).setCellValue("app_order_id");
            header.createCell(1).setCellValue("payment_type");

            int rowNum = 1;

            for (Map.Entry<String, List<String>> entry : filteredPaymentIdToOrderIds.entrySet()) {
                String paymentType = entry.getKey();
                //Only for the payment type 0 2 4
                if (validPayoutPaymentType.contains(paymentType))
                    payoutFileBuilder(paymentType, entry.getValue());

                for (String orderId : entry.getValue()) {
                    Row row = sheet.createRow(rowNum++);
                    row.createCell(0).setCellValue(orderId);
                    row.createCell(1).setCellValue(paymentType);
                }
            }

            sheet.autoSizeColumn(0);
            sheet.autoSizeColumn(1);

            workbook.write(fos);

        } catch (Exception e) {
            throw new RuntimeException("Failed to write filtered Excel file", e);
        }
    }

    @Async
    protected void payoutFileBuilder(String paymentType, List<String> orderIds) {
        StringBuilder builderFileName = new StringBuilder();
        List<PayoutFileFormat> payout = paymentTransfersInfoRepository.createPayoutCheckout(paymentType, orderIds);
        List<String> appOrderIds = payout.stream()
                .map(PayoutFileFormat::getAppOrderID)
                .collect(Collectors.toList());

        if (!paymentTransfersInfoRepository.payoutCreatedOrderIDsForSeller(appOrderIds, paymentType).isEmpty()) {
            throw new RuntimeException("Payout created order IDs for " + paymentType + " are not supported");
        }

        switch (paymentType) {
            case "0":
                builderFileName.append("PrepaidPayoutFile_0");
                break;

            case "2":
                builderFileName.append("NeftPayoutFile_2");
                break;

            case "4":
                builderFileName.append("RupifiPayoutFile_4");
                break;
            default:
                throw new RuntimeException("Payout type " + paymentType + " not supported");
        }

        String filePath = "/home/lt-444/Downloads/Daily Payout Failed Cases/" + builderFileName + "_" + getTodayDate() + "_output.xlsx";

        try (Workbook workbook = new XSSFWorkbook();
             FileOutputStream fos = new FileOutputStream(filePath)) {

            Sheet sheet = workbook.createSheet("Payout");

            // Header
            Row header = sheet.createRow(0);
            header.createCell(0).setCellValue("App Order ID");
            header.createCell(1).setCellValue("Payment ID");
            header.createCell(2).setCellValue("Amount");
            header.createCell(3).setCellValue("EnterpriseID");


            int rowNum = 1;

            for (PayoutFileFormat payoutFileFormat : payout) {
                Row row = sheet.createRow(rowNum++);
                int convertAmount = (int) payoutFileFormat.getAmount();
                row.createCell(0).setCellValue(payoutFileFormat.getAppOrderID());
                row.createCell(1).setCellValue(payoutFileFormat.getPaymentID());
                row.createCell(2).setCellValue(convertAmount);
                row.createCell(3).setCellValue(payoutFileFormat.getEnterpriseID());
            }

            sheet.autoSizeColumn(0);
            sheet.autoSizeColumn(1);

            workbook.write(fos);

        } catch (Exception e) {
            throw new RuntimeException("Failed to write filtered Excel file", e);
        }

    }

    private String getTodayDate() {
        LocalDate today = LocalDate.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
        return today.format(formatter);
    }
}
