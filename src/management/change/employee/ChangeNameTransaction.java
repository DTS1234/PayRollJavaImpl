package management.change.employee;

import db.Employee;

public class ChangeNameTransaction extends ChangeEmployeeTransaction {

    private String newName;

    public ChangeNameTransaction(int empId, String newName) {
        super(empId);
        this.newName = newName;
    }

    @Override
    public void change(Employee employee) {

        employee.setName(newName);

    }
}
