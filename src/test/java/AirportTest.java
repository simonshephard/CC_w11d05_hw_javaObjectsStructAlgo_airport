import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class AirportTest {

    Airport airport;
    Plane plane;
    Flight flight;


    @Before
    public void before() {
        airport = new Airport("EDI");
        plane = new Plane(PlaneType.AIRBUSA320, Airline.BA);
        flight = new Flight(plane, FlightNumber.BA1880);
    }

    @Test
    public void getCode() {
        assertEquals("EDI", airport.getCode());
    }

    @Test
    public void countPlanes() {
        assertEquals(0, airport.countPlanes());
    }

    @Test
    public void canAddPlaneToHangar() {
        airport.addPlane(plane);
        assertEquals(1, airport.countPlanes());
    }

    @Test
    public void canRemovePlaneFromHangar() {
        airport.addPlane(plane);
        airport.removePlane(plane);
        assertEquals(0, airport.countPlanes());
    }

    @Test
    public void checkPlaneInHangarTrue() {
        airport.addPlane(plane);
        assertTrue(airport.checkPlaneInHangar(plane));
    }

    @Test
    public void checkPlaneInHangarFalse() {
        airport.addPlane(plane);
        Plane alternatePlane = new Plane(PlaneType.BOEING747, Airline.UNITEDAIRLINES);
        assertFalse(airport.checkPlaneInHangar(alternatePlane));
    }

    @Test
    public void canCreateFlight() {
        Flight newFlight = airport.createFlight(plane, FlightNumber.BA1881);
        assertEquals(PlaneType.AIRBUSA320, newFlight.getPlane().getPlaneType());
        assertEquals(4, newFlight.getPlane().getPlaneType().getCapacity());
        assertEquals(Airline.BA, newFlight.getPlane().getAirline());
        assertEquals(FlightNumber.BA1881, newFlight.getFlightNumber());
        assertEquals("Edinburgh", newFlight.getFlightNumber().getDestination());
    }

    @Test
    public void canAssignPlaneFromHangarToFlight() {
        Plane alternatePlane = new Plane(PlaneType.BOEING747, Airline.UNITEDAIRLINES);
        airport.addPlane(alternatePlane);
        airport.assignPlaneToFlight(alternatePlane, flight);
        // check hangar still has one plane
        assertEquals(1, airport.countPlanes());
        // ******** check old plane back in hangar
        assertTrue(airport.checkPlaneInHangar(plane));
        // ******** check alternate plane not in hangar
        assertFalse(airport.checkPlaneInHangar(alternatePlane));
        // check flight plane details changed
        assertEquals(PlaneType.BOEING747, flight.getPlane().getPlaneType());
        assertEquals(5, flight.getPlane().getPlaneType().getCapacity());
        assertEquals(Airline.UNITEDAIRLINES, flight.getPlane().getAirline());
        // check flight number details unchanged
        assertEquals(FlightNumber.BA1880, flight.getFlightNumber());
        assertEquals("London", flight.getFlightNumber().getDestination());
    }

    @Test
    public void canSellTicket() {
        String ticket = airport.sellTicket(flight, "Passenger57");
        assertEquals(1, flight.countPassengers());
        assertEquals("Passenger57", ticket);
    }

    @Test
    public void canSellTicketOnlyIfCapacity() {
        String ticket1 = airport.sellTicket(flight, "Passenger57");
        String ticket2 = airport.sellTicket(flight, "Passenger57");
        String ticket3 = airport.sellTicket(flight, "Passenger57");
        String ticket4 = airport.sellTicket(flight, "Passenger57");
        String ticket5 = airport.sellTicket(flight, "Passenger57");
        assertEquals(4, flight.countPassengers());
        assertNull(ticket5);
    }

    @Test
    public void findSmallestPlaneInHangarWithCapacityAtLeast4() {
        Plane plane1 = new Plane(PlaneType.AIRBUSA320, Airline.BA);
        Plane plane2 = new Plane(PlaneType.BOEING747, Airline.BA);
        airport.addPlane(plane1);
        airport.addPlane(plane2);
        assertEquals(plane1, airport.findSmallestPlaneInHangarWithCapacityAtLeast(4));
    }

    @Test
    public void findSmallestPlaneInHangarWithCapacityAtLeast5() {
        Plane plane1 = new Plane(PlaneType.AIRBUSA320, Airline.BA);
        Plane plane2 = new Plane(PlaneType.BOEING747, Airline.BA);
        airport.addPlane(plane1);
        airport.addPlane(plane2);
        assertEquals(plane2, airport.findSmallestPlaneInHangarWithCapacityAtLeast(5));
    }

    @Test
    public void findSmallestPlaneInHangarWithCapacityAtLeast6() {
        Plane plane1 = new Plane(PlaneType.AIRBUSA320, Airline.BA);
        Plane plane2 = new Plane(PlaneType.BOEING747, Airline.BA);
        airport.addPlane(plane1);
        airport.addPlane(plane2);
        assertNull(airport.findSmallestPlaneInHangarWithCapacityAtLeast(6));
    }

    @Test
    public void assignSmallestSufficientPlaneToFlight_3Tickets() {
        Plane plane0 = new Plane(PlaneType.BOEING787, Airline.BA);
        Plane plane1 = new Plane(PlaneType.AIRBUSA320, Airline.BA);
        Plane plane2 = new Plane(PlaneType.BOEING747, Airline.BA);
        Flight flight0 = new Flight(plane0, FlightNumber.CA5648);
        airport.addPlane(plane1);
        airport.addPlane(plane2);
        String ticket1 = airport.sellTicket(flight0, "Passenger57");
        String ticket2 = airport.sellTicket(flight0, "Passenger57");
        airport.assignSmallestSufficientPlaneToFlight(flight0);
        assertEquals(plane1, flight0.getPlane());
    }

    @Test
    public void assignSmallestSufficientPlaneToFlight_5Tickets() {
        Plane plane0 = new Plane(PlaneType.BOEING787, Airline.BA);
        Plane plane1 = new Plane(PlaneType.AIRBUSA320, Airline.BA);
        Plane plane2 = new Plane(PlaneType.BOEING747, Airline.BA);
        Flight flight0 = new Flight(plane0, FlightNumber.CA5648);
        airport.addPlane(plane1);
        airport.addPlane(plane2);
        String ticket1 = airport.sellTicket(flight0, "Passenger57");
        String ticket2 = airport.sellTicket(flight0, "Passenger57");
        String ticket3 = airport.sellTicket(flight0, "Passenger57");
        String ticket4 = airport.sellTicket(flight0, "Passenger57");
        String ticket5 = airport.sellTicket(flight0, "Passenger57");
        airport.assignSmallestSufficientPlaneToFlight(flight0);
        assertEquals(plane2, flight0.getPlane());
    }

    @Test
    public void assignSmallestSufficientPlaneToFlight_7Tickets() {
        Plane plane0 = new Plane(PlaneType.BOEING787, Airline.BA);
        Plane plane1 = new Plane(PlaneType.AIRBUSA320, Airline.BA);
        Plane plane2 = new Plane(PlaneType.BOEING747, Airline.BA);
        Flight flight0 = new Flight(plane0, FlightNumber.CA5648);
        airport.addPlane(plane1);
        airport.addPlane(plane2);
        String ticket1 = airport.sellTicket(flight0, "Passenger57");
        String ticket2 = airport.sellTicket(flight0, "Passenger57");
        String ticket3 = airport.sellTicket(flight0, "Passenger57");
        String ticket4 = airport.sellTicket(flight0, "Passenger57");
        String ticket5 = airport.sellTicket(flight0, "Passenger57");
        String ticket6 = airport.sellTicket(flight0, "Passenger57");
        String ticket7 = airport.sellTicket(flight0, "Passenger57");
        airport.assignSmallestSufficientPlaneToFlight(flight0);
        assertEquals(plane0, flight0.getPlane());
    }

    @Test
    public void findPassenger() {
        Plane plane0 = new Plane(PlaneType.BOEING787, Airline.BA);
        Flight flight0 = new Flight(plane0, FlightNumber.CA5648);
        airport.sellTicket(flight0, "Passenger60");
        airport.sellTicket(flight0, "Passenger57");
        airport.sellTicket(flight0, "Passenger59");
        airport.sellTicket(flight0, "Passenger61");
        airport.sellTicket(flight0, "Passenger64");
        airport.sellTicket(flight0, "Passenger58");
        airport.sellTicket(flight0, "Passenger66");
        airport.sellTicket(flight0, "Passenger62");
        airport.sellTicket(flight0, "Passenger65");
        airport.sellTicket(flight0, "Passenger63");
        assertEquals(5, airport.findPassenger(flight0,"Passenger58"));
    }

    @Test
    public void findPassengerNotOnPlane() {
        Plane plane0 = new Plane(PlaneType.BOEING787, Airline.BA);
        Flight flight0 = new Flight(plane0, FlightNumber.CA5648);
        airport.sellTicket(flight0, "Passenger60");
        airport.sellTicket(flight0, "Passenger57");
        airport.sellTicket(flight0, "Passenger59");
        airport.sellTicket(flight0, "Passenger61");
        airport.sellTicket(flight0, "Passenger64");
        airport.sellTicket(flight0, "Passenger58");
        airport.sellTicket(flight0, "Passenger66");
        airport.sellTicket(flight0, "Passenger62");
        airport.sellTicket(flight0, "Passenger65");
        airport.sellTicket(flight0, "Passenger63");
        assertEquals(-1, airport.findPassenger(flight0, "Passenger70"));
    }


}
