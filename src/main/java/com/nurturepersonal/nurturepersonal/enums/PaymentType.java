package com.nurturepersonal.nurturepersonal.enums;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public enum PaymentType {
    RAZORPAY_PREPAID(0),
    BRAND_CREDIT(1),
    RAZORPAY_NEFT(2),
    CREDIT_PREPAID(3),
    RUPIFI_CREDIT(4),
    REWARD_POINTS(5),
    COMBODISC(6),

    PRE_BOOKING (7),
    NURTURE_DISCOUNT(8),
    AGIF(9),
    EPAYLATER(10);

    public final int value;
    PaymentType(int value) {
        this.value = value;
    }

    private static final Map<Integer, PaymentType> reverseMap = Arrays.stream(PaymentType.values()).collect(Collectors.toMap(x -> x.value, Function.identity()));
    public static PaymentType getPaymentTypeFromValue(int value) {
        return reverseMap.get(value);
    }

    //TODO: ADD entry to sapOrderTypeMap whenever new payment type is added and ask SAP to configure it on their side
    private static final Map<PaymentType, String> sapOrderTypeMap = Map.ofEntries(
            Map.entry(PaymentType.RUPIFI_CREDIT, "R"),
            Map.entry(PaymentType.REWARD_POINTS, "W"),
            Map.entry(PaymentType.RAZORPAY_PREPAID, "Z"),
            Map.entry(PaymentType.COMBODISC, "C"),
            Map.entry(PaymentType.RAZORPAY_NEFT, "Z"),
            Map.entry(PaymentType.AGIF, "N"),
            Map.entry(EPAYLATER, "E")
    );

    private static final Map<Integer, PaymentType> valueToEnumMap = new HashMap<>();
    static {
        for (PaymentType type : PaymentType.values()) {
            valueToEnumMap.put(type.value, type);
        }
    }

    public static String getPaymentGateway(PaymentType paymentType) {
        String gateway;
        switch (paymentType) {
            case RUPIFI_CREDIT:
                gateway = "RUPIFI";
                break;
            case RAZORPAY_PREPAID:
            case RAZORPAY_NEFT:
                gateway = "RAZORPAY";
                break;
            case REWARD_POINTS:
                gateway = "NURTUREPAY";
                break;
            case AGIF:
                gateway = "AGIF";
                break;
            case EPAYLATER:
                gateway = "EPAYLATER";
                break;

            default:
                gateway = "";
        }
        return gateway;
    }

    public static String getSapOrderType(PaymentType paymentType) {
        return sapOrderTypeMap.get(paymentType);
    }

    public static PaymentType fromInt(Integer paymentType) {
        PaymentType type = valueToEnumMap.get(paymentType);
        if (type != null) {
            return type;
        } else {
            throw new IllegalArgumentException("Invalid payment type index: " + paymentType);
        }
    }
}
