package com.flightsercher.flight.service;

import com.flightsercher.flight.entity.Baggage;
import com.flightsercher.flight.repo.BaggageRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class BaggageService {
    @Autowired
    BaggageRepo baggageRepo;

    public int findAllByPicesArrivalAirportIATACode(String code, LocalDate depDate){
        return baggageRepo.findAllByPicesArrivalAirportIATACode(code, depDate);
    }

    public int findAllByPicesDepartureAirportIATACode(String code, LocalDate depDate){
        return baggageRepo.findAllByPicesDepartureAirportIATACode(code,depDate);
    }
    public int  baggageWeightForFlight(int flightNumber, LocalDate depDate){
        return baggageRepo.baggageWeightForFlight(flightNumber,depDate);
    }

    public List<Baggage> findAll(){
        return baggageRepo.findAll();
    }

}
