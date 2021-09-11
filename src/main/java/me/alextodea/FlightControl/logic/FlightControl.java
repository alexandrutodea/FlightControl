package me.alextodea.FlightControl.logic;

import me.alextodea.FlightControl.domain.Airplane;
import me.alextodea.FlightControl.domain.Flight;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicBoolean;

public class FlightControl {
    private Map<Airplane, List<Flight>> departures;

    public FlightControl() {
        this.departures = new HashMap<>();
    }

    public void addAirplane(Airplane airplane) {
        this.departures.putIfAbsent(airplane, new ArrayList<>());
    }

    public void addFlight(Flight flight) {
        AtomicBoolean flag = new AtomicBoolean(false);
        departures.keySet().stream()
                .forEach(s -> {
                    if (s.getId().equals(flight.getAirplane().getId())) {
                        departures.get(s).add(flight);
                        flag.set(true);
                    }
                });
        if (!flag.get()) {
            throw new IllegalArgumentException("Invalid flight.");
        }
    }

    public void printAirplanes() {
        departures.keySet().stream().forEach(s -> System.out.println(s));
    }

    public void printFlights() {
        departures.values().stream().forEach(s -> s.stream().forEach(r -> System.out.println(r)));
    }

    public void printAirplaneDetails(String id) {
        departures.keySet().stream().forEach(s -> {
            if (s.getId().equals(id)) {
                System.out.println(s);
            }
        });
    }

    public Airplane getAirplaneByID(String id) {
        return departures.keySet().stream().filter(plane -> plane.getId().equals(id)).findFirst().orElse(null);
    }
}
