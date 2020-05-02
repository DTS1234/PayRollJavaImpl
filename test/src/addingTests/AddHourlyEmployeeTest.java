package addingTests;

import db.PayrollDatabase;
import management.add.AddEmployeeTransaction;
import management.add.AddHourlyEmployee;
import org.junit.Test;
import payment.classification.hourly.HourlyClassification;
import payment.method.HoldMethod;
import payment.schedule.WeeklySchedule;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class AddHourlyEmployeeTest {

    @Test
    public void testAddHourlyEmployee(){

        int empId = 2;
        AddEmployeeTransaction newEmployee = new AddHourlyEmployee(empId, "dom", "Stefan", 20);

        newEmployee.execute();

        assertEquals("Stefan", PayrollDatabase.getEmployee(2).getName());
        assertTrue(newEmployee.getPaymentClassification() instanceof HourlyClassification);
        assertTrue(newEmployee.getPaymentMethod() instanceof HoldMethod);
        assertTrue(newEmployee.getPaymentSchedule() instanceof WeeklySchedule);


    }


}
