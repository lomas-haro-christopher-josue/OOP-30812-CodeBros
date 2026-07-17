package ec.edu.espe.Billing.model;

import org.bson.Document;

public class Payment {
    private double moneyPurchased;
    private double change;
    private String paymentMethod;

    public Payment() {
    }

    public Payment(double moneyPurchased, double change, String paymentMethod) {
        this.moneyPurchased = moneyPurchased;
        this.change = change;
        this.paymentMethod = paymentMethod;
    }

    public double getMoneyPurchased() {
        return moneyPurchased;
    }

    public void setMoneyPurchased(double moneyPurchased) {
        this.moneyPurchased = moneyPurchased;
    }

    public double getChange() {
        return change;
    }

    public void setChange(double change) {
        this.change = change;
    }

    public String getPaymentMethod() {
        return paymentMethod;
    }

    public void setPaymentMethod(String paymentMethod) {
        this.paymentMethod = paymentMethod;
    }

    @Override
    public String toString() {
        return "Payment{" + "moneyPurchased=" + moneyPurchased + ", change=" + change + ", paymentMethod=" + paymentMethod + '}';
    }

    public Document toDocument(int invoiceNumber) {
        return new Document()
                .append("invoiceNumber", invoiceNumber)
                .append("moneyPurchased", this.moneyPurchased)
                .append("change", this.change)
                .append("paymentMethod", this.paymentMethod);
    }
}
