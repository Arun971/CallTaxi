package com.example.taxies.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

import java.time.LocalTime;
@Entity
public class BookingRequest {
    @Id
    private Point pickupPoint;
    private Point dropPoint;
    private LocalTime bookingTime;

    public BookingRequest(Point pickupPoint, Point dropPoint, LocalTime bookingTime) {
        this.pickupPoint = pickupPoint;
        this.dropPoint = dropPoint;
        this.bookingTime = bookingTime;
    }

    public Point getPickupPoint() {
        return pickupPoint;
    }

    public void setPickupPoint(Point pickupPoint) {
        this.pickupPoint = pickupPoint;
    }

    public Point getDropPoint() {
        return dropPoint;
    }

    public void setDropPoint(Point dropPoint) {
        this.dropPoint = dropPoint;
    }

    public LocalTime getBookingTime() {
        return bookingTime;
    }

    public void setBookingTime(LocalTime bookingTime) {
        this.bookingTime = bookingTime;
    }
}
