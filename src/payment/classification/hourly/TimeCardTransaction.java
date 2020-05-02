package payment.classification.hourly;

import db.Employee;
import db.PayrollDatabase;
import management.Transaction;

public class TimeCardTransaction implements Transaction {

    private int empId;
    private long date;
    private int hours;

    public TimeCardTransaction(int empId, long date, int hours) {
        this.empId = empId;
        this.date = date;
        this.hours = hours;
    }

    @Override
    public void execute() {

        Employee employee = PayrollDatabase.getEmployee(empId);

        if (employee!=null) {

            try {
                HourlyClassification employeeClassification = (HourlyClassification) employee.getPaymentClassification();
                employeeClassification.addTimeCard(new TimeCard(date, hours));
            } catch (ClassCastException exception) {
                System.out.println("This employee does not work in hourly schedule");
            }

        }else{
            System.out.println("No employee with id of " + empId);;
        }

    }
}
