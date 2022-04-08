package com.nhnacademy.parking;

public class CarNumberIsNotSameException extends RuntimeException {
    public CarNumberIsNotSameException() {
        super("There cannot be the same number");
    }

    public CarNumberIsNotSameException(String message) {
        super(message +"There cannot be the same number");
    }
}
