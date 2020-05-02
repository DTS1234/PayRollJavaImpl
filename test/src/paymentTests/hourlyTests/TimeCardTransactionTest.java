package paymentTests.hourlyTests;

import db.Employee;
import db.PayrollDatabase;
import management.add.AddEmployeeTransaction;
import management.add.AddHourlyEmployee;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import payment.classification.PaymentClassification;
import payment.classification.hourly.HourlyClassification;
import payment.classification.hourly.TimeCard;
import payment.classification.hourly.TimeCardTransaction;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class TimeCardTransactionTest {

    private AddEmployeeTransaction newEmployee;

    @Before
    public void setUp() throws Exception {

        newEmployee = new AddHourlyEmployee(4, "adres", "name", 20);

    }

    @Test
    public void timeCardTransactionTest(){

        newEmployee.execute();

        TimeCardTransaction timeCardTransaction = new TimeCardTransaction(4, 200001, 40);
        timeCardTransaction.execute();

        Employee testEmp = PayrollDatabase.getEmployee(4);
        PaymentClassification empPc = testEmp.getPaymentClassification();

        HourlyClassification hourlyEmpClassification = (HourlyClassification)empPc;
        TimeCard timeCard = hourlyEmpClassification.getTimeCard(200001);

        assertTrue(empPc instanceof HourlyClassification);
        assertEquals(new TimeCard(200001, 40), timeCard);
        assertEquals(40, timeCard.getHours());

    }

    @After
    public void clear(){

        PayrollDatabase.deleteEmployee(4);

    }

}
