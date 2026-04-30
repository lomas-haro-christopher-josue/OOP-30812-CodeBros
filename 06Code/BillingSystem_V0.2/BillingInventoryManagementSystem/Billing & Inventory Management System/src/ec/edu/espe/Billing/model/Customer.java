

package ec.edu.espe.Billing.model;


 //@author Christopher Lomas,<CodeBros,@ESPE>

public class Customer 
{
private int ruc;
private String name;
private String adress;
private String gmailcustomer;

    public Customer() 
    {
        this.ruc = 0;
        this.name = null;
        this.adress = null;
        this.gmailcustomer = null;
        
        
    }

    public Customer(int ruc, String name, String adress, String gmailcustomer) 
    {
        this.ruc = ruc;
        this.name = name;
        this.adress = adress;
        this.gmailcustomer = gmailcustomer;
    }

    public int getRuc() 
    {
        return ruc;
    }

    public void setRuc(int ruc) 
    {
        this.ruc = ruc;
    }

    public String getName() 
    {
        return name;
    }

    public void setName(String name) 
    {
        this.name = name;
    }

    public String getAdress() 
    {
        return adress;
    }

    public void setAdress(String adress) 
    {
        this.adress = adress;
    }

    public String getGmailcustomer() 
    {
        return gmailcustomer;
    }

    public void setGmailcustomer(String gmailcustomer) 
    {
        this.gmailcustomer = gmailcustomer;
    }

    

}
