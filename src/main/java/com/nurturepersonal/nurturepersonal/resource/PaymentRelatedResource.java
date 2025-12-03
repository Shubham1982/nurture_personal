package com.nurturepersonal.nurturepersonal.resource;

import com.nurturepersonal.nurturepersonal.enums.PaymentType;
import com.nurturepersonal.nurturepersonal.service.PaymentTransfersInfoService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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
//    @GetMapping("/payment/trasfers/not")
//    public List<String> paymentTrasferNotCreatedDemo(@RequestBody List<String> orderIDs) {
//        return orderIDs;
//    }
}
