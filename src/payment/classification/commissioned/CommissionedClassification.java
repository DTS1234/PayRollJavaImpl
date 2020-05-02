package payment.classification.commissioned;

import payment.classification.PaymentClassification;

import java.util.ArrayList;
import java.util.List;

public class CommissionedClassification implements PaymentClassification {

    private List<SalesReceipt> salesReceipts = new ArrayList<>();

    public void addSalesReceipt(SalesReceipt salesReceipt){

        salesReceipts.add(salesReceipt);

    }

    public SalesReceipt getSalesReceipt(long date) {

        for (SalesReceipt salesReceipt:
             salesReceipts) {

            if (salesReceipt.getDate() == (date)){
                return salesReceipt;
            }

        }

        System.out.println("No sales receipt for date equal to : " + date);

        return null;

    }
}
