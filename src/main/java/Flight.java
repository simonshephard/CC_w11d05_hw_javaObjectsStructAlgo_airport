public class Flight {

    private Plane plane;
    private FlightNumber flightNumber;

    public Flight(Plane plane, FlightNumber flightNumber) {
        this.plane = plane;
        this.flightNumber = flightNumber;
    };

    public Plane getPlane() {
        return this.plane;
    }

    public FlightNumber getFlightNumber() {
        return this.flightNumber;
    }

    public void changePlane(Plane alternatePlane) {
        this.plane = alternatePlane;
    }

    public int countPassengers() {
        return this.plane.countPassengers();
    }

    public void addPassenger(String name) {
        this.plane.addPassenger(name);
    }

}
