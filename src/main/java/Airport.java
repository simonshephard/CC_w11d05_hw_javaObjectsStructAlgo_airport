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

}
