package com.example.demo.model;

public class FullUser {
    private long id;
    private boolean success;

    public FullUser(long id, boolean success) {
        this.id = id;
        this.success = success;
    }

    public long getId() {
        return id;
    }

    public boolean isSuccess() {
        return success;
    }

    @Override
    public String toString() {
        return "FullUser{" +
            "id=" + id +
            ", success=" + success +
            '}';
    }
}
