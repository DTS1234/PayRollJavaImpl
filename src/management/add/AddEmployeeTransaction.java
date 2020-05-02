package management.add;

import db.Employee;
import db.PayrollDatabase;
import management.Transaction;
import payment.classification.PaymentClassification;
import payment.method.PaymentMethod;
import payment.schedule.PaymentSchedule;

public abstract class AddEmployeeTransaction implements Transaction {

    private Integer empId;
    private String address;
    private String name;

    public AddEmployeeTransaction(Integer empId, String address, String name) {
        this.empId = empId;
        this.address = address;
        this.name = name;
    }

    @Override
    public void execute(){

        PaymentClassification pc = getPaymentClassification();
        PaymentSchedule ps = getPaymentSchedule();
        PaymentMethod pm = getPaymentMethod();

        Employee e = new Employee(empId, address, name);
        e.setPaymentClassification(pc);
        e.setPaymentSchedule(ps);
        e.setPaymentMethod(pm);

        PayrollDatabase.addEmployee(empId, e);

    }

    public abstract PaymentClassification getPaymentClassification();
    public abstract PaymentSchedule getPaymentSchedule();
    public abstract PaymentMethod getPaymentMethod();

}
