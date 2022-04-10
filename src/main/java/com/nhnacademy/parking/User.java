package com.nhnacademy.parking;

public class User {
    private final String id;
    private long amount;

    public User(String id, long amount) {
        this.id = id;
        this.amount = amount;
    }

    public User(String id) {
        this(id,1_000_000L);

    }

    public String getId() {
        return id;
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
