
package ec.edu.espe.Billing.model;

/**
 *
 * @author Didier Elbay  <Code_Bros , @ESPE>
 */
public class Company {
    private String companyName,companyId,companyAddress;

    public Company() {
        this.companyName = null;
        this.companyId = null;
        this.companyAddress = null;
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
    
    
    
    
}
