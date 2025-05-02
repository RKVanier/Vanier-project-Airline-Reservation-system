package org.example;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Objects;

public class DomesticFlight extends Flight {
    private String country;

    public DomesticFlight() {
        super();
        this.country = null;
    }

    public DomesticFlight(LocalDateTime departureDateTime, LocalDateTime arrivalDateTime, String origin, String destination, double price, int availableSeats, List<Passenger> passengers, List<CrewMember> crewMembers, String country) {
        super(departureDateTime, arrivalDateTime, origin, destination, price, availableSeats, passengers, crewMembers);
        this.country = country;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        DomesticFlight that = (DomesticFlight) o;
        return Objects.equals(country, that.country);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), country);
    }

    @Override
    public String toString() {
        return "DomesticFlight{" +
                "country='" + country + '\'' +
                ", flightId=" + flightId +
                ", departureDateTime=" + departureDateTime +
                ", arrivalDateTime=" + arrivalDateTime +
                ", origin='" + origin + '\'' +
                ", destination='" + destination + '\'' +
                ", price=" + price +
                ", availableSeats=" + availableSeats +
                ", passengers=" + passengers +
                '}';
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }
}
