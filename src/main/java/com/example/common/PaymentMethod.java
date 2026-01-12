package com.example.common;

/**
 * 支払い方法を管理するEnum.
 */
public enum PaymentMethod {
    CREDIT_CARD(0, "クレジットカード"),
    CASH(1, "現金"),
    E_MONEY(2, "電子マネー（PayPay等）");

    private final int code;
    private final String label;

    PaymentMethod(int code, String label) {
        this.code = code;
        this.label = label;
    }

    public int getCode() {
        return code;
    }

    public String getLabel() {
        return label;
    }

    public static PaymentMethod fromCode(int code) {
        for (PaymentMethod p : values()) {
            if (p.code == code) return p;
        }
        throw new IllegalArgumentException("Invalid code: " + code);
    }
}
