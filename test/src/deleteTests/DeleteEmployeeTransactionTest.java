package deleteTests;

import db.PayrollDatabase;
import management.add.AddCommissionedEmployee;
import management.delete.DeleteEmployeeTransaction;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class DeleteEmployeeTransactionTest {

    @Test
    public void deleteEmployeeTest(){

        AddCommissionedEmployee addCommissionedEmployee = new AddCommissionedEmployee(3, "Polna",
                "Jan", 2000, 20);

        addCommissionedEmployee.execute();

        DeleteEmployeeTransaction deleteEmployee = new DeleteEmployeeTransaction(3);
        deleteEmployee.execute();

        assertEquals(PayrollDatabase.getEmployee(3), null);


    }

}