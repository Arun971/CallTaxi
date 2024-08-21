package com.example.taxies.controller;

import com.example.taxies.model.BookingRequest;
import com.example.taxies.model.BookingResponse;
import com.example.taxies.service.BookingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/bookings")
public class BookingController {

    @Autowired
    private BookingService bookingService;

    @PostMapping("/bookTaxi")
    public ResponseEntity<BookingResponse> bookTaxi(@RequestBody BookingRequest bookingRequest) {
        BookingResponse response = bookingService.createBooking(bookingRequest);
        if ("Rejected".equals(response.getStatus())) {
            return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<>(response, HttpStatus.OK);
    }
}
