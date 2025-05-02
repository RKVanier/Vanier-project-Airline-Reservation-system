package org.example;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Objects;

public class InternationalFlight extends Flight {
    private boolean visaRequired;

    public InternationalFlight() {
        super();
        this.visaRequired = false;
    }

    public InternationalFlight(LocalDateTime departureDateTime, LocalDateTime arrivalDateTime, String origin, String destination, double price, int availableSeats, List<Passenger> passengers, List<CrewMember> crewMembers, boolean visaRequired) {
        super(departureDateTime, arrivalDateTime, origin, destination, price, availableSeats, passengers, crewMembers);
        this.visaRequired = visaRequired;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        InternationalFlight that = (InternationalFlight) o;
        return visaRequired == that.visaRequired;
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), visaRequired);
    }

    @Override
    public String toString() {
        return "InternationalFlight{" +
                "visaRequired=" + visaRequired +
                ", flightId=" + flightId +
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

    public boolean isVisaRequired() {
        return visaRequired;
    }

    public void setVisaRequired(boolean visaRequired) {
        this.visaRequired = visaRequired;
    }
}
