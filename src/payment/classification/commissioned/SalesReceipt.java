package payment.classification.commissioned;

public class SalesReceipt {

    private double amount;
    private long date;

    public SalesReceipt(double amount, long date) {
        this.amount = amount;
        this.date = date;
    }

    public double getAmount() {
        return amount;
    }

    public long getDate() {
        return date;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof SalesReceipt)) return false;

        SalesReceipt that = (SalesReceipt) o;

        if (Double.compare(that.amount, amount) != 0) return false;
        return date == that.date;

    }

    @Override
    public int hashCode() {
        int result;
        long temp;
        temp = Double.doubleToLongBits(amount);
        result = (int) (temp ^ (temp >>> 32));
        result = 31 * result + (int) (date ^ (date >>> 32));
        return result;
    }
}
