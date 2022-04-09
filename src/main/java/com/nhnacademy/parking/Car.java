package com.nhnacademy.parking;

public class Car {
   private final String number;
    private User user;

    public String getNumber() {
        return number;
    }


    public User getUser() {
        return user;
    }

    public Car(String number) {
        this.number = number;
    }
}
