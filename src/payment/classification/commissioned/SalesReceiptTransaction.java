package payment.classification.commissioned;

import db.Employee;
import db.PayrollDatabase;
import management.Transaction;

public class SalesReceiptTransaction implements Transaction {

    private long date;
    private double amount;
    private int empId;

    public SalesReceiptTransaction(long date, double amount, int empId) {
        this.date = date;
        this.amount = amount;
        this.empId = empId;
    }

    @Override
    public void execute() {

        Employee emp = PayrollDatabase.getEmployee(empId);

        if (emp != null) {

            try {
                CommissionedClassification classification = (CommissionedClassification) emp.getPaymentClassification();
                classification.addSalesReceipt(new SalesReceipt(amount, date));
            } catch (ClassCastException e) {
                System.out.println("this employee is not a commissioned worker");
            }
        }else{
            System.out.println("No employee with id equal to : " + empId);
        }

    }
}
