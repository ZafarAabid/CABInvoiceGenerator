
import fairGenerator.Ride;
import fairGenerator.RideRepository;
import org.junit.Assert;
import org.junit.Test;

public class RideRepositoryTest {

    @Test
    public void givenMessage_AddRidesByParticularUserId_ShouldReturnExactUserIdInvoiceSummary() {
        RideRepository rideRepository = new RideRepository();
        String userId = "a@b.com";
        Ride[] rides = {new Ride(2.0, 5),
                new Ride(0.1, 1)
        };
        rideRepository.addRides(userId, rides);
        Ride[] summary = new Ride[10];
        summary = rideRepository.getRides(userId);
        Assert.assertEquals(rides[0], summary[0]);
    }

    @Test
    public void givenMessage_WhenUserIdsMultipleRidesAdded_ShouldReturnUsersInvoiceSummary() {
        RideRepository rideRepository = new RideRepository();
        String userId = "a@b.com";
        Ride[] rides1 = {new Ride(1.0, 10),
                new Ride(0.1, 1)
        };
        Ride[] rides2 = {new Ride(3.0, 5),
                new Ride(0.1, 1)
        };
        Ride[] rides3 = {new Ride(2.0, 5),
                new Ride(0.1, 1)
        };
        rideRepository.addRides(userId, rides1);
        rideRepository.addRides(userId, rides2);
        rideRepository.addRides(userId, rides3);
        Ride[] summary = new Ride[3];
        summary = rideRepository.getRides(userId);
        Assert.assertEquals(rides3[0], summary[0]);
    }
}