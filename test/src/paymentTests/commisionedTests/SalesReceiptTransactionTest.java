package paymentTests.commisionedTests;

import db.Employee;
import db.PayrollDatabase;
import management.add.AddCommissionedEmployee;
import management.add.AddEmployeeTransaction;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import payment.classification.commissioned.CommissionedClassification;
import payment.classification.commissioned.SalesReceipt;
import payment.classification.commissioned.SalesReceiptTransaction;

import static org.junit.Assert.assertEquals;

public class SalesReceiptTransactionTest {

    private AddEmployeeTransaction newEmployee;

    @Before
    public void setUp() throws Exception {

        newEmployee = new AddCommissionedEmployee(4, "address", "name", 2000, 0.02);

    }

    @Test
    public void salesReceiptTransactionTest(){

        newEmployee.execute();
        Employee emp = PayrollDatabase.getEmployee(4);

        SalesReceiptTransaction salesReceiptTransaction = new SalesReceiptTransaction(20000101, 2000, 4);
        salesReceiptTransaction.execute();

        CommissionedClassification classification = (CommissionedClassification) emp.getPaymentClassification();
        assertEquals(new SalesReceipt(2000, 20000101), classification.getSalesReceipt(20000101));

    }

    @After
    public void clear(){

        PayrollDatabase.deleteEmployee(4);

    }


}
