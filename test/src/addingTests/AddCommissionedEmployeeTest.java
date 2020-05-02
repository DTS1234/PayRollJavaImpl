package addingTests;

import db.PayrollDatabase;
import management.add.AddCommissionedEmployee;
import management.add.AddEmployeeTransaction;
import org.junit.Test;
import payment.classification.commissioned.CommissionedClassification;
import payment.method.HoldMethod;
import payment.schedule.BiWeeklySchedule;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class AddCommissionedEmployeeTest {

    @Test
    public void testAddHourlyEmployee(){

        int empId = 3;
        AddEmployeeTransaction newEmployee = new AddCommissionedEmployee(empId, "dom", "Stefan", 20, 0.05);

        newEmployee.execute();

        assertEquals("Stefan", PayrollDatabase.getEmployee(3).getName());
        assertTrue(newEmployee.getPaymentClassification() instanceof CommissionedClassification);
        assertTrue(newEmployee.getPaymentMethod() instanceof HoldMethod);
        assertTrue(newEmployee.getPaymentSchedule() instanceof BiWeeklySchedule);


    }

}
