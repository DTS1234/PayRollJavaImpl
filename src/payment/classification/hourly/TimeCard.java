package payment.classification.hourly;

public class TimeCard {

    private long date;
    private int hours;

    public TimeCard(long date, int hours) {
        this.date = date;
        this.hours = hours;
    }

    public long getDate() {
        return date;
    }

    public int getHours() {
        return hours;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof TimeCard)) return false;

        TimeCard timeCard = (TimeCard) o;

        if (date != timeCard.date) return false;
        return hours == timeCard.hours;

    }

    @Override
    public int hashCode() {
        int result = (int) (date ^ (date >>> 32));
        result = 31 * result + hours;
        return result;
    }
}
