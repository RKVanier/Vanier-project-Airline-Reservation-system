package org.example;

import java.time.LocalDateTime;
import java.util.List;

public abstract class Flight {
    protected int flightNumber;
    protected LocalDateTime departureDateTime;
    protected LocalDateTime arrivalDateTime;
    protected String origin;
    protected String destination;
    protected double price;
}
