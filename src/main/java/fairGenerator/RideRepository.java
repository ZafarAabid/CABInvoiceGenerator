package fairGenerator;

import java.util.*;

public class RideRepository {
    public Map<String, List<Ride>> userRides;

    public RideRepository() {
        this.userRides = new HashMap<>();
    }

    public void addRides(String userId, Ride[] rides) {
        if (userRides.size() == 0) {
            userRides.put(userId,new ArrayList<>(Arrays.asList(rides)));
        } else for (Ride ride : rides) userRides.get(userId).add(ride);
    }

    public Ride[] getRides(String userId) {
        return this.userRides.get(userId).toArray(new Ride[userRides.get(userId).size()]);
    }
}
