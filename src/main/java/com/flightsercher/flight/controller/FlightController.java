package com.flightsercher.flight.controller;

import com.flightsercher.flight.entity.Baggage;
import com.flightsercher.flight.entity.Cargo;
import com.flightsercher.flight.entity.Flight;
import com.flightsercher.flight.service.BaggageService;
import com.flightsercher.flight.service.CargoService;
import com.flightsercher.flight.service.FightService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/v1")
@CrossOrigin(origins = "*")
public class FlightController {

    @Autowired
    BaggageService baggageService;
    @Autowired
    CargoService cargoService;
    @Autowired
    FightService fightService;

    @GetMapping("/getAllBagages")
    public List<Baggage> getBaggages() {
        return baggageService.findAll();
    }

    @GetMapping("/getAllCargo")
    public List<Cargo> getCargo() {
        return cargoService.findAll();
    }

    @GetMapping("/getAllFlights")
    public List<Flight> getFlight() {
        return fightService.findAll();
    }

    @GetMapping("/getCargoWeight")
    @ResponseBody
    public int getCargoWeight
            (@RequestParam int number,
             @RequestParam(name = "from", required = false, defaultValue = "10-10-2017")
             @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate from) {
        return cargoService.findCargoWeight(number, from);

    }

    @GetMapping("/getBaggageWeight")
    @ResponseBody
    public int getBaggageWeight
            (@RequestParam int number,
             @RequestParam(name = "from", required = false, defaultValue = "10-10-2017")
             @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate from) {
        return baggageService.baggageWeightForFlight(number, from);
    }

    @GetMapping("/totalWeight")
    @ResponseBody
    public int getTotalWeight(
            @RequestParam int number,
            @RequestParam(name = "from", required = false, defaultValue = "10-10-2017")
            @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate from) {
        return fightService.totalWeight(number,from);
    }

    @GetMapping("/getNumberDeparting")
    @ResponseBody
    public int getNumberDeparturing
            (@RequestParam String code,
             @RequestParam(name = "from", required = false, defaultValue = "10-10-2017")
             @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate from) {
        return fightService.findAllByDepartureAirportIATACode(code, from);

    }
    @GetMapping("/getNumberArriving")
    @ResponseBody
    public int getNumberArriving
            (@RequestParam String code,
             @RequestParam(name = "from", required = false, defaultValue = "10-10-2017")
             @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate from) {
        return fightService.findAllByArrivalAirportIATACode(code, from);
    }

    @GetMapping("/getNumberArrivingBag")
    @ResponseBody
    public int getNumberArrivingBag
            (@RequestParam String code,
             @RequestParam(name = "from", required = false, defaultValue = "10-10-2017")
             @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate from) {
        return baggageService.findAllByPicesArrivalAirportIATACode(code,from);
    }
    @GetMapping("/getNumberDepartureBag")
    @ResponseBody
    public int getNumberDepartureBag
            (@RequestParam String code,
             @RequestParam(name = "from", required = false, defaultValue = "10-10-2017")
             @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate from) {
        return baggageService.findAllByPicesDepartureAirportIATACode(code,from);
    }


}
