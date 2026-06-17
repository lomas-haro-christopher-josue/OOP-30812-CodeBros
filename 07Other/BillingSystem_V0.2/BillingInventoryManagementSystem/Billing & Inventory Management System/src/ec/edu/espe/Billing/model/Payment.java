 
package ec.edu.espe.Billing.model;


 
  //@author Christopher Lomas,<CodeBros,@ESPE>

public class Payment 
{
private double moneypurchased;
private int paymentmethod;
private double change;

    public Payment() 
    {
        this.moneypurchased = 0;
        this.paymentmethod = 0;
        this.change = 0;
        
        
    }

    public double getMoneypurchased() 
    {
        return moneypurchased;
    }

    public void setMoneypurchased(double moneypurchased) 
    {
        this.moneypurchased = moneypurchased;
    }

    public int getPaymentmethod() 
    {
        return paymentmethod;
    }

    public void setPaymentmethod(int paymentmethod) 
    {
        this.paymentmethod = paymentmethod;
    }

    public double getChange() 
    {
        return change;
    }

    public void setChange(double change) 
    { 
        this.change = change;
    }


}
