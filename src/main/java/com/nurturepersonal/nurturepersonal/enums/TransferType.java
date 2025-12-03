package com.nurturepersonal.nurturepersonal.enums;

public enum TransferType {
    Payout("Payout"),
    Reversal("Reversal");

    public final String name;

    TransferType(String name) {
        this.name = name;
    }
}
