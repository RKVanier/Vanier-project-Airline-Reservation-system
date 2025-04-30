package org.example;

import java.util.Objects;

public class Pilot extends CrewMember{
    private boolean internationalLicense;
    private CockpitRole cockpitRole;

    public Pilot() {
        super();
        this.internationalLicense = false;
        this.cockpitRole = null;
    }

    public Pilot(String name, Gender gender, boolean internationalWorker, int flightsHours, boolean internationalLicense, CockpitRole cockpitRole) {
        super(name, gender, internationalWorker, flightsHours);
        this.internationalLicense = internationalLicense;
        this.cockpitRole = cockpitRole;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Pilot pilot = (Pilot) o;
        return internationalLicense == pilot.internationalLicense && cockpitRole == pilot.cockpitRole;
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), internationalLicense, cockpitRole);
    }

    @Override
    public String toString() {
        return "Pilot{" +
                "internationalLicense=" + internationalLicense +
                ", cockpitRole=" + cockpitRole +
                ", internationalWorker=" + internationalWorker +
                ", flightsHours=" + flightsHours +
                ", id=" + id +
                ", name='" + name + '\'' +
                ", gender=" + gender +
                '}';
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

    enum CockpitRole{
        PILOT, COPILOT
    }
}
