import InvoiceSummary.InvoiceSummary;
import fairGenerator.InvoiceService;
import fairGenerator.Ride;
import fairGenerator.Subscription;
import org.junit.Assert;
import org.junit.Test;

public class CABInvoiceGeneratorTest {
    @Test
    public void simple_Test_ToCountSimpleFair() {
        InvoiceService invoiceGenerator = new InvoiceService();
        Double distance = 2.0;
        Double time = 5.0;
        Double fair = invoiceGenerator.calculateFare(distance, time, Subscription.Subscribe.NORMAL);
        Assert.assertEquals(25.0, fair, 0.001);
    }


    @Test
    public void GivenLessDistanceAndTime_ShouldReturnMinimumFair() {
        InvoiceService invoiceGenerator = new InvoiceService();
        Double distance = 0.1;
        Double time = 1.0;
        Double fair = invoiceGenerator.calculateFare(distance, time, Subscription.Subscribe.NORMAL);
        Assert.assertEquals(5.0, fair, 0.001);
    }

    @Test
    public void multipleRides_ShouldReturnAggregateFair() {
        InvoiceService invoiceGenerator = new InvoiceService();
        Ride[] rides = {new Ride(2.0, 5.0), new Ride(0.1, 4.0)};
        InvoiceSummary summary = invoiceGenerator.calculateFare(rides);
        InvoiceSummary expectedInvoiceSummary = new InvoiceSummary(2, 30);
        Assert.assertEquals(expectedInvoiceSummary, summary);
    }


    @Test
    public void givenUserIDAndRides_SouldReturnInvoiceSummery() {
        String userId = "a@b.com";
        InvoiceService invoiceService = new InvoiceService();
        Ride[] rides = {new Ride(2.0, 5.0),
                new Ride(0.1, 4.0)
        };
        invoiceService.addRide(userId, rides);
        InvoiceSummary summery = invoiceService.getInvoiceSummery(userId);
        InvoiceSummary expectedinvoiceSummery = new InvoiceSummary(2, 30);
        Assert.assertEquals(expectedinvoiceSummery,summery);
    }

    @Test
    public void simpleTest_ToCalculatePremiumFair() {
        InvoiceService invoiceService = new InvoiceService();
        Double distance =3.00;
        Double time =5.0;
        Double premiumFair = invoiceService.calculateFare(distance,time, Subscription.Subscribe.PREMIUM);
        Assert.assertEquals(70.00,premiumFair,0.01);
    }
}
