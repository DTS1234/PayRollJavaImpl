package management.add;

import payment.classification.PaymentClassification;
import payment.classification.commissioned.CommissionedClassification;
import payment.method.HoldMethod;
import payment.method.PaymentMethod;
import payment.schedule.BiWeeklySchedule;
import payment.schedule.PaymentSchedule;

public class AddCommissionedEmployee extends AddEmployeeTransaction{

    private double salary;
    private double commissionRate;

    public AddCommissionedEmployee(Integer empId, String address, String name, double salary, double commissionRate) {
        super(empId, address, name);
        this.salary = salary;
        this.commissionRate = commissionRate;
    }

    @Override
    public PaymentClassification getPaymentClassification() {
        return new CommissionedClassification();
    }

    @Override
    public PaymentSchedule getPaymentSchedule() {
        return new BiWeeklySchedule();
    }

    @Override
    public PaymentMethod getPaymentMethod() {
        return new HoldMethod();
    }



}
