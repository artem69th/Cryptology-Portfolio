package com.company.enums;


public enum Euclid {
    NOD(1),
    NOD_X(2),
    NOD_X_Y(3);

    private final int value;

    Euclid(int value) {
        this.value = value;
    }

    public int getValue() {
        return this.value;
    }
}
