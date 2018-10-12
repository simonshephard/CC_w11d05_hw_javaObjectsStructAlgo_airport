import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class AirportTest {

    Airport airport;

    @Before
    public void before() {
        airport = new Airport("EDI");
    }

    @Test
    public void getCode() {
        assertEquals("EDI", airport.getCode());
    }

    @Test
    public void countPlanes() {
        assertEquals(0, airport.countPlanes());
    }

}
