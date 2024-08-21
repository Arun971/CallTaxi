package com.example.taxies.controller;

import com.example.taxies.model.Point;
import com.example.taxies.model.Taxi;
import com.example.taxies.service.TaxiService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping
public class TaxiController {
    @Autowired
    private TaxiService taxiService;

    @GetMapping("/status")
    public ResponseEntity<List<Taxi>> getAllTaxis() {
        List<Taxi> taxis = taxiService.getAllTaxis();
        return new ResponseEntity<>(taxis, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Taxi> getTaxiById(@PathVariable Long id) {
        Taxi taxi = taxiService.getTaxiById(id);
        if (taxi != null) {
            return new ResponseEntity<>(taxi, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PutMapping("/{id}/updateLocation")
    public ResponseEntity<Taxi> updateTaxiLocation(@PathVariable Long id, @RequestParam Point newLocation) {
        Taxi updatedTaxi = taxiService.updateTaxiLocation(id, newLocation);
        if (updatedTaxi != null) {
            return new ResponseEntity<>(updatedTaxi, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}
