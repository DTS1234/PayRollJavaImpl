package management.change.employee;

import db.Employee;

public class ChangeAddressTransaction extends ChangeEmployeeTransaction {

    private String newAddress;

    public ChangeAddressTransaction(int empId, String newAddress) {
        super(empId);
        this.newAddress = newAddress;
    }

    @Override
    public void change(Employee employee) {

        employee.setAddress(newAddress);

    }
}
