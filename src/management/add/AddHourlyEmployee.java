package management.add;

import payment.classification.hourly.HourlyClassification;
import payment.classification.PaymentClassification;
import payment.method.HoldMethod;
import payment.method.PaymentMethod;
import payment.schedule.PaymentSchedule;
import payment.schedule.WeeklySchedule;

public class AddHourlyEmployee extends AddEmployeeTransaction {

    private int hourlyRate;

    public AddHourlyEmployee(Integer empId, String address, String name, int hourlyRate) {
        super(empId, address, name);
        this.hourlyRate = hourlyRate;
    }

    @Override
    public PaymentClassification getPaymentClassification() {
        return new HourlyClassification(hourlyRate);
    }

    @Override
    public PaymentSchedule getPaymentSchedule() {
        return new WeeklySchedule();
    }

    @Override
    public PaymentMethod getPaymentMethod() {
        return new HoldMethod();
    }

}
