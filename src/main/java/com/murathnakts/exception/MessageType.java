package com.murathnakts.exception;

import lombok.Getter;

@Getter
public enum MessageType {
    NO_RECORD_EXIST("1004", "Kayıt Bulunamadı"),
    TOKEN_EXPIRED("1005", "Token Süresi Bitmiştir"),
    USERNAME_NOT_FOUND("1006", "Username Bulunamadı"),
    GENERAL_EXCEPTION("9999", "Genel Bir Hata Oluştu");

    private final String code;
    private final String message;

    MessageType(String code, String message) {
        this.code = code;
        this.message = message;
    }
}
