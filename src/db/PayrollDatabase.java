package db;

import java.util.HashMap;
import java.util.Map;

public class PayrollDatabase {

    private static Map<Integer, Employee> itsEmployees = new HashMap<>();
    private static Map<Integer, Employee> unionMembers = new HashMap<>();

    public static void addEmployee(int empId, Employee employee){

        itsEmployees.put(empId, employee);

    }

    public static Employee getEmployee(int empId){

        return itsEmployees.get(empId);

    }

    public static Employee deleteEmployee(int empId){

        return itsEmployees.remove(empId);

    }

    public static void addUnionMember(int memberId, Employee emp){

        if (itsEmployees.containsValue(emp)) {
            unionMembers.put(memberId, emp);
        }else{
            System.out.println("No employee found");
        }

    }

    public static Employee getUnionMember(int memberId){

        return unionMembers.get(memberId);

    }

}
