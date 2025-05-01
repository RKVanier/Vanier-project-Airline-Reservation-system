package org.example;

import java.util.Objects;

public class User {
    protected String name;
    protected Gender gender;

    public User() {
        this.name = null;
        this.gender = null;
    }

    public User(String name, Gender gender) {
        this.name = name;
        this.gender = gender;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return Objects.equals(name, user.name) && gender == user.gender;
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, gender);
    }

    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                ", gender=" + gender +
                '}';
    }

    public Gender getGender() {
        return gender;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public enum Gender {
        MALE, FEMALE
    }
}
