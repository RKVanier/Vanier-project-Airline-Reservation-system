package org.example;

import java.util.Objects;

public class CrewMember extends User implements Comparable<CrewMember>{
    protected boolean internationalWorker;
    protected int flightsHours;

    public CrewMember() {
        super();
        this.internationalWorker = false;
        this.flightsHours = 0;
    }

    public CrewMember(String name, Gender gender, boolean internationalWorker, int flightsHours) {
        super(name, gender);
        this.internationalWorker = internationalWorker;
        this.flightsHours = flightsHours;
    }

    @Override
    public int compareTo(CrewMember other) {
        return this.flightsHours - other.flightsHours;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        CrewMember that = (CrewMember) o;
        return internationalWorker == that.internationalWorker && flightsHours == that.flightsHours;
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), internationalWorker, flightsHours);
    }

    @Override
    public String toString() {
        return "CrewMember{" +
                "internationalWorker=" + internationalWorker +
                ", flightsHours=" + flightsHours +
                ", name='" + name + '\'' +
                ", gender=" + gender +
                '}';
    }

    public boolean isInternationalWorker() {
        return internationalWorker;
    }

    public void setInternationalWorker(boolean internationalWorker) {
        this.internationalWorker = internationalWorker;
    }

    public int getFlightsHours() {
        return flightsHours;
    }

    public void setFlightsHours(int flightsHours) {
        this.flightsHours = flightsHours;
    }
}
