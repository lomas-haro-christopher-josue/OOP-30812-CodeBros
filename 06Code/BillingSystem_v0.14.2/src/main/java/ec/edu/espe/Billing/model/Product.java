package ec.edu.espe.Billing.model;

import org.bson.Document;

/**
 * @author Didier Elbay
 */
public class Product {

    private String id;
    private String name;
    private double unitPrice;
    private int stock;
    private static final double IVA_RATE = 0.15;

    public Product() {
    }

    public Product(String id, String name, double unitPrice, int stock) {
        this.id = id;
        this.name = name;
        this.unitPrice = unitPrice;
        this.stock = stock;
    }

    public double getPriceWithIva() {
        return unitPrice * (1 + IVA_RATE);
    }

    public double calculateSubtotal(int quantity) {
        return unitPrice * quantity;
    }

    public double calculateTotalWithIva(int quantity) {
        return calculateSubtotal(quantity) * (1 + IVA_RATE);
    }

    public double[] calculateSaleTotals(int quantity) {
        return new double[]{calculateSubtotal(quantity), calculateTotalWithIva(quantity)};
    }

    public boolean reduceStock(int quantity) {
        if (quantity <= stock) {
            stock -= quantity;
            return true;
        }
        return false; 
    }

    public double calculateInventoryValue() {
        return unitPrice * stock;
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

    @Override
    public String toString() {
        return "Product{" + "id=" + id + ", name=" + name + ", unitPrice=" + unitPrice + ", stock=" + stock + '}';
    }

    public Document toDocument() {
        return new Document("_id", this.id) 
                .append("name", this.name)
                .append("unitPrice", this.unitPrice)
                .append("stock", this.stock);
    }
}
