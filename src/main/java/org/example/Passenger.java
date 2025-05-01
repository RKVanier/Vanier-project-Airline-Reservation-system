package org.example;

import java.util.Objects;

public class Passenger extends User {
    private int passportNumber;
    private String nationality;
    private boolean ofAge;
    private int seatNumber;

    public Passenger() {
        super();
        this.passportNumber = 0;
        this.nationality = null;
        this.ofAge = false;
        this.seatNumber = 0;
    }

    public Passenger(int passportNumber, String nationality, boolean ofAge, int seatNumber) {
        this.passportNumber = passportNumber;
        this.nationality = nationality;
        this.ofAge = ofAge;
        this.seatNumber = seatNumber;
    }

    public Passenger(String name, Gender gender, int passportNumber, String nationality, boolean ofAge, int seatNumber) {
        super(name, gender);
        this.passportNumber = passportNumber;
        this.nationality = nationality;
        this.ofAge = ofAge;
        this.seatNumber = seatNumber;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Passenger passenger = (Passenger) o;
        return passportNumber == passenger.passportNumber && ofAge == passenger.ofAge && seatNumber == passenger.seatNumber && Objects.equals(nationality, passenger.nationality);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), passportNumber, nationality, ofAge, seatNumber);
    }

    @Override
    public String toString() {
        return "Passenger{" +
                "passportNumber=" + passportNumber +
                ", nationality='" + nationality + '\'' +
                ", ofAge=" + ofAge +
                ", seatNumber=" + seatNumber +
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
}
