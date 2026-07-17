package ec.edu.espe.Billing.model;

import org.bson.Document;

/**
 * @author Christopher Lomas
 */
public class Company {
    private String companyName;
    private String companyId;
    private String companyAddress;

    public Company() {
    }

    public Company(String companyName, String companyId, String companyAddress) {
        this.companyName = companyName;
        this.companyId = companyId;
        this.companyAddress = companyAddress;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public String getCompanyId() {
        return companyId;
    }

    public void setCompanyId(String companyId) {
        this.companyId = companyId;
    }

    public String getCompanyAddress() {
        return companyAddress;
    }

    public void setCompanyAddress(String companyAddress) {
        this.companyAddress = companyAddress;
    }

    @Override
    public String toString() {
        return "Company{" + "companyName=" + companyName + ", companyId=" + companyId + ", companyAddress=" + companyAddress + '}';
    }

    public Document toDocument() {
        return new Document("_id", this.companyId)
                .append("name", this.companyName)
                .append("address", this.companyAddress);
    }
}
