package payment.classification.affiliation;

import java.util.ArrayList;
import java.util.List;

public class UnionAffiliation implements  Affiliation{

    private double dues;
    private List<ServiceCharge> serviceCharges;

    public UnionAffiliation(double dues) {
        this.dues = dues;
        serviceCharges = new ArrayList<>();
    }

    public ServiceCharge getServiceCharge(long date){
        return serviceCharges.stream().filter(serviceCharge -> serviceCharge.getDate() == date).findFirst().get();
    }

    public void addServiceCharge(ServiceCharge serviceCharge){
        serviceCharges.add(serviceCharge);
    }

    public double getDues() {
        return dues;
    }
}
