package management.change.employee;

import db.Employee;
import db.PayrollDatabase;
import management.Transaction;

public abstract class ChangeEmployeeTransaction implements Transaction {

    private int empId;

    public ChangeEmployeeTransaction(int empId) {
        this.empId = empId;
    }

    @Override
    public void execute(){

        Employee employeeChanged = PayrollDatabase.getEmployee(empId);

        if(employeeChanged != null) {
            change(employeeChanged);
        }else{
            System.out.println("No employee with id equal to " +  empId);
        }

    }

    public abstract void change(Employee employee);


}
