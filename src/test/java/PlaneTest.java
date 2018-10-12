import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class PlaneTest {

    Plane plane;

    @Before
    public void before() {
        plane = new Plane(PlaneType.AIRBUSA320, Airline.BA);
    }

    @Test
    public void getPlaneType() {
        assertEquals(PlaneType.AIRBUSA320, plane.getPlaneType());
        assertEquals(4, plane.getPlaneType().getCapacity());
    }

    @Test
    public void getAirline() {
        assertEquals(Airline.BA, plane.getAirline());
    }

    @Test
    public void countPassengers() {
        assertEquals(0, plane.countPassengers());
    }

    @Test
    public void addPassenger() {
        plane.addPassenger("Passenger57");
        assertEquals(1, plane.countPassengers());
    }

    @Test
    public void findPassenger() {
        plane.addPassenger("Passenger60");
        plane.addPassenger("Passenger57");
        plane.addPassenger("Passenger59");
        plane.addPassenger("Passenger61");
        plane.addPassenger("Passenger64");
        plane.addPassenger("Passenger58");
        plane.addPassenger("Passenger66");
        plane.addPassenger("Passenger62");
        plane.addPassenger("Passenger65");
        plane.addPassenger("Passenger63");
        assertEquals(5, plane.findPassenger("Passenger58"));
    }

    @Test
    public void findPassengerNotOnPlane() {
        plane.addPassenger("Passenger60");
        plane.addPassenger("Passenger57");
        plane.addPassenger("Passenger59");
        plane.addPassenger("Passenger61");
        plane.addPassenger("Passenger64");
        plane.addPassenger("Passenger58");
        plane.addPassenger("Passenger66");
        plane.addPassenger("Passenger62");
        plane.addPassenger("Passenger65");
        plane.addPassenger("Passenger63");
        assertEquals(-1, plane.findPassenger("Passenger70"));
    }

    @Test
    public void findPassengerLinear() {
        plane.addPassenger("Passenger60");
        plane.addPassenger("Passenger57");
        plane.addPassenger("Passenger59");
        plane.addPassenger("Passenger61");
        plane.addPassenger("Passenger64");
        plane.addPassenger("Passenger58");
        plane.addPassenger("Passenger66");
        plane.addPassenger("Passenger62");
        plane.addPassenger("Passenger65");
        plane.addPassenger("Passenger63");
        assertEquals(5, plane.findPassengerLinear("Passenger58"));
    }

    @Test
    public void findPassengerNotOnPlaneLinear() {
        plane.addPassenger("Passenger60");
        plane.addPassenger("Passenger57");
        plane.addPassenger("Passenger59");
        plane.addPassenger("Passenger61");
        plane.addPassenger("Passenger64");
        plane.addPassenger("Passenger58");
        plane.addPassenger("Passenger66");
        plane.addPassenger("Passenger62");
        plane.addPassenger("Passenger65");
        plane.addPassenger("Passenger63");
        assertEquals(-1, plane.findPassengerLinear("Passenger70"));
    }


}
