package com.nhnacademy.parking;

import javax.security.auth.login.FailedLoginException;

public class ParkingSystem {
    public String scanCarNumber(Car car) {
       return car.getNumber();
    }

    public boolean pay(String scanCarNumber,ParkingLot parkingLot) {

        ParkingSpace paymentCar = parkingLot.getParkingCarData(scanCarNumber);

        int timeToSecond = (paymentCar.getCar().getTime().getHour() * 60 * 60) + (paymentCar.getCar().getTime().getMinute() * 60 ) + (paymentCar.getCar().getTime().getSecond());
        System.out.println(timeToSecond);
        int parkingPrice = priceCalculation(timeToSecond) + (paymentCar.getCar().getTime().getDay() * 10000);
        System.out.println(parkingPrice);
        if(paymentCar.getCar().getUser().getAmount() > parkingPrice)
        {
            parkingLot.out(scanCarNumber);//출차처리
            return true;
        }
        else
        {
            throw new FailedPayException("I failed to pay because I didn't have enough money");
        }
    }
    public int priceCalculation(int timeToSecond){
        int price = 0;
        if(timeToSecond <= 1800){
            price = 1000;
            return price;
        }
        else{
            timeToSecond -= 1800;
            if(timeToSecond < 10800)
            {
                price += 1000;
                int count = 0;
                do {
                    timeToSecond -= 600;
                    count++;
                } while (timeToSecond >= 0);
                System.out.println("dd"+count);
                price += (count * 500);
            }
            else{
                price = 10000;
                return price;
            }
        }
        return price;
    }
}
