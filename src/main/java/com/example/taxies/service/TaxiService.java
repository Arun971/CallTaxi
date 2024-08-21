package com.example.taxies.service;

import com.example.taxies.model.BookingRequest;
import com.example.taxies.model.Point;
import com.example.taxies.model.Taxi;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

@Service
public class TaxiService {
    private List<Taxi> taxis;

    public TaxiService() {
        taxis = new ArrayList<>();
        for (long i = 1; i <= 4; i++) {
            taxis.add(new Taxi(i, Point.A, 0, true, LocalTime.of(0, 0)));
        }
    }

    public List<Taxi> getAllTaxis() {
        return taxis;
    }

    public Taxi getTaxiById(Long id) {
        return taxis.stream().filter(taxi -> taxi.getId().equals(id)).findFirst().orElse(null);
    }

    public Taxi getNearestAvailableTaxi(BookingRequest request) {
        Taxi nearestTaxi = null;
        int minDistance = Integer.MAX_VALUE;
        double lowestEarnings = Double.MAX_VALUE;

        for (Taxi taxi : taxis) {
            if (taxi.isAvailable() && (taxi.getNextAvailableTime().isBefore(request.getBookingTime()) ||
                    taxi.getNextAvailableTime().equals(request.getBookingTime()))) {
                int distance = request.getPickupPoint().getDistanceFrom(taxi.getCurrentLocation());

                if (distance < minDistance ||
                        (distance == minDistance && taxi.getTotalEarnings() < lowestEarnings)) {
                    nearestTaxi = taxi;
                    minDistance = distance;
                    lowestEarnings = taxi.getTotalEarnings();
                }
            }
        }

        return nearestTaxi;
    }

    public double calculateFare(Point pickupPoint, Point dropPoint) {
        int distance = pickupPoint.getDistanceFrom(dropPoint);
        if (distance <= 5) {
            return 100;
        } else {
            return 100 + (distance - 5) * 10;
        }
    }

    public void updateTaxiStatus(Taxi taxi, BookingRequest request) {
        taxi.setCurrentLocation(request.getDropPoint());
        int travelTime = request.getPickupPoint().getDistanceFrom(request.getDropPoint()) * 4;
        taxi.setNextAvailableTime(request.getBookingTime().plusMinutes(travelTime));
        taxi.setTotalEarnings(taxi.getTotalEarnings() + calculateFare(request.getPickupPoint(), request.getDropPoint()));
    }

    public Taxi updateTaxiLocation(Long id, Point newLocation) {
        Taxi taxi = getTaxiById(id);
        if (taxi != null) {
            taxi.setCurrentLocation(newLocation);
        }
        return taxi;
    }
}
