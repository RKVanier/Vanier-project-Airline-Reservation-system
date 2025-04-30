package org.example;

public class Passenger extends User {
    private int passportNumber;
    private String nationality;
    private boolean ofAge;

    public Passenger() {
        super();
        this.passportNumber = 0;
        this.nationality = null;
        this.ofAge = false;
    }

    @Override
    public String getUserType() {
        return "Passenger";
    }

    public Passenger(String name, Gender gender, int passportNumber, String nationality, boolean ofAge) {
        super(name, gender);
        this.passportNumber = passportNumber;
        this.nationality = nationality;
        this.ofAge = ofAge;
    }
}
