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
        // use Java method for find
        return this.passengers.indexOf(name);
    }

    public int findPassengerLinear(String name) {
        // simple linear search - most efficient for unordered list O(n) - sorting would take O(nlogn)
        for (int i = 0; i < this.passengers.size(); i++) {
            if (this.passengers.get(i) == name) {
                return i;
            }
        }
        return -1;
    }

}
