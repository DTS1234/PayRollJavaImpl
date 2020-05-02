package addingTests;

import db.PayrollDatabase;
import management.add.AddEmployeeTransaction;
import management.add.AddSalariedEmployee;
import org.junit.Before;
import org.junit.Test;
import payment.classification.monthly.SalariedClassification;
import payment.method.HoldMethod;
import payment.schedule.MonthlySchedule;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class AddSalariedEmployeeTest {

    @Before
    public void setUp(){



    }

    @Test
    public void testAddSalariedEmployee(){

        int empId = 1;
        AddEmployeeTransaction newEmployee = new AddSalariedEmployee(empId, "dom", "Stefan", 2000.00);

        newEmployee.execute();

        assertEquals("Stefan", PayrollDatabase.getEmployee(1).getName());
        assertTrue(newEmployee.getPaymentClassification() instanceof SalariedClassification);
        assertTrue(newEmployee.getPaymentMethod() instanceof HoldMethod);
        assertTrue(newEmployee.getPaymentSchedule() instanceof MonthlySchedule);


    }



}
