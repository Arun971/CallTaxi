package com.example.taxies.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

import java.time.LocalTime;
@Entity

public class Taxi {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Point currentLocation;
    private double totalEarnings;
    private boolean isAvailable;
    private LocalTime nextAvailableTime;

    public Taxi(Long id, Point currentLocation, double totalEarnings, boolean isAvailable, LocalTime nextAvailableTime) {
        this.id = id;
        this.currentLocation = currentLocation;
        this.totalEarnings = totalEarnings;
        this.isAvailable = isAvailable;
        this.nextAvailableTime = nextAvailableTime;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Point getCurrentLocation() {
        return currentLocation;
    }

    public void setCurrentLocation(Point currentLocation) {
        this.currentLocation = currentLocation;
    }

    public double getTotalEarnings() {
        return totalEarnings;
    }

    public void setTotalEarnings(double totalEarnings) {
        this.totalEarnings = totalEarnings;
    }

    public boolean isAvailable() {
        return isAvailable;
    }

    public void setAvailable(boolean available) {
        isAvailable = available;
    }

    public LocalTime getNextAvailableTime() {
        return nextAvailableTime;
    }

    public void setNextAvailableTime(LocalTime nextAvailableTime) {
        this.nextAvailableTime = nextAvailableTime;
    }
}
