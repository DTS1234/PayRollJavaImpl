package db;

import payment.classification.PaymentClassification;
import payment.classification.affiliation.Affiliation;
import payment.method.PaymentMethod;
import payment.schedule.PaymentSchedule;

public class Employee {

    private Integer empId;
    private String address;
    private String name;
    private PaymentClassification paymentClassification;
    private PaymentSchedule paymentSchedule;
    private PaymentMethod paymentMethod;
    private Affiliation affiliation;



    public Employee(Integer empId, String address, String name) {
        this.empId = empId;
        this.address = address;
        this.name = name;
    }

    public Integer getEmpId() {
        return empId;
    }

    public String getAddress() {
        return address;
    }

    public String getName() {
        return name;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPaymentMethod(PaymentMethod paymentMethod) {
        this.paymentMethod = paymentMethod;
    }

    public void setPaymentClassification(PaymentClassification paymentClassification) {
        this.paymentClassification = paymentClassification;
    }

    public void setPaymentSchedule(PaymentSchedule paymentSchedule) {
        this.paymentSchedule = paymentSchedule;
    }

    public void setAffiliation(Affiliation affiliation){
        this.affiliation = affiliation;
    }

    public Affiliation getAffiliation() {
        return affiliation;
    }

    public PaymentClassification getPaymentClassification() {
        return paymentClassification;
    }

    public PaymentSchedule getPaymentSchedule() {
        return paymentSchedule;
    }

    public PaymentMethod getPaymentMethod() {
        return paymentMethod;
    }
}
