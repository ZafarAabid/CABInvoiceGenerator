package fairGenerator;

import java.util.*;

public class RideRepository {
    public Map<String, List<Ride>> userRides;

    public RideRepository() {
        this.userRides = new HashMap<>();
    }

    public void addRides(String userId, Ride[] rides) {
        List<Ride> rideList = Arrays.asList(rides);
        this.userRides.put(userId, rideList);
    }

    public Ride[] getRides(String userId) {
        return this.userRides.get(userId).toArray(new Ride[0]);
    }
}
