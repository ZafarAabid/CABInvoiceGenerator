package fairGenerator;

import InvoiceSummary.InvoiceSummary;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class InvoiceService {

    public static Double MINIMUM_DISTANCE_PER_KILOMETER = 10.0;
    public static Double COST_PER_TIME = 1.0;
    public static double MINIMUM_FARE = 5.0;
    double totalFair = 0.0;
    public RideRepository rideRepository;

    public InvoiceService() {
        rideRepository = new RideRepository();
    }

    public Double calculateFare(Double distance, Double time, Subscription.Subscribe subscription) {
        Subscription subscriptionForFair = Subscription.subscribe(subscription);
        this.MINIMUM_DISTANCE_PER_KILOMETER = subscriptionForFair.MINIMUM_DISTANCE_PER_KILOMETER;
        this.COST_PER_TIME=subscriptionForFair.COST_PER_TIME;
        this.MINIMUM_FARE = subscriptionForFair.MINIMUM_FARE;
        Double fair = distance * MINIMUM_DISTANCE_PER_KILOMETER + time * COST_PER_TIME;
        return Math.max(fair, MINIMUM_FARE);
    }

    public InvoiceSummary calculateFare(Ride... rides) {
        for (Ride ride : rides
        ) {
            totalFair += (ride.getDistance() * 10.0 + ride.getTime() * 1.0);
        }
        return new InvoiceSummary(rides.length, totalFair);
    }

    public void addRide(String userId, Ride[] rides) {
        rideRepository.addRides(userId, rides);
    }

    public InvoiceSummary getInvoiceSummery(String userId) {
        return calculateFare(rideRepository.getRides(userId));
    }


}
