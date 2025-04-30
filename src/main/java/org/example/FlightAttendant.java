package org.example;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class FlightAttendant extends CrewMember{
    private Role role;
    private List<String> languages;

    public FlightAttendant() {
        super();
        this.role = null;
        this.languages = new ArrayList<>();
    }

    public FlightAttendant(String name, Gender gender, boolean internationalWorker, int flightsHours, Role role, List<String> languages) {
        super(name, gender, internationalWorker, flightsHours);
        this.role = role;
        this.languages = languages;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        FlightAttendant that = (FlightAttendant) o;
        return role == that.role && Objects.equals(languages, that.languages);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), role, languages);
    }

    @Override
    public String toString() {
        return "FlightAttendant{" +
                "role=" + role +
                ", languages=" + languages +
                ", internationalWorker=" + internationalWorker +
                ", flightsHours=" + flightsHours +
                ", id=" + id +
                ", name='" + name + '\'' +
                ", gender=" + gender +
                '}';
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    public List<String> getLanguages() {
        return languages;
    }

    public void setLanguages(List<String> languages) {
        this.languages = languages;
    }

    enum Role {
        SECURITY, COOK, ASSISTANCE, EMERGENCY
    }
}
