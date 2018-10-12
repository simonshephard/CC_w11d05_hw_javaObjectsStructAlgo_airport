import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class FlightTest {

    Flight flight;
    Plane plane;

    @Before
    public void before() {
        plane = new Plane(PlaneType.AIRBUSA320, Airline.BA);
        flight = new Flight(plane, FlightNumber.BA1880);
    }

    @Test
    public void getPlane() {
        assertEquals(PlaneType.AIRBUSA320, flight.getPlane().getPlaneType());
        assertEquals(4, flight.getPlane().getPlaneType().getCapacity());
        assertEquals(Airline.BA, flight.getPlane().getAirline());
    }

    @Test
    public void getFlightNumber() {
        assertEquals(FlightNumber.BA1880, flight.getFlightNumber());
        assertEquals("London", flight.getFlightNumber().getDestination());
    }

    @Test
    public void changePlane() {
        Plane alternatePlane = new Plane(PlaneType.BOEING747, Airline.UNITEDAIRLINES);
        flight.changePlane(alternatePlane);
        // check flight plane details changed
        assertEquals(PlaneType.BOEING747, flight.getPlane().getPlaneType());
        assertEquals(5, flight.getPlane().getPlaneType().getCapacity());
        assertEquals(Airline.UNITEDAIRLINES, flight.getPlane().getAirline());
        // check flight number details unchanged
        assertEquals(FlightNumber.BA1880, flight.getFlightNumber());
        assertEquals("London", flight.getFlightNumber().getDestination());
    }

    @Test
    public void countPassenger() {
        assertEquals(0, flight.countPassengers());
    }

    @Test
    public void addPassenger() {
        flight.addPassenger("Passenger57");
        assertEquals(1, flight.countPassengers());
    }

}


