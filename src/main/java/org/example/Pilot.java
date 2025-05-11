package org.example;

import java.util.Objects;

public class Pilot extends CrewMember{
    private int pilotId;
    private boolean internationalLicense;
    private CockpitRole cockpitRole;

    private static int nextId = 1;

    public Pilot() {
        super();
        this.pilotId = nextId++;
        this.internationalLicense = false;
        this.cockpitRole = null;
    }

    public Pilot(String name, Gender gender, boolean internationalWorker, int flightsHours, boolean internationalLicense, CockpitRole cockpitRole) {
        super(name, gender, internationalWorker, flightsHours);
        this.pilotId = nextId++;
        this.internationalLicense = internationalLicense;
        this.cockpitRole = cockpitRole;
    }

    @Override
    public int compareTo(CrewMember other) {
        if (other instanceof Pilot pilot) {
            return this.pilotId - ((Pilot) other).pilotId;
        }
        return super.compareTo(other);
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Pilot pilot = (Pilot) o;
        return pilotId == pilot.pilotId && internationalLicense == pilot.internationalLicense && cockpitRole == pilot.cockpitRole;
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), pilotId, internationalLicense, cockpitRole);
    }

    @Override
    public String toString() {
        return "Pilot{" +
                "pilotId=" + pilotId +
                ", internationalLicense=" + internationalLicense +
                ", cockpitRole=" + cockpitRole +
                ", internationalWorker=" + internationalWorker +
                ", flightsHours=" + flightsHours +
                ", name='" + name + '\'' +
                ", gender=" + gender +
                '}';
    }

    public int getPilotId() {
        return pilotId;
    }

    public void setPilotId(int pilotId) {
        this.pilotId = pilotId;
    }

    public boolean isInternationalLicense() {
        return internationalLicense;
    }

    public void setInternationalLicense(boolean internationalLicense) {
        this.internationalLicense = internationalLicense;
    }

    public CockpitRole getCockpitRole() {
        return cockpitRole;
    }

    public void setCockpitRole(CockpitRole cockpitRole) {
        this.cockpitRole = cockpitRole;
    }

   public enum CockpitRole{
        PILOT, COPILOT
    }
}
