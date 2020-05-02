package changeTests.employeeTests;

import db.PayrollDatabase;
import management.add.AddCommissionedEmployee;
import management.add.AddEmployeeTransaction;
import management.change.employee.ChangeEmployeeTransaction;
import management.change.employee.ChangeNameTransaction;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class ChangeNameTransactionTest {

    private AddEmployeeTransaction addNewEmployee;

    @Before
    public void setUp() throws Exception {

        addNewEmployee = new AddCommissionedEmployee(4, "address", "name", 2000, 0.02);
        addNewEmployee.execute();

    }

    @Test
    public void changeNameTransactionTest(){

        ChangeEmployeeTransaction newChange = new ChangeNameTransaction(4, "newName");
        newChange.execute();

        assertEquals("newName", PayrollDatabase.getEmployee(4).getName());

    }

    @After
    public void clear(){

        PayrollDatabase.deleteEmployee(4);

    }

}
