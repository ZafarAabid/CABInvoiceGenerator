package fairGenerator;

;

public class Ride {
    Double distance;
    Double time;

    public Double getDistance() {
        return distance;
    }

    public void setDistance(Double distance) {
        this.distance = distance;
    }

    public Double getTime() {
        return time;
    }

    public void setTime(Double time) {
        this.time = time;
    }

    public Ride(double distance, double time) {
        this.distance = distance;
        this.time = time;
    }
}
