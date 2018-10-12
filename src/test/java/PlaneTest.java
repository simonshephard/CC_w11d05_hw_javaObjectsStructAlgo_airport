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

}
