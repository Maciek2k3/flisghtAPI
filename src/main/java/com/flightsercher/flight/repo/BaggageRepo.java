package com.flightsercher.flight.repo;

import com.flightsercher.flight.entity.Baggage;
import com.flightsercher.flight.entity.Flight;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.w3c.dom.stylesheets.LinkStyle;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface BaggageRepo extends CrudRepository<Baggage,Long> {
    <S extends Baggage> S save(Flight s);

    @Override
    List<Baggage> findAll();

    @Query(value = "select sum(pices)  FROM flights.baggage P INNER JOIN flight C ON P.flight_id = C.id WHERE arrival_airportiatacode=:code and departure_date=:depDate", nativeQuery = true)
    int findAllByPicesArrivalAirportIATACode(@Param("code") String code,@Param("depDate") LocalDate depDate);

    @Query(value = "select sum(pices)  FROM flights.baggage P INNER JOIN flight C ON P.flight_id = C.id WHERE departure_airportiatacode=:code and departure_date=:depDate", nativeQuery = true)
    int findAllByPicesDepartureAirportIATACode(@Param("code") String code,@Param("depDate") LocalDate depDate);

    @Query(value = "select weight*pices  FROM flights.baggage P INNER JOIN flight C ON P.flight_id = C.id WHERE flight_number=:flightNumber and departure_date=:depDate", nativeQuery = true)
    int baggageWeightForFlight (@Param("flightNumber") int flightNumber, @Param("depDate") LocalDate depDate);
}
