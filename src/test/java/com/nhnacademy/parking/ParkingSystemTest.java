package com.nhnacademy.parking;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
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
    @DisplayName("차가 나갈려면 주차 시간만큼 결제를 해야한다. 당일 주차만")
    @Test
     void pay_out_parkingSystem() {

        Car car1 = new Car(testCarNumber ,new User("kihun",2000,1),new Time(0,0,20,30));
        Car car2 = new Car("0123",new User("jodon",2000,1),new Time(0,0,30,0));
        pakginglot.enter2(parkingSystem.scanCarNumber(car1),car1);
        pakginglot.enter2(parkingSystem.scanCarNumber(car2),car2);


        assertThat(parkingSystem.pay(parkingSystem.scanCarNumber(car2),pakginglot)).isTrue();
    }
//    @DisplayName("주차장 출입구는 n개입니다.")
//    @Test
//    void setEntranceAndExit()
//    {
//        Car car1 = new Car(testCarNumber ,new User("kihun",3000),new Time(0,0,20,30));
//        Car car2 = new Car("0123",new User("jodon",2000),new Time(0,0,30,0));
//        Car car3 = new Car("0223",new User("joon",2000),new Time(0,0,30,0));
//        Car car4 = new Car("0133",new User("jdon",2000),new Time(0,0,30,0));
//        Car car5 = new Car("2223",new User("jodn",2000),new Time(0,0,30,0));
//        Car car6 = new Car("0127",new User("jodo",2000),new Time(0,0,30,0));
//
//        int n = 2;
//        Entrance [] entrance = new Entrance[n];
//       // Exit [] exit = new Exit[n];
//
//        entrance[0].enter(entrance[0].scanCarNumber(car1),pakginglot);
//      //  entrance[1].enter(entrance[1].scanCarNumber(car2),pakginglot);
////        entrance[0].enter(entrance[0].scanCarNumber(car3),pakginglot);
////        entrance[1].enter(entrance[1].scanCarNumber(car4),pakginglot);
////        entrance[0].enter(entrance[0].scanCarNumber(car5),pakginglot);
////        entrance[1].enter(entrance[1].scanCarNumber(car6),pakginglot);
////        ////// 입차
//
////        exit[0].out(entrance[0].scanCarNumber(car6),pakginglot);
////        exit[1].out(entrance[1].scanCarNumber(car1),pakginglot);
////        exit[0].out(entrance[0].scanCarNumber(car3),pakginglot);
////        exit[1].out(entrance[1].scanCarNumber(car4),pakginglot);
////        exit[0].out(entrance[0].scanCarNumber(car5),pakginglot);
////        exit[1].out(entrance[1].scanCarNumber(car2),pakginglot);
//        ////// 출차
//
//        assertEquals(pakginglot.getIndex(entrance[0].scanCarNumber(car1)),-1);
//
//    }
    @DisplayName("가격표는 변경되었습니다.")
    @Test
    void chagePayAmount() {
        Car car1 = new Car(testCarNumber ,new User("kihun"),new Time(0,0,20,30));
        Car car2 = new Car("0123",new User("jodon",2000),new Time(0,0,30,0),1);
        pakginglot.enter2(parkingSystem.scanCarNumber(car1),car1);
        pakginglot.enter2(parkingSystem.scanCarNumber(car2),car2);
        assertThat(parkingSystem.pay2(parkingSystem.scanCarNumber(car2),pakginglot)).isTrue();
    }
    @DisplayName("사용자가 payco 회원인 경우에는 주차요금이 10% 할인됩니다.")
    @Test
    void paycoServiceServerCheck(){

        Car car1 = new Car(testCarNumber ,new User("kihun",2300,0),new Time(0,0,20,30));
        Car car2 = new Car("0123",new User("jodon0",2000,1),new Time(0,0,30,10),1);
        pakginglot.enter2(parkingSystem.scanCarNumber(car1),car1);
        pakginglot.enter2(parkingSystem.scanCarNumber(car2),car2);
        assertThat(parkingSystem.pay3(parkingSystem.scanCarNumber(car2),pakginglot)).isTrue();

    }

}