package com.nhnacademy.parking;

public class ParkingSpace {
    private String code;

    public Time getTime() {
        return time;
    }

    private Car car;
    private Time time;
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

    public Car getCar() {
        return car;
    }
}
