package com.nhnacademy.parking;

public class Car {
   private final String number;
    private User user;
    private Time time;
    private int type; ///1 -> 경차 0 -> 대형차

    public int getType() {
        return type;
    }

    public Time getTime() {
        return time;
    }

    public String getNumber() {
        return number;
    }

//    public Car(String number, User user) {
//        this(number,user,new Time(0,0,30,0));
//    }

//    public Car(String number, User user) {
//        this.number = number;
//        this.user = user;
//        this.time = null;
//        this.type = 1;
//    }

    public User getUser() {
        return user;
    }

    public Car(String number, User user, Time time,int type) {
        this.number = number;
        this.user = user;
        this.time = time;
        this.type = type;
    }
    public Car(String number, User user, Time time) {
        this.number = number;
        this.user = user;
        this.time = time;
        this.type = 1;
    }
    public Car(String number) {
        this.number = number;
        this.user = null;
        this.time = null;
        this.type = 1;
    }

    @Override
    public String toString() {
        return "Car{" +
            "number='" + number + '\'' +
            ", user=" + user +
            ", time=" + time +
            '}';
    }
}
