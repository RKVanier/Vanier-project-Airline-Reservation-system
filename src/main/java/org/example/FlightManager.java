package org.example;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class FlightManager {
    private List<Flight> flights;

    public FlightManager() {
        this.flights = new ArrayList<>();
    }

    public FlightManager(List<Flight> flights) {
        this.flights = flights;
    }

    public void addFlight(Flight flight) {
        flights.add(flight);
    }

    public List<Flight> getAvailableFlights() {
        List<Flight> available = new ArrayList<>();
        for (Flight flight : flights) {
            if (flight.getAvailableSeats() > 0) {
                available.add(flight);
            }
        }
        return available;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        FlightManager that = (FlightManager) o;
        return Objects.equals(flights, that.flights);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(flights);
    }

    @Override
    public String toString() {
        return "FlightManager{" +
                "flights=" + flights +
                '}';
    }

    public List<Flight> getFlights() {
        return flights;
    }

    public void setFlights(List<Flight> flights) {
        this.flights = flights;
    }
}
