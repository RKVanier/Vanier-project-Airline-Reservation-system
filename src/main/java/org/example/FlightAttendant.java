package org.example;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class FlightAttendant extends CrewMember {
    private int attendantId;
    private Role role;
    private List<String> languages;

    private static int nextId = 1;

    public FlightAttendant() {
        super();
        this.attendantId = nextId++;
        this.role = null;
        this.languages = new ArrayList<>();
    }

    public FlightAttendant(String name, Gender gender, boolean internationalWorker, int flightsHours, Role role, List<String> languages) {
        super(name, gender, internationalWorker, flightsHours);
        this.attendantId = nextId++;
        this.role = role;
        this.languages = languages;
    }

    @Override
    public int compareTo(CrewMember other) {

        if (other instanceof FlightAttendant flightAttendant) {
            return this.attendantId - flightAttendant.attendantId;
        }
        return super.compareTo(other);
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        FlightAttendant that = (FlightAttendant) o;
        return attendantId == that.attendantId && role == that.role && Objects.equals(languages, that.languages);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), attendantId, role, languages);
    }

    @Override
    public String toString() {
        return "FlightAttendant{" +
                "attendantId=" + attendantId +
                ", role=" + role +
                ", languages=" + languages +
                ", internationalWorker=" + internationalWorker +
                ", flightsHours=" + flightsHours +
                ", name='" + name + '\'' +
                ", gender=" + gender +
                '}';
    }

    public int getAttendantId() {
        return attendantId;
    }

    public void setAttendantId(int attendantId) {
        this.attendantId = attendantId;
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

    public enum Role {
        SECURITY, COOK, ASSISTANCE, EMERGENCY
    }
}
