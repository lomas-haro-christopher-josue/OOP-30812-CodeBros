package ec.edu.espe.Billing.model;
import java.util.Scanner;

public class Invoice {
    private int invoiceNumber;
    private String date,cashier,customer;
    private double total,subtotal;
    Scanner entrada = new Scanner(System.in);
       
    // Brandon Collahuazo, <CodeBros> , @ESPE

    public Invoice() {
        this.invoiceNumber = 0;
        this.date = null;
        this.cashier = null;
        this.customer = null;
        this.total = 0;
        this.subtotal = 0;
    }

    public Invoice(int invoiceNumber, String date, String cashier, String customer, double total, double subtotal) {
        this.invoiceNumber = invoiceNumber;
        this.date = date;
        this.cashier = cashier;
        this.customer = customer;
        this.total = total;
        this.subtotal = subtotal;
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

    public void informationEntry() {
        System.out.println("* * * * * * * * * * Ingreso de informacion de la factura * * * * * * * * * * ");
        System.out.println("Ingrese el numero de factura :");
        invoiceNumber = entrada.nextInt();
        entrada.nextLine(); // Consume newline
        System.out.println("Ingrese la fecha :");
        date = entrada.nextLine();
        System.out.println("Ingrese el cajero :");
        cashier = entrada.nextLine();
        System.out.println("Ingrese el cliente :");
        customer = entrada.nextLine();
        System.out.println("Ingrese el subtotal :");
        subtotal = entrada.nextDouble();
        System.out.println("Ingrese el total :");
        total = entrada.nextDouble();
    }

    public void showInformation() {
        System.out.println("* * * * * * * * * * * * Informacion de la factura " + invoiceNumber + " * * * * * * * * * * * * ");
        System.out.println("Fecha : " + date);
        System.out.println("Cajero :" + cashier);
        System.out.println("Cliente :" + customer);
        System.out.println("Subtotal :" + subtotal);
        System.out.println("Total :" + total);
    }
}
