package org.example;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class FlightManager {
    private static List<Flight> flights = new ArrayList<>();

    public FlightManager(List<Flight> flights) {
        this.flights = flights;
    }

    /**
     * Adds a flight to the list of flights
     * @param flight
     */
    public static void addFlight(Flight flight) {
        flights.add(flight);
    }

    /**
     * Finds all the flights that have still available seats and put them in a list
     * @return available which is a list of flights that have available space for one more passenger at least
     */
    public static List<Flight> getAvailableFlights() {
        List<Flight> available = new ArrayList<>();
        for (Flight flight : flights) {
            if (flight != null) {
                if (flight.getAvailableSeats() > 0) {
                    available.add(flight);
                }
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

    public static List<Flight> getFlights() {
        return flights;
    }

    public void setFlights(List<Flight> flights) {
        this.flights = flights;
    }
}
