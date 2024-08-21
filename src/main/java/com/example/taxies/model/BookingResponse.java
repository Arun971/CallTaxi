package com.example.taxies.model;

import jakarta.persistence.Entity;


public class BookingResponse {
    private String status;
    private Long taxiId;
    private double fare;

    public BookingResponse(String status, Long taxiId, double fare) {
        this.status = status;
        this.taxiId = taxiId;
        this.fare = fare;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Long getTaxiId() {
        return taxiId;
    }

    public void setTaxiId(Long taxiId) {
        this.taxiId = taxiId;
    }

    public double getFare() {
        return fare;
    }

    public void setFare(double fare) {
        this.fare = fare;
    }
}
