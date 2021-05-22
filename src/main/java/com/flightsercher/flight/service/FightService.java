package com.flightsercher.flight.service;

import com.flightsercher.flight.entity.Cargo;
import com.flightsercher.flight.entity.Flight;
import com.flightsercher.flight.repo.BaggageRepo;
import com.flightsercher.flight.repo.CargoRepo;
import com.flightsercher.flight.repo.FlightRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class FightService {
    @Autowired
    FlightRepo flightRepo;

    @Autowired
    CargoRepo cargoRepo;

    @Autowired
    BaggageRepo baggageRepo;


    public int findAllByDepartureAirportIATACode(String code, LocalDate date) {
        return flightRepo.findAllByDepartureAirportIATACode(code, date);
    }


    public int findAllByArrivalAirportIATACode(String code, LocalDate date) {
        return flightRepo.findAllByArrivalAirportIATACode(code, date);
    }

    public List<Flight> findAll() {
        return flightRepo.findAll();
    }


    public int totalWeight(int flightNumber, LocalDate date){
        int cargoWeight=cargoRepo.cargoWeightForFlight(flightNumber, date);
        int baagageWeight=baggageRepo.baggageWeightForFlight(flightNumber, date);

        return cargoWeight+baagageWeight;

    }
}
