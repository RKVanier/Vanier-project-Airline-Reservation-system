package org.example;

import java.util.Objects;

public abstract class User {
    protected int id;
    protected String name;
    protected Gender gender;

    protected static int nextId = 1;

    public User() {
        this.id = nextId++;
        this.name = null;
        this.gender = null;
    }

    public User(String name, Gender gender) {
        this.id = nextId++;
        this.name = name;
        this.gender = gender;
    }

    public abstract String getUserType();

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return id == user.id && nextId == user.nextId && Objects.equals(name, user.name) && gender == user.gender;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, gender, nextId);
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", gender=" + gender +
                ", nextId=" + nextId +
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

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    enum Gender {
        MALE, FEMALE
    }
}
