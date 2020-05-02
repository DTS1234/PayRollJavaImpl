package management.change.classification;

import db.Employee;
import management.change.employee.ChangeEmployeeTransaction;
import payment.classification.PaymentClassification;
import payment.schedule.PaymentSchedule;

public abstract class ChangeClassificationTransaction extends ChangeEmployeeTransaction {

    private int empId;

    public ChangeClassificationTransaction(int empId) {
        super(empId);
    }

    public abstract PaymentClassification getClassification();
    public abstract PaymentSchedule getSchedule();

    public void change(Employee employee){
        employee.setPaymentClassification(getClassification());
        employee.setPaymentSchedule(getSchedule());
    }

}
