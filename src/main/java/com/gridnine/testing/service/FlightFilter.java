package com.gridnine.testing.service;

import com.gridnine.testing.Flight;

import java.util.List;

public interface FlightFilter {
    public List<Flight> DepartureBeforeCurrentTime(List<Flight> flights);

    public List<Flight> SegmentArrivalBeforeDeparture(List<Flight> flights);
    public List<Flight> FlightOnEarthMoreTwoHours(List<Flight> flights);

}
