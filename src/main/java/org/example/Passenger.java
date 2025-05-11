package org.example;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Passenger extends User {
    private int passportNumber;
    private String nationality;
    private boolean ofAge;
    private List<Booking> bookedFlights;

    public Passenger() {
        super();
        this.passportNumber = 0;
        this.nationality = null;
        this.ofAge = false;
        this.bookedFlights = new ArrayList<>();
    }

    public Passenger(String name, Gender gender, int passportNumber, String nationality, boolean ofAge, List<Booking> bookedFlights) {
        super(name, gender);
        this.passportNumber = passportNumber;
        this.nationality = nationality;
        this.ofAge = ofAge;
        this.bookedFlights = bookedFlights;
    }

    /**
     * Requests to book a flight for the passenger.
     * This method represents a booking request initiated by the passenger.
     * The booking must be reviewed and authorized by an admin before it is finalized.
     */

    public void requestBooking(Flight flight, Admin admin) {
        if (flight != null && admin != null) {
            Booking booking = new Booking();
            booking.setFlight(flight);
            booking.setAdmin(admin);
            booking.getAdmin().reviewBooking(booking, this);
        }
    }

    /**
     * Requests to cancel a flight booking for the passenger.
     * This cancellation request should also be confirmed or processed by an admin
     * to update the system records accordingly.
     */
    public void requestCancel(Booking booking) {
        if (booking != null && bookedFlights.contains(booking)) {
            booking.getAdmin().reviewCancelling(booking, this);
        }
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Passenger passenger = (Passenger) o;
        return passportNumber == passenger.passportNumber && ofAge == passenger.ofAge && Objects.equals(nationality, passenger.nationality);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), passportNumber, nationality, ofAge);
    }

    @Override
    public String toString() {
        return "Passenger{" +
                "passportNumber=" + passportNumber +
                ", nationality='" + nationality + '\'' +
                ", ofAge=" + ofAge +
                ", name='" + name + '\'' +
                ", gender=" + gender +
                '}';
    }

    public int getPassportNumber() {
        return passportNumber;
    }

    public void setPassportNumber(int passportNumber) {
        this.passportNumber = passportNumber;
    }

    public String getNationality() {
        return nationality;
    }

    public void setNationality(String nationality) {
        this.nationality = nationality;
    }

    public boolean isOfAge() {
        return ofAge;
    }

    public void setOfAge(boolean ofAge) {
        this.ofAge = ofAge;
    }

    public List<Booking> getBookedFlights() {
        return bookedFlights;
    }

    public void setBookedFlights(List<Booking> bookedFlights) {
        this.bookedFlights = bookedFlights;
    }
}
