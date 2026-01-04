package com.example.common;

/**
 * 予約ステータスを管理するEnum.
 */
public enum ReservationStatus {
    PENDING(0, "未確認"),
    CONFIRMED(1, "確定"),
    CANCELLED(2, "キャンセル");

    private final int code;
    private final String label;

    ReservationStatus(int code, String label) {
        this.code = code;
        this.label = label;
    }

    public int getCode() {
        return code;
    }

    public String getLabel() {
        return label;
    }

    public static ReservationStatus fromCode(int code) {
        for (ReservationStatus s : values()) {
            if (s.code == code) return s;
        }
        throw new IllegalArgumentException("Invalid code: " + code);
    }
}
