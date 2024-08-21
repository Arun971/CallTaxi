package com.example.taxies.service;

import com.example.taxies.model.BookingRequest;
import com.example.taxies.model.BookingResponse;
import com.example.taxies.model.Taxi;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BookingService {
    @Autowired
    private TaxiService taxiService;

    public BookingResponse createBooking(BookingRequest bookingRequest) {
        Taxi taxi = taxiService.getNearestAvailableTaxi(bookingRequest);

        if (taxi == null) {
            return new BookingResponse("Rejected", null, 0.0);
        }

        double fare = taxiService.calculateFare(bookingRequest.getPickupPoint(), bookingRequest.getDropPoint());
        taxiService.updateTaxiStatus(taxi, bookingRequest);

        return new BookingResponse("Success", taxi.getId(), fare);
    }
}
