import com.gridnine.testing.Flight;
import com.gridnine.testing.Segment;
import com.gridnine.testing.service.FlightFilter;
import com.gridnine.testing.service.FlightFilterImpl;
import org.junit.Test;

import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class FlightFilterTest {
    FlightFilter flightFilter = new FlightFilterImpl();
    LocalDateTime depDate = LocalDateTime.
            now().plusDays(3);
    public Flight flightOne = new Flight(List.
            of(new Segment(depDate, depDate.plusHours(2))));
    public Flight flightTwo = new Flight(List.
            of(new Segment(depDate, depDate.plusHours(2)),
                    new Segment(depDate.plusHours(3), depDate.plusHours(5))));
    public Flight flightThree = new Flight(List.
            of(new Segment(depDate.minusDays(6),depDate)));
    public Flight flightFour = new Flight(List.
            of(new Segment(depDate,depDate.minusHours(6))));
    public Flight flightFive = new Flight(List.
            of(new Segment(depDate, depDate.plusHours(2)),
                    new Segment(depDate.plusHours(5),depDate.plusHours(6))));
    public Flight flightSix = new Flight(List.
            of(new Segment(depDate, depDate.plusHours(2)),
                    new Segment(depDate.plusHours(3), depDate.plusHours(4)),
                    new Segment(depDate.plusHours(6), depDate.plusHours(7))));
    List<Flight> allFlights = Arrays.
            asList(flightOne, flightTwo, flightThree, flightFour, flightFive, flightSix);

    @Test
    public void departureBeforeCurrentTimeTest() {
        List<Flight> DepWithoutBeforeCurrentTime = Arrays.
                asList(flightOne,flightTwo, flightFour,flightFive,flightSix);
        List<Flight> expected = flightFilter.DepartureWithoutBeforeCurrentTime(allFlights);

        assertEquals(expected, DepWithoutBeforeCurrentTime);
    }

    @Test
    public void segmentArrivalBeforeDepartureTest() {
        List<Flight> segmentArrBeforeDep = Arrays.
                asList(flightOne,flightTwo, flightThree,flightFive,flightSix);
        List<Flight> expected = flightFilter.SegmentWithoutArrivalBeforeDeparture(allFlights);

        assertEquals(expected, segmentArrBeforeDep);
    }

    @Test
    public void flightOnEarthMoreTwoHoursTest() {
        List<Flight> flightOnEarthMoreTwoHours = Arrays.
                asList(flightOne,flightTwo, flightThree,flightFour,flightSix);
        List<Flight> expected = flightFilter.FlightWithoutOnEarthMoreTwoHours(allFlights);

        assertEquals(expected,flightOnEarthMoreTwoHours);
    }
}