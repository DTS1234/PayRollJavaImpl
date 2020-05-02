package changeTests.classificationTests;

import db.PayrollDatabase;
import management.add.AddCommissionedEmployee;
import management.add.AddEmployeeTransaction;
import management.change.classification.ChangeClassificationTransaction;
import management.change.classification.ChangeHourlyTransaction;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import payment.classification.PaymentClassification;
import payment.classification.hourly.HourlyClassification;
import payment.schedule.PaymentSchedule;
import payment.schedule.WeeklySchedule;

import static junit.framework.TestCase.assertEquals;
import static junit.framework.TestCase.assertTrue;

public class ChangeHourlyTransactionTest {

    @Before
    public void setUp(){

        AddEmployeeTransaction addEmployee = new AddCommissionedEmployee(4, "address",
                "name", 2000.50, 0.2);
        addEmployee.execute();

    }

    @Test
    public void changeHourlyTransactionTest(){

        ChangeClassificationTransaction changeTransaction = new ChangeHourlyTransaction(4, 20);
        changeTransaction.execute();

        PaymentClassification paymentClassification = PayrollDatabase.getEmployee(4).getPaymentClassification();
        HourlyClassification hc = (HourlyClassification)paymentClassification;
        PaymentSchedule paymentSchedule = PayrollDatabase.getEmployee(4).getPaymentSchedule();

        assertTrue(paymentSchedule instanceof WeeklySchedule);
        assertEquals(20, hc.getHourlyRate(), 0.001);


    }

    @After
    public void clear(){
        PayrollDatabase.deleteEmployee(4);
    }
}
