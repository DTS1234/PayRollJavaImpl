package paymentTests.unionAffiliation;

import db.Employee;
import db.PayrollDatabase;
import management.add.AddCommissionedEmployee;
import management.add.AddEmployeeTransaction;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import payment.classification.affiliation.ServiceCharge;
import payment.classification.affiliation.ServiceChargeTransaction;
import payment.classification.affiliation.UnionAffiliation;

import static org.junit.Assert.assertEquals;

public class ServiceChargeTransactionTest {

    private AddEmployeeTransaction newEmployee;
    private UnionAffiliation unionAffiliation;

    @Before
    public void setUp(){

        newEmployee = new AddCommissionedEmployee(4, "address", "name", 2000, 0.02);
        newEmployee.execute();
        Employee emp = PayrollDatabase.getEmployee(4);
        unionAffiliation = new UnionAffiliation(12.5);
        emp.setAffiliation(unionAffiliation);
        PayrollDatabase.addUnionMember(4, emp);

    }

    @Test
    public void serviceChargeTransactionTest(){

        ServiceChargeTransaction serviceChargeTransaction = new ServiceChargeTransaction(20000101, 200, 4);
        serviceChargeTransaction.execute();

        assertEquals(new ServiceCharge(20000101, 200), unionAffiliation.getServiceCharge(20000101));

    }

    @After
    public void clear(){
        PayrollDatabase.deleteEmployee(4);
    }


}
