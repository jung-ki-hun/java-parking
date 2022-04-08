package com.nhnacademy.parking;

public class ParkingSpace {
    String code;
    Car car;
    public ParkingSpace(Car car) {
        this(null,car);
    }
    public ParkingSpace(String code, Car car) {
        this.code = code;
        this.car = car;
    }

    public String getCode() {
        return code;
    }
}
