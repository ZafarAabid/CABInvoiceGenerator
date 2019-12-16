package fairGenerator;

import InvoiceSummary.InvoiceSummary;

public class InvoiceService {

    public static Double MINIMUM_DISTANCE_PER_KILOMETER = 00.0;
    public static Double COST_PER_TIME = 0.0;
    public static double MINIMUM_FARE = 0.0;
    double totalFair = 0.0;
    public RideRepository rideRepository = new RideRepository();

    public InvoiceService() {
    }

    public InvoiceService(Subscription.Subscribe subscription) {
        Subscription subscriptionForFair = Subscription.subscribe(subscription);
        this.MINIMUM_DISTANCE_PER_KILOMETER = subscriptionForFair.MINIMUM_DISTANCE_PER_KILOMETER;
        this.COST_PER_TIME = subscriptionForFair.COST_PER_TIME;
        this.MINIMUM_FARE = subscriptionForFair.MINIMUM_FARE;
    }

    public Double calculateFare(Double distance, Double time) {
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
