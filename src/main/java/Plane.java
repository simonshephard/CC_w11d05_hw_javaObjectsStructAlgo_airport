import java.util.ArrayList;

public class Plane {

    private PlaneType planeType;
    private Airline airline;
    private ArrayList<String> passengers;

    public Plane(PlaneType planeType, Airline airline) {
        this.planeType = planeType;
        this.airline = airline;
        this.passengers = new ArrayList<>();
    }

    public PlaneType getPlaneType() {
        return this.planeType;
    }

    public Airline getAirline() {
        return this.airline;
    }

    public int countPassengers(){
        return this.passengers.size();
    }

    public void addPassenger(String name){
        this.passengers.add(name);
    }

    public int findPassenger(String name) {
        return this.passengers.indexOf(name);
    }

    public int findPassengerLinear(String name) {
        for (int i = 0; i < this.passengers.size(); i++) {
            if (this.passengers.get(i) == name) {
                return i;
            }
        }
        return -1;
    }

}
