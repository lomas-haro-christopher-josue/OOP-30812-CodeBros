
 
package ec.edu.espe.Billing.model;


 // @author Christopher Lomas,<CodeBros,@ESPE>
 
public class Invoice 
{
    private int invoicenumber;
    private String date;
    private double total;
    private double suubtotal;
    private String cashier;
    private String customer;

    public Invoice() 
    {
        this.invoicenumber = 0;
        this.date = null;
        this.total = 0;
        this.suubtotal = 0;
        this.cashier = null;
        this.customer = null;
        
        
    }

    public int getInvoicenumber() 
    {
        return invoicenumber;
    }

    public void setInvoicenumber(int invoicenumber) 
    {
        this.invoicenumber = invoicenumber;
    }

    public String getDate() 
    {
        return date;
    }

    public void setDate(String date) 
    {
        this.date = date;
    }

    public double getTotal() 
    {
        return total;
    }

    public void setTotal(double total) 
    {
        this.total = total;
    }

    public double getSuubtotal() 
    {
        return suubtotal;
    }

    public void setSuubtotal(double suubtotal) 
    {
        this.suubtotal = suubtotal;
    }

    public String getCashier() 
    {
        return cashier;
    }

    public void setCashier(String cashier) 
    {
        this.cashier = cashier;
    }

    public String getCustomer() 
    {
        return customer;
    }

    public void setCustomer(String customer) 
    {
        this.customer = customer;
    }
    
    
}
