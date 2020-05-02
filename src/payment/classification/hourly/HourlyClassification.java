package payment.classification.hourly;

import payment.classification.PaymentClassification;

import java.util.ArrayList;
import java.util.List;

public class HourlyClassification implements PaymentClassification {

    private List<TimeCard> timeCards;
    private double hourlyRate;

    public HourlyClassification(double hourlyRate) {
        this.hourlyRate = hourlyRate;
        this.timeCards = new ArrayList<>();
    }

    public double getHourlyRate() {
        return hourlyRate;
    }

    public TimeCard getTimeCard(long date) {
        return timeCards.stream().filter(timeCard -> timeCard.getDate() == date).findFirst().get();
    }

    public void addTimeCard(TimeCard newTimeCard){
        timeCards.add(newTimeCard);
    }

}
