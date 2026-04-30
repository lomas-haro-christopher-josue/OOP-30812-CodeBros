
package ec.edu.espe.Billing.model;


 //@author Christopher Lomas,<CodeBros,@ESPE>
 
public class Company 
{
private String companyname;
private String companyid;
private String companyadress;

    public Company() 
    {
        this.companyname = null;
        this.companyid = null;
        this.companyadress = null;
        
        
    }

    public String getCompanyname() 
    {
        return companyname;
    }

    public void setCompanyname(String companyname) 
    {
        this.companyname = companyname;
    }

    public String getCompanyid() 
    {
        return companyid;
    }

    public void setCompanyid(String companyid) 
    {
        this.companyid = companyid;
    }

    public String getCompanyadress() 
    {
        return companyadress;
    }

    public void setCompanyadress(String companyadress) 
    {
        this.companyadress = companyadress;
    }


}
