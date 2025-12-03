package com.nurturepersonal.nurturepersonal.service;

import com.nurturepersonal.nurturepersonal.enums.PaymentType;

import java.util.List;

public interface PaymentTransfersInfoService {
    String paymentTrasferNotCreated(List<String> orderIDs, String paymentType);
}
