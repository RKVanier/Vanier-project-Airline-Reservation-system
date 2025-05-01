package org.example;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Admin extends User implements Bookable{
    private int id;
    private List<Booking> managedBookings;

    private static int nextId = 1;

    public Admin() {
        this.id = nextId++;
        this.managedBookings = new ArrayList<>();
    }

    public Admin(String name, Gender gender, int id, List<Booking> managedBookings) {
        super(name, gender);
        this.id = nextId++;
        this.managedBookings = managedBookings;
    }

    /**
     * Change the status of the booking as only the Admin can do this (Confirmed status)
     * and adds it to the bookings
     */
    @Override
    public void book() {

    }

    /**
     * Change the status of the booking as only the Admin can do this (Canceled status)
     * and adds it to the booking
     */
    @Override
    public void cancel() {

    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Admin admin = (Admin) o;
        return id == admin.id && Objects.equals(managedBookings, admin.managedBookings);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), id, managedBookings);
    }

    @Override
    public String toString() {
        return "Admin{" +
                "id=" + id +
                ", managedBookings=" + managedBookings +
                ", name='" + name + '\'' +
                ", gender=" + gender +
                '}';
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public List<Booking> getManagedBookings() {
        return managedBookings;
    }

    public void setManagedBookings(List<Booking> managedBookings) {
        this.managedBookings = managedBookings;
    }
}
