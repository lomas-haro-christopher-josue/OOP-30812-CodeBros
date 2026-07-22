package ec.edu.espe.Billing.model;

import org.bson.Document;

/**
 *
 * @author Didier Elbay  <Code_Bros , @ESPE>
 */
public class Customer {
    private String ruc;
    private String name;
    private String address;
    private String gmailCustomer; 

    
    public Customer() {
    }

    
    public Customer(String ruc, String name, String address, String gmailCustomer) {
        this.ruc = ruc;
        this.name = name;
        this.address = address;
        this.gmailCustomer = gmailCustomer;
    }

    
    public String getRuc() {
        return ruc;
    }

    public void setRuc(String ruc) {
        this.ruc = ruc;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getGmailCustomer() {
        return gmailCustomer;
    }

    public void setGmailCustomer(String gmailCustomer) {
        this.gmailCustomer = gmailCustomer;
    }

    @Override
    public String toString() {
        return "Customer{" + "ruc=" + ruc + ", name=" + name + ", address=" + address + ", gmailCustomer=" + gmailCustomer + '}';
    }

    
    public Document toDocument() {
        return new Document("_id", this.ruc) // Usamos el RUC del cliente como ID único
                .append("name", this.name)
                .append("address", this.address)
                .append("email", this.gmailCustomer);
    }
}