package me.alextodea.FlightControl.domain;

public class Flight {
    private Airplane airplane;
    private String departureAirport;
    private String targetAirport;

    public Flight(Airplane airplane, String departureAirport, String targetAirport) {
        this.airplane = airplane;
        this.departureAirport = departureAirport;
        this.targetAirport = targetAirport;
    }

    public Airplane getAirplane() {
        return this.airplane;
    }

    public String getDepartureAirport() {
        return this.departureAirport;
    }

    public String getTargetAirport() {
        return this.targetAirport;
    }

    public String toString() {
        return this.airplane.getId() + " (" + this.departureAirport + "-" + this.targetAirport + ")";
    }
}
