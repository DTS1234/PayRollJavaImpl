package payment.classification.affiliation;

import db.Employee;
import db.PayrollDatabase;
import management.Transaction;

public class ServiceChargeTransaction implements Transaction {

    private long date;
    private double amount;
    private int memberId;

    public ServiceChargeTransaction(long date, double amount, int memberId) {
        this.date = date;
        this.amount = amount;
        this.memberId = memberId;
    }

    @Override
    public void execute() {

        Employee emp = PayrollDatabase.getUnionMember(memberId);
        UnionAffiliation unionAffiliation = (UnionAffiliation)emp.getAffiliation();
        unionAffiliation.addServiceCharge(new ServiceCharge(date, amount));

    }

}
