
package ec.edu.espe.Billing.model;
import java.util.Scanner;

/**
 *
 * @author Didier Elbay  <Code_Bros , @ESPE>
 */
public class Product {
    private String id;
    private String name;
    private double unitPrice;
    private int stock;
    Scanner entrada = new Scanner(System .in);

    public Product() {
        this.id = null;
        this.name = null;
        this.unitPrice = 0;
        this.stock = 0;
    }

    public Product(String id, String name, double unitPrice, int stock) {
        this.id = id;
        this.name = name;
        this.unitPrice = unitPrice;
        this.stock = stock;
    }
    

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getUnitPrice() {
        return unitPrice;
    }

    public void setUnitPrice(double unitPrice) {
        this.unitPrice = unitPrice;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }
    public void informationEntry(){
        System.out.println("* * * * * * * * * * Ingreso de informacion del producto * * * * * * * * * * ");
        System.out.println("Ingrese el id del pruducto :");
        id = entrada.nextLine();
        System.out.println("Ingrese el nombre del producto :");
        name =entrada.nextLine();
        System.out.println("Ingrese el precio del producto:");
        unitPrice=entrada.nextDouble();
        System.out.println("Ingrese el numero de productos que estan en Stock :");
        stock=entrada.nextInt();
        
    }
    public void showInformation(){
        System.out.println("* * * * * * * * * * * * Informacion del producto "+id+" * * * * * * * * * * * * ");
        System.out.println("Nombre del producto : "+name);
        System.out.println("ID del producto :"+id);
        System.out.println("Precio unitario :"+unitPrice);
        System.out.println("Precio de venta: " );
    }
    
    
        
    
}
