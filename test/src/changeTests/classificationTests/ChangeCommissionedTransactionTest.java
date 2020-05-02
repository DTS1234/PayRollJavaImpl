package changeTests.classificationTests;

import management.add.AddEmployeeTransaction;
import management.add.AddHourlyEmployee;
import org.junit.Before;

public class ChangeCommissionedTransactionTest {

    @Before
    public void setUp(){

        AddEmployeeTransaction addEmployeeTransaction = new AddHourlyEmployee(4, "address",
                "name", 20);
        addEmployeeTransaction.execute();

    }


}
