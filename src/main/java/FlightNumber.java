public enum FlightNumber {

    BA1880("London"),
    BA1881("Edinburgh"),
    CA5648("Toronto"),
    CA5649("Glasgow"),
    EJ3001("Madrid"),
    EJ3002("Edinburgh"),
    EM1934("Dubai"),
    EM1935("Glasgow"),
    RA2000("Dublin"),
    RA2001("Edinburgh"),
    UA7054("NewYork"),
    UA7055("Glasgow");

    private final String destination;

    FlightNumber(String destination) {
        this.destination = destination;
    }

    public String getDestination() {
        return this.destination;
    }


}
