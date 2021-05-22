package com.flightsercher.flight.repo;

import com.flightsercher.flight.entity.Cargo;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface CargoRepo extends CrudRepository<Cargo,Long> {
    @Override
    <S extends Cargo> S save(S s);

    @Override
    List<Cargo> findAll();

    @Query(value = "select sum(pices)  FROM flights.baggage P INNER JOIN flight C ON P.flight_id = C.id WHERE arrival_airportiatacode=:code", nativeQuery = true)
    int findAllByPicesArrivalAirportIATACode(@Param("code") String code);

    @Query(value = "select weight*pices  FROM flights.cargo P INNER JOIN flight C ON P.flight_id = C.id WHERE flight_number=:flightNumber and departure_date=:depDate", nativeQuery = true)
    int cargoWeightForFlight (@Param("flightNumber") int flightNumber, @Param("depDate") LocalDate depDate);
}
