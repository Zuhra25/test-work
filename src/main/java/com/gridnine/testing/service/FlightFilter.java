package com.gridnine.testing.service;

import com.gridnine.testing.Flight;

import java.util.List;

public interface FlightFilter {
    public List<Flight> DepartureWithoutBeforeCurrentTime(List<Flight> flights);
    public List<Flight> SegmentWithoutArrivalBeforeDeparture(List<Flight> flights);
    public List<Flight> FlightWithoutOnEarthMoreTwoHours(List<Flight> flights);
}
