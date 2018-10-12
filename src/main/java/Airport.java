import java.util.ArrayList;

public class Airport {

    private String code;
    private ArrayList<Plane> hangar;

    public Airport (String code) {
        this.code = code;
        this.hangar = new ArrayList<>();
    }

    public String getCode() {
        return this.code;
    }

    public int countPlanes() {
        return this.hangar.size();
    }

    public void addPlane(Plane plane) {
        this.hangar.add(plane);
    }

    public void removePlane(Plane plane) {
        int index = hangar.indexOf(plane);
        this.hangar.remove(index);
    }

    public boolean checkPlaneInHangar(Plane plane) {
        return this.hangar.contains(plane);
    }

    public Flight createFlight(Plane plane, FlightNumber flightNumber) {
        Flight newFlight = new Flight(plane, flightNumber);
        return newFlight;
    }

    public void assignPlaneToFlight(Plane alternatePlane, Flight flight) {
        removePlane(alternatePlane);
        addPlane(flight.getPlane());
        flight.changePlane(alternatePlane);
    }

    public String sellTicket(Flight flight, String name) {
        int capacity = flight.getPlane().getPlaneType().getCapacity();
        if (flight.countPassengers() < capacity) {
            flight.addPassenger(name);
            return name;
        }
        return null;
    }

    public Plane findSmallestPlaneInHangarWithCapacityAtLeast(int limit) {
        if (countPlanes() < 1) {return null;}
        Plane smallest = null;
        int minCapacity = 1000000;
        for (Plane plane : this.hangar) {
            int planeCapacity = plane.getPlaneType().getCapacity();
            if (planeCapacity >= limit && planeCapacity < minCapacity) {
                smallest = plane;
                minCapacity = planeCapacity;
            }
        }
        return smallest;
    }

    public void assignSmallestSufficientPlaneToFlight(Flight flight) {
        int requiredCapacity = flight.countPassengers();
        int currentCapacity = flight.getPlane().getPlaneType().getCapacity();
        Plane bestPlaneInHangar = findSmallestPlaneInHangarWithCapacityAtLeast(requiredCapacity);
        if (bestPlaneInHangar != null && bestPlaneInHangar.getPlaneType().getCapacity() < currentCapacity) {
            assignPlaneToFlight(bestPlaneInHangar, flight);
        }
    }

}
