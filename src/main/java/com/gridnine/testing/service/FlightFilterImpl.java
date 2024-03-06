package com.gridnine.testing.service;

import com.gridnine.testing.Flight;
import com.gridnine.testing.Segment;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class FlightFilterImpl implements FlightFilter {
    @Override
    public List<Flight> DepartureBeforeCurrentTime(List<Flight> flights) {
        List<Flight> flightsNew = flights.stream()
                .filter(flight -> flight.getSegments().stream()
                        .anyMatch(segment -> segment.getDepartureDate().isAfter(LocalDateTime.now()))
                )
                .collect(Collectors.toList());
        return flightsNew;
    }

    @Override
    public List<Flight> SegmentArrivalBeforeDeparture(List<Flight> flights) {
        List<Flight> flightsNew = flights.stream()
                .filter(flight -> flight.getSegments().stream()
                        .anyMatch(segment -> segment.getArrivalDate().isBefore(segment.getDepartureDate())))
                .collect(Collectors.toList());
        return flightsNew;
    }
    @Override
    public List<Flight> FlightOnEarthMoreTwoHours(List<Flight> flights) {
        List<Flight> flightsNew = new ArrayList<>();
        for (Flight flight : flights) {
            List<Segment> segments = flight.getSegments();
            for (int i = 0; i < segments.size() - 1; i++) {
                LocalDateTime depTime = segments.get(i + 1).getDepartureDate();
                LocalDateTime arrTime = segments.get(i).getArrivalDate();
                if (depTime.isAfter(arrTime.plusHours(2)) || depTime.isEqual(arrTime.plusHours(2))) {
                    flightsNew.add(flight);
                }
            }
        }
        return flightsNew;
    }
}
