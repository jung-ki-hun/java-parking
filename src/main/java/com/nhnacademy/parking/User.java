package com.nhnacademy.parking;

public class User {
    private final String id;
    private long amount;
    private int payco;

    public User(String id, long amount) {
        this.id = id;
        this.amount = amount;
        this.payco = 0;
    }

    public User(String id, long amount, int payco) {
        this.id = id;
        this.amount = amount;
        this.payco = payco;
    }

    public User(String id) {
        this(id,1_000_000L);

    }

    public String getId() {
        return id;
    }
    public int getPayco() {
        return payco;
    }
    public long getAmount() {
        return amount;
    }

    @Override
    public String toString() {
        return "User{" +
            "id='" + id + '\'' +
            ", amount=" + amount +
            '}';
    }
}
