public enum PlaneType {

    AIRBUSA320(4),
    AIRBUSA340(9),
    BOEING747(5),
    BOEING787(10),
    EMBRAER175(3),
    EMBRAER185(8);

    private final int capacity;

    PlaneType(int capacity) {
        this.capacity = capacity;
    }

    public int getCapacity() {
        return this.capacity;
    }

}
