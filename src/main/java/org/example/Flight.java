package org.example;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public abstract class Flight {
    protected int flightId;
    protected LocalDateTime departureDateTime;
    protected LocalDateTime arrivalDateTime;
    protected String origin;
    protected String destination;
    protected double price;
    protected int availableSeats;
    protected List<Passenger> passengers;
    protected List<CrewMember> crewMembers;

    protected static int nextId = 1;

    public Flight() {
        this.flightId = nextId++;
        this.departureDateTime = null;
        this.arrivalDateTime = null;
        this.origin = null;
        this.destination = null;
        this.price = 0;
        this.availableSeats = 0;
        this.passengers = new ArrayList<>();
        this.crewMembers = new ArrayList<>();
    }

    public Flight(LocalDateTime departureDateTime, LocalDateTime arrivalDateTime, String origin, String destination, double price, int availableSeats, List<Passenger> passengers, List<CrewMember> crewMembers) {
        this.flightId = nextId++;
        this.departureDateTime = departureDateTime;
        this.arrivalDateTime = arrivalDateTime;
        this.origin = origin;
        this.destination = destination;
        this.price = price;
        this.availableSeats = availableSeats;
        this.passengers = passengers;
        this.crewMembers = crewMembers;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Flight flight = (Flight) o;
        return flightId == flight.flightId && Double.compare(price, flight.price) == 0 && availableSeats == flight.availableSeats && Objects.equals(departureDateTime, flight.departureDateTime) && Objects.equals(arrivalDateTime, flight.arrivalDateTime) && Objects.equals(origin, flight.origin) && Objects.equals(destination, flight.destination) && Objects.equals(passengers, flight.passengers) && Objects.equals(crewMembers, flight.crewMembers);
    }

    @Override
    public int hashCode() {
        return Objects.hash(flightId, departureDateTime, arrivalDateTime, origin, destination, price, availableSeats, passengers, crewMembers);
    }

    @Override
    public String toString() {
        return "Flight{" +
                "flightId=" + flightId +
                ", departureDateTime=" + departureDateTime +
                ", arrivalDateTime=" + arrivalDateTime +
                ", origin='" + origin + '\'' +
                ", destination='" + destination + '\'' +
                ", price=" + price +
                ", availableSeats=" + availableSeats +
                ", passengers=" + passengers +
                ", crewMembers=" + crewMembers +
                '}';
    }

    public int getFlightId() {
        return flightId;
    }

    public void setFlightId(int flightId) {
        this.flightId = flightId;
    }

    public LocalDateTime getDepartureDateTime() {
        return departureDateTime;
    }

    public void setDepartureDateTime(LocalDateTime departureDateTime) {
        this.departureDateTime = departureDateTime;
    }

    public LocalDateTime getArrivalDateTime() {
        return arrivalDateTime;
    }

    public void setArrivalDateTime(LocalDateTime arrivalDateTime) {
        this.arrivalDateTime = arrivalDateTime;
    }

    public String getOrigin() {
        return origin;
    }

    public void setOrigin(String origin) {
        this.origin = origin;
    }

    public String getDestination() {
        return destination;
    }

    public void setDestination(String destination) {
        this.destination = destination;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getAvailableSeats() {
        return availableSeats;
    }

    public void setAvailableSeats(int availableSeats) {
        this.availableSeats = availableSeats;
    }

    public List<Passenger> getPassengers() {
        return passengers;
    }

    public void setPassengers(List<Passenger> passengers) {
        this.passengers = passengers;
    }

    public List<CrewMember> getCrewMembers() {
        return crewMembers;
    }

    public void setCrewMembers(List<CrewMember> crewMembers) {
        this.crewMembers = crewMembers;
    }
}
