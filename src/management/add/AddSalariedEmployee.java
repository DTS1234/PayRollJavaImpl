package management.add;

import payment.classification.PaymentClassification;
import payment.classification.monthly.SalariedClassification;
import payment.method.HoldMethod;
import payment.method.PaymentMethod;
import payment.schedule.MonthlySchedule;
import payment.schedule.PaymentSchedule;

public class AddSalariedEmployee extends AddEmployeeTransaction {

    private double salary;

    public AddSalariedEmployee(Integer empId, String address, String name, double salary) {
        super(empId, address, name);
        this.salary = salary;
    }

    @Override
    public PaymentClassification getPaymentClassification() {
        return new SalariedClassification();
    }

    @Override
    public PaymentSchedule getPaymentSchedule() {
        return new MonthlySchedule();
    }

    @Override
    public void execute() {
        super.execute();
    }

    @Override
    public PaymentMethod getPaymentMethod() {
        return new HoldMethod();
    }

}
