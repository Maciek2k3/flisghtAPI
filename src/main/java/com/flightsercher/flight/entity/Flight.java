package com.flightsercher.flight.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.NonNull;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;

@Entity
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class Flight {
    @Id
    @NonNull
    private Long id;

    @Column(name = "flightNumber")
    private int flightNumber;

    @Column(name = "departureAirportIATACode")
    private String departureAirportIATACode;

    @Column(name = "arrivalAirportIATACode")
    private String arrivalAirportIATACode;

    @Column(name="departureDate")
    private LocalDate departureDate;


}

