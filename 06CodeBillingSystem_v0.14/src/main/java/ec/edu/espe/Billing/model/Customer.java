package ec.edu.espe.Billing.model;

import org.bson.Document;

/**
 * @author Didier Elbay
 */
public class Customer {
    private String ruc;
    private String name;
    private String address;
    private String email; 

    public Customer() {
    }

    public Customer(String ruc, String name, String address, String email) {
        this.ruc = ruc;
        this.name = name;
        this.address = address;
        this.email = email;
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return "Customer{" + "ruc=" + ruc + ", name=" + name + ", address=" + address + ", email=" + email + '}';
    }

    public Document toDocument() {
        return new Document("_id", this.ruc)
                .append("name", this.name)
                .append("address", this.address)
                .append("email", this.email);
    }
}
