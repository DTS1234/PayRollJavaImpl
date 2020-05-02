package payment.classification.affiliation;

public class ServiceCharge {

    private long date;
    private double amount;

    public ServiceCharge(long date, double amount) {
        this.date = date;
        this.amount = amount;
    }

    public long getDate() {
        return date;
    }

    public double getAmount() {
        return amount;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof ServiceCharge)) return false;

        ServiceCharge that = (ServiceCharge) o;

        if (date != that.date) return false;
        return Double.compare(that.amount, amount) == 0;

    }

    @Override
    public int hashCode() {
        int result;
        long temp;
        result = (int) (date ^ (date >>> 32));
        temp = Double.doubleToLongBits(amount);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        return result;
    }
}
