package com.nhnacademy.parking;

public class ParkingSpace {
    private String code;
    private Car car;

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

    @Override
    public String toString() {
        return "ParkingSpace{" +
            "code='" + code + '\'' +
            ", car=" + car +
            '}';
    }

    public Car getCar() {
        return car;
    }
}
