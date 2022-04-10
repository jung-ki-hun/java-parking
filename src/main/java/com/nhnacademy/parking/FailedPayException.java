package com.nhnacademy.parking;

public class FailedPayException extends RuntimeException {
    public FailedPayException(String s) {
        super(s);
    }
}
