package com.nhnacademy.parking;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ParkingSystemTest {
    ParkingSystem parkingSystem = new ParkingSystem();
    String testCarNumber = "0130";
    ParkingLot pakginglot =new ParkingLot();
    @BeforeEach
    void setup(){
    }
    @DisplayName("주차장에 차가 들어온다")
    @Test
    void parking_input() {
        Car car = new Car(testCarNumber);
        String recognitionValue = testCarNumber;

        assertEquals(parkingSystem.scanCarNumber(car), recognitionValue);
    }
    @DisplayName("A-1 에 주차한다.")
    @Test
    void parking_space(){
        Car car = new Car(testCarNumber);

        String expectedValueSpace ="A-1";
        pakginglot.enter(parkingSystem.scanCarNumber(car));
        assertEquals(pakginglot.findParkingCode(parkingSystem.scanCarNumber(car)),expectedValueSpace);
    }
    @DisplayName("A-1에 주자 공간이 없으면?")
    @Test
    void parking_spaceCheckNull() {
        Car car1 = new Car(testCarNumber);
        Car car2 = new Car("0123");
        pakginglot.enter(parkingSystem.scanCarNumber(car1));
        pakginglot.enter(parkingSystem.scanCarNumber(car2));
        assertEquals(pakginglot.findParkingCode(parkingSystem.scanCarNumber(car2)),"A-2");

    }
    @DisplayName("주차장에서 차가 나간다.")
    @Test
    void out_parkingSystem(){
        Car car1 = new Car(testCarNumber);
        Car car2 = new Car("0123");
        pakginglot.enter(parkingSystem.scanCarNumber(car1));
        pakginglot.enter(parkingSystem.scanCarNumber(car2));


        pakginglot.out(parkingSystem.scanCarNumber(car2));

        assertEquals(pakginglot.findParkingCode(parkingSystem.scanCarNumber(car2)),null);
    }
    @DisplayName("차가 나갈려면 주차 시간만큼 결제를 해야한다. 당일 주차")
    @Test
    public void pay_out_parkingSystem() {

        Car car1 = new Car(testCarNumber ,new User("kihun"),new Time(0,30,0));
        Car car2 = new Car("0123",new User("jodon",2000),new Time(6,0,0));
        pakginglot.enter(parkingSystem.scanCarNumber(car1));
        pakginglot.enter(parkingSystem.scanCarNumber(car2));

        parkingSystem.pay(parkingSystem.scanCarNumber(car2));
    }
}