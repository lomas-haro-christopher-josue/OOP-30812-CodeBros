package ec.edu.espe.Billing.model;

import org.bson.Document;

/**
 * @author Brandon Collahuazo, <CodeBros> , @ESPE
 */
public class Invoice {

    private int invoiceNumber;
    private String date;
    private String cashier;
    private String customer;
    private double subtotal;
    private double total;

    public Invoice() {
    }

    
    public Invoice(int invoiceNumber, String cashier, String customer) {
        this.invoiceNumber = invoiceNumber;
        this.cashier = cashier;
        this.customer = customer;
        this.date = java.time.LocalDate.now().toString();
        this.subtotal = 0.0;
        this.total = 0.0;
    }

    public void calculateTotals(Product product, int quantity) {
        if (product != null && quantity > 0) {
            this.subtotal = product.getUnitPrice() * quantity;
            this.total = this.subtotal * 1.15;
        }
    }

    public double calculateSubtotal() {
        return Math.round(this.subtotal * 100.0) / 100.0;
    }

    public double calculateIva() {
        double iva = this.subtotal * 0.15;
        return Math.round(iva * 100.0) / 100.0;
    }

    public double calculateTotal() {
        return Math.round(this.total * 100.0) / 100.0;
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


    public String generateInvoiceTicket(String productName, int quantity) {
        StringBuilder ticket = new StringBuilder();
        ticket.append("\n========================================\n");
        ticket.append("               TICKET DE VENTA            \n");
        ticket.append("========================================\n");
        ticket.append("Numero de factura:  ").append(invoiceNumber).append("\n");
        ticket.append("Fecha:       ").append(date).append("\n");
        ticket.append("Cajero:      ").append(cashier).append("\n");
        ticket.append("Cliente:     ").append(customer).append("\n");
        ticket.append("----------------------------------------\n");
        ticket.append("Producto: ").append(productName).append("\n");
        ticket.append("Cantidad de producto: ").append(quantity).append("\n");
        ticket.append("----------------------------------------\n");
        ticket.append("Subtotal:    $").append(calculateSubtotal()).append("\n");
        ticket.append("IVA (15%):   $").append(calculateIva()).append("\n");
        ticket.append("Total:       $").append(calculateTotal()).append("\n");
        ticket.append("========================================\n");

        return ticket.toString();
    }

   
    public Document toDocument() {
        return new Document("_id", this.invoiceNumber)
                .append("date", this.date)
                .append("cashier", this.cashier)
                .append("customer", this.customer)
                .append("subtotal", calculateSubtotal())
                .append("iva", calculateIva())
                .append("total", calculateTotal());
    }
}