package com.nhnacademy.parking;

public class Exit {
    public void out(String scanCarNumber , ParkingLot parkingLot) {
        ParkingSystem parkingSystem = new ParkingSystem();
        parkingSystem.pay(scanCarNumber,parkingLot);
    }
}
