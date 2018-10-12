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

}


