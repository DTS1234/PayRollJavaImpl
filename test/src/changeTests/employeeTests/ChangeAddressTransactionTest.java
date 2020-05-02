package changeTests.employeeTests;

import db.PayrollDatabase;
import management.add.AddCommissionedEmployee;
import management.add.AddEmployeeTransaction;
import management.change.employee.ChangeAddressTransaction;
import management.change.employee.ChangeEmployeeTransaction;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class ChangeAddressTransactionTest {

    private AddEmployeeTransaction addNewEmployee;

    @Before
    public void setUp() throws Exception {

        addNewEmployee = new AddCommissionedEmployee(4, "address", "name", 2000, 0.02);
        addNewEmployee.execute();

    }

    @Test
    public void changeNameTransactionTest(){

        ChangeEmployeeTransaction newChange = new ChangeAddressTransaction(4, "newAddress");
        newChange.execute();

        assertEquals("newAddress", PayrollDatabase.getEmployee(4).getAddress());

    }

    @After
    public void clear(){
        PayrollDatabase.deleteEmployee(4);
    }

}
