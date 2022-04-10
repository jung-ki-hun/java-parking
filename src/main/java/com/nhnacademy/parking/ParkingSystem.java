package com.nhnacademy.parking;

import javax.security.auth.login.FailedLoginException;

public class ParkingSystem {
    public String scanCarNumber(Car car) {
       return car.getNumber();
    }

    public boolean pay(String scanCarNumber,ParkingLot parkingLot) {

        ParkingSpace paymentCar = parkingLot.getParkingCarData(scanCarNumber);

        int timeToSecond = paymentCar.getCar().getTime().getHour() * 60 * 60 + (paymentCar.getCar().getTime().getMinute() * 60 ) + (paymentCar.getCar().getTime().getSecond());
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
    public boolean pay2(String scanCarNumber,ParkingLot parkingLot) {

        ParkingSpace paymentCar = parkingLot.getParkingCarData(scanCarNumber);
        int parkingPrice = 0;
        int timeToSecond = (paymentCar.getCar().getTime().getHour() * 60 * 60) + (paymentCar.getCar().getTime().getMinute() * 60 ) + (paymentCar.getCar().getTime().getSecond());
        System.out.println(timeToSecond);
        if(paymentCar.getCar().getType() == 1) {
             parkingPrice = (int)((priceCalculation2(timeToSecond) + (paymentCar.getCar().getTime().getDay() * 15000) )* 0.5);
        }
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
    public boolean pay3(String scanCarNumber,ParkingLot parkingLot) {

        ParkingSpace paymentCar = parkingLot.getParkingCarData(scanCarNumber);
        PaycoServer paycoServer = new PaycoServer();
        int parkingPrice = 0;
        boolean isPayment = paycoServer.checkPayco(paymentCar.getCar().getUser().getId());
        int timeToSecond = (paymentCar.getCar().getTime().getHour() * 60 * 60) + (paymentCar.getCar().getTime().getMinute() * 60 ) + (paymentCar.getCar().getTime().getSecond());
        System.out.println(timeToSecond);
        if(paymentCar.getCar().getType() == 1) {
            parkingPrice = (int)((priceCalculation2(timeToSecond) + (paymentCar.getCar().getTime().getDay() * 15000) )* 0.5);
            System.out.println(isPayment);
            if(isPayment)
                parkingPrice = (int)(parkingPrice*0.9);
        }

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
    public int priceCalculation2(int timeToSecond){
        int price = 0;
        if(timeToSecond <= 1800){
            price = 0;
            return price;
        }
        else{
            timeToSecond -= 1800;
            if(timeToSecond < 14400)//4h10m
            {
                //price += 1000;
                if(timeToSecond <= 6000){
                    price = 1000;
                    return price;
                }
                int count = 0;
                do {
                    timeToSecond -= 600;
                    count++;
                } while (timeToSecond >= 0);
                price += (count * 500);
            }
            else{
                price = 15000;
                return price;
            }
        }
        return price;
    }
}
