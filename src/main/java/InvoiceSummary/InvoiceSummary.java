package InvoiceSummary;

import java.util.Objects;

public class InvoiceSummary {
    private final double totalFair;
    private final int numberOfRides;
    private final double average;

    public InvoiceSummary(int noOfRides, double fair) {
        this.numberOfRides = noOfRides;
        this.totalFair= fair;
        this.average = fair / noOfRides ;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        InvoiceSummary that = (InvoiceSummary) o;
        return Double.compare(that.totalFair, totalFair) == 0 &&
                numberOfRides == that.numberOfRides &&
                Double.compare(that.average, average) == 0;
    }
}
