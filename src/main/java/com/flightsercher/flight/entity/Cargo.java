package com.flightsercher.flight.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.NonNull;

import javax.persistence.*;

@Entity
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class Cargo {
    @Id
    @NonNull
    private Long id;

    @Column(name = "weight")
    private int weight;

    @Column(name = "weightUnit")
    private String weightUnit;

    @Column(name = "pices")
    private int pices;

    @OneToOne
    private Flight flight;
}



