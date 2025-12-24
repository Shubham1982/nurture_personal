package com.nurturepersonal.nurturepersonal.resource;

import com.nurturepersonal.nurturepersonal.enums.PaymentType;
import com.nurturepersonal.nurturepersonal.service.PaymentTransfersInfoService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@RestController
@RequestMapping("/api")
public class PaymentRelatedResource {

    private final PaymentTransfersInfoService paymentTransfersInfoService;

    public PaymentRelatedResource(PaymentTransfersInfoService paymentTransfersInfoService) {
        this.paymentTransfersInfoService = paymentTransfersInfoService;
    }

    @GetMapping("/payment/trasfers/not/created/{paymentType}")
    public String paymentTrasferNotCreated(@RequestBody List<String> orderIDs, @PathVariable(value = "paymentType") String paymentType) {
        return paymentTransfersInfoService.paymentTrasferNotCreated(orderIDs, paymentType);
    }

    @PostMapping("/failed/payout/output/file")
    public ResponseEntity<String> failedPayout(@RequestPart (value = "file") MultipartFile file) {
        if (file.isEmpty()) {
            return ResponseEntity.badRequest().body("File is empty");
        }
        paymentTransfersInfoService.processExcel(file);
        return ResponseEntity.ok("Excel export successfully");

    }
}
