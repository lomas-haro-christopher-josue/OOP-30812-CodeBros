package ec.edu.espe.Billing.model;

import org.bson.Document;

/**
 *
 * @author Christopher Lomas, CodeBros, Empleado de ESPE
 */
public class Supplier {
    private String ruc;
    private String companyName;
    private String address;
    private String phone;
    private String email;

    
    public Supplier() {
    }

    
    public Supplier(String ruc, String companyName, String address, String phone, String email) {
        this.ruc = ruc;
        this.companyName = companyName;
        this.address = address;
        this.phone = phone;
        this.email = email;
    }

    
    public String getRuc() {
        return ruc;
    }

    public void setRuc(String ruc) {
        this.ruc = ruc;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return "Supplier{" + "ruc=" + ruc + ", companyName=" + companyName + ", address=" + address + ", phone=" + phone + ", email=" + email + '}';
    }

    
    public Document toDocument() {
        return new Document("_id", this.ruc) // Usamos el RUC del proveedor como ID único
                .append("companyName", this.companyName)
                .append("address", this.address)
                .append("phone", this.phone)
                .append("email", this.email);
    }
}