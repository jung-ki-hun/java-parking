package com.nhnacademy.parking;

public class Car {
   private final String number;
    private User user;
    private Time time;
    private int type; ///1 -> 경차 0 -> 대형차
    public Time getTime() {
        return time;
    }

    public String getNumber() {
        return number;
    }

    public Car(String number, User user) {
        this(number,user,new Time(0,0,30,0));
    }

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

        this(number,new User("user",10000),new Time(0,0,30,10));
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
