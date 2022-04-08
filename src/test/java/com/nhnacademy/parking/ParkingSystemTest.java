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

        assertEquals(pakginglot.enter(parkingSystem.scanCarNumber(car)),expectedValueSpace);
    }
    @DisplayName("A-1에 주자 공간이 없으면?")
    @Test
    void parking_spaceCkeckNull() {
        Car car1 = new Car(testCarNumber);
        Car car2 = new Car("0123");
        pakginglot.enter(parkingSystem.scanCarNumber(car1));
        pakginglot.enter(parkingSystem.scanCarNumber(car2));

    }
}