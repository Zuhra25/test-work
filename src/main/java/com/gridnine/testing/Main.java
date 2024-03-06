package com.gridnine.testing;

import com.gridnine.testing.service.FlightFilterImpl;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Flight> flights = FlightBuilder.createFlights();

        FlightFilterImpl filter = new FlightFilterImpl();

        System.out.printf("All flights:\n%s",flights);
        System.out.println();
        System.out.printf("DepartureWithoutBeforeCurrentTime:\n"+filter.DepartureWithoutBeforeCurrentTime(flights));
        System.out.println();
        System.out.printf("SegmentWithoutArrivalBeforeDeparture:\n"+filter.SegmentWithoutArrivalBeforeDeparture(flights));
        System.out.println();
        System.out.printf("FlightWithoutOnEarthMoreTwoHours:\n"+filter.FlightWithoutOnEarthMoreTwoHours(flights));




    }
}