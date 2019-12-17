package fairGenerator;

public class MultipleRides {

    public MultipleRides(Ride[] rides) {
        this.rides = rides;
    }

    Ride[] rides = new Ride[10];

    public Ride[] getRides1() {
        return rides;
    }

    public void setRides1(Ride[] rides) {
        this.rides = rides;
    }

}
