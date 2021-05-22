package com.flightsercher.flight.dataprvider;

import com.flightsercher.flight.entity.Baggage;
import com.flightsercher.flight.entity.Cargo;
import com.flightsercher.flight.entity.Flight;
import com.flightsercher.flight.repo.BaggageRepo;
import com.flightsercher.flight.repo.CargoRepo;
import com.flightsercher.flight.repo.FlightRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Service;

import java.time.LocalDate;

@Service
public class DataProvider {

    @Autowired
    BaggageRepo baggageRepo;
    @Autowired
    FlightRepo flightRepo;
    @Autowired
    CargoRepo cargoRepo;

    @EventListener(ApplicationReadyEvent.class)
    public void saveData(){
        Flight flight=new Flight(1L,11,"WAW","WAW", LocalDate.now());
        Flight flight1=new Flight(2L,12,"KRK","KRK", LocalDate.now());
        Flight flight2=new Flight(3L,13,"WAW","WAW", LocalDate.now());
        Flight flight3=new Flight(4L,14,"LAL","WAW", LocalDate.now());
        Baggage baggage=new Baggage(1L,20,"kg",2,flight);
        Baggage baggage1=new Baggage(2L,20,"kg",2,flight1);
        Baggage baggage2=new Baggage(3L,20,"kg",2,flight2);
        Baggage baggage3=new Baggage(4L,32,"kg",5,flight3);
        Cargo cargo=new Cargo(1L,20,"kg",2,flight);
        Cargo cargo1=new Cargo(2L,20,"kg",2,flight1);
        Cargo cargo2=new Cargo(3L,20,"kg",2,flight2);
        Cargo cargo3=new Cargo(4L,32,"kg",5,flight3);

        flightRepo.save(flight);
        flightRepo.save(flight1);
        flightRepo.save(flight2);
        flightRepo.save(flight3);
        baggageRepo.save(baggage);
        baggageRepo.save(baggage1);
        baggageRepo.save(baggage2);
        baggageRepo.save(baggage3);
        cargoRepo.save(cargo);
        cargoRepo.save(cargo1);
        cargoRepo.save(cargo2);
        cargoRepo.save(cargo3);


    }
}
