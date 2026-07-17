package ec.edu.espe.Billing.model;

import java.util.ArrayList;
import java.util.List;
import org.bson.Document;

/**
 * @author Brandom Collaguazo
 */
public class Invoice {

    private int invoiceNumber;
    private String date;
    private String cashier;
    private String customer;
    private List<Document> items;
    private double subtotal;
    private double total;

    public Invoice() {
        this.items = new ArrayList<>();
    }

    public Invoice(int invoiceNumber, String cashier, String customer) {
        this.invoiceNumber = invoiceNumber;
        this.cashier = cashier;
        this.customer = customer;
        this.date = java.time.LocalDate.now().toString();
        this.items = new ArrayList<>();
        this.subtotal = 0.0;
        this.total = 0.0;
    }

    public void addItem(String name, int quantity, double price) {
        double itemTotal = quantity * price;
        Document item = new Document("name", name)
                .append("quantity", quantity)
                .append("price", price)
                .append("total", itemTotal);
        items.add(item);
        this.subtotal += itemTotal;
        this.total = this.subtotal * 1.15;
    }

    public int getInvoiceNumber() {
        return invoiceNumber;
    }

    public void setInvoiceNumber(int invoiceNumber) {
        this.invoiceNumber = invoiceNumber;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getCashier() {
        return cashier;
    }

    public void setCashier(String cashier) {
        this.cashier = cashier;
    }

    public String getCustomer() {
        return customer;
    }

    public void setCustomer(String customer) {
        this.customer = customer;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    public double getSubtotal() {
        return subtotal;
    }

    public void setSubtotal(double subtotal) {
        this.subtotal = subtotal;
    }

    public List<Document> getItems() {
        return items;
    }

    public Document toDocument() {
        return new Document("_id", this.invoiceNumber)
                .append("invoiceNumber", this.invoiceNumber)
                .append("date", this.date)
                .append("cashier", this.cashier)
                .append("customer", this.customer)
                .append("items", this.items)
                .append("subtotal", Math.round(subtotal * 100.0) / 100.0)
                .append("total", Math.round(total * 100.0) / 100.0);
    }
}
