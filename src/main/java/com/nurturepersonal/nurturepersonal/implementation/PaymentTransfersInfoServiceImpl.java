package com.nurturepersonal.nurturepersonal.implementation;

import com.nurturepersonal.nurturepersonal.entity.PaymentTransfersInfo;
import com.nurturepersonal.nurturepersonal.enums.PaymentType;
import com.nurturepersonal.nurturepersonal.repo.PaymentTransfersInfoRepository;
import com.nurturepersonal.nurturepersonal.service.PaymentTransfersInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class PaymentTransfersInfoServiceImpl implements PaymentTransfersInfoService {

    private final PaymentTransfersInfoRepository paymentTransfersInfoRepository;

    public PaymentTransfersInfoServiceImpl(PaymentTransfersInfoRepository paymentTransfersInfoRepository) {
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
}
