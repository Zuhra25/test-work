package com.gridnine.testing;

import com.gridnine.testing.service.FlightFilter;
import com.gridnine.testing.service.FlightFilterImpl;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Flight> flights = FlightBuilder.createFlights();

        FlightFilterImpl filter = new FlightFilterImpl();


        System.out.printf("All flights:\n%s",flights);
        System.out.println();
        System.out.printf("DepartureBeforeCurrentTime:\n"+filter.DepartureBeforeCurrentTime(flights));
        System.out.println();
        System.out.printf("SegmentArrivalBeforeDeparture:\n"+filter.SegmentArrivalBeforeDeparture(flights));
        System.out.println();
        System.out.printf("FlightOnEarthMoreTwoHours:\n"+filter.FlightOnEarthMoreTwoHours(flights));




    }
}