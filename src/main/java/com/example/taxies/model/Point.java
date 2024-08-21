package com.example.taxies.model;

public enum Point {
    A(0), B(15), C(30), D(45), E(60), F(75);

    private final int distanceFromA;

    Point(int distanceFromA) {
        this.distanceFromA = distanceFromA;
    }

    public int getDistanceFromA() {
        return distanceFromA;
    }

    public int getDistance(Point other) {
        return Math.abs(this.distanceFromA - other.distanceFromA);
    }

    public int getDistanceFrom(Point currentLocation) {
        return currentLocation.distanceFromA;
    }
}
