package com.flightsercher.flight.repo;

import com.flightsercher.flight.entity.Flight;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface FlightRepo extends CrudRepository<Flight, Long> {

    @Override
    <S extends Flight> S save(S s);

    @Override
    List<Flight> findAll();

    @Query(value = "SELECT COUNT(*) FROM flight WHERE departure_airportiatacode=:code AND departure_date=:date", nativeQuery = true)
    int findAllByDepartureAirportIATACode(@Param("code") String code, @Param("date") LocalDate date);

    @Query(value = "SELECT COUNT(*) FROM flight WHERE arrival_airportIATACode=:code AND departure_date=:date", nativeQuery = true)
    int findAllByArrivalAirportIATACode(@Param("code") String code, @Param("date") LocalDate date);


}
