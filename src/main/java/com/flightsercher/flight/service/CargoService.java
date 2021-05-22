package com.flightsercher.flight.service;

import com.flightsercher.flight.entity.Baggage;
import com.flightsercher.flight.entity.Cargo;
import com.flightsercher.flight.repo.CargoRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class CargoService {

    @Autowired
    CargoRepo cargoRepo;

   public int findAllByPicesArrivalAirportIATACode(String code){
       return cargoRepo.findAllByPicesArrivalAirportIATACode(code);
   }
   public int findCargoWeight(int number, LocalDate localDate){
       return cargoRepo.cargoWeightForFlight(number,localDate);
   }

    public List<Cargo> findAll() {
        return cargoRepo.findAll();
    }
}
