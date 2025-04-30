package org.example;

public abstract class User {
    protected int id;
    protected String name;
    protected  int passportNumber;
    protected Gender gender;
    protected String nationality;






    enum Gender {
        MALE, FEMALE
    }
}
