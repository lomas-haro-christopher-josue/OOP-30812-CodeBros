
 
package ec.edu.espe.Billing.model;

 // @author Christopher Lomas,<CodeBros,@ESPE>
 
public class Product 
{
    private String id;
    private String nameproduct;
    private double unitprice;
    private int stock;

    public Product() 
    {
        this.id = null;
        this.nameproduct = null;
        this.unitprice = 0;
        this.stock = 0;
    }

    public Product(String id, String nameproduct, double unitprice, int stock) 
    {
        this.id = id;
        this.nameproduct = nameproduct;
        this.unitprice = unitprice;
        this.stock = stock;
    }
    
    

    public String getid() 
    {
        return id;
    }

    public void setid(String id) 
    {
        this.id = id;
    }

    public String getnameproduct() 
    {
        return nameproduct;
    }

    public void setnameproduct(String nameproduct) 
    {
        this.nameproduct = nameproduct;
    }

    public double getunitprice() 
    {
        return unitprice;
    }

    public void setunitprice(double unitprice) 
    {
        this.unitprice = unitprice;
    }

    public int getstock() 
    {
        return stock;
    }

    public void setstock(int stock) 
    {
        this.stock = stock;
    }
    
   
    
}

