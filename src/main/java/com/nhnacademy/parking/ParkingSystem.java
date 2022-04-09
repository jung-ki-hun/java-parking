package com.nhnacademy.parking;

public class ParkingSystem {
    public String scanCarNumber(Car car) {
       return car.getNumber();
    }

    public void pay(String scanCarNumber) {
        ParkingLot parkingLot = new ParkingLot();
        ParkingSpace paymentCar = parkingLot.getParkingCarData(scanCarNumber);
        parkingLot.out(scanCarNumber);//출차처리
        int timeToSecond = (paymentCar.getTime().getHour() * 60 * 60) + (paymentCar.getTime().getMinute() * 60 ) + (paymentCar.getTime().getSecond());
        int parkingPrice = 0;
        if(timeToSecond > 1800){

        }
    }
    public int priceCalculation(int timeToSecond){
        int price = 0;
        if(timeToSecond > 1800){
            price = 1000;
        }
        else{
            if()
        }
        return price;
    }
}
