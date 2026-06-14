package ec.edu.espe.Billing.controller;

import com.google.gson.Gson;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.model.ReplaceOptions;
import static com.mongodb.client.model.Filters.eq;
import ec.edu.espe.Billing.model.Customer;
import ec.edu.espe.Billing.model.Product;
import org.bson.Document;
import java.util.ArrayList;



 
 // @author Didier Elbay
 
public class InvoiceController {

    private static final String PRODUCTS_COLLECTION = "products";
    private static final String CUSTOMERS_COLLECTION = "customers";
    private static final Gson gson = new Gson();


    public static void saveInventory(ArrayList<Product> inventory) {
        MongoDatabase database = MongoDBConnection.getDatabase();
        if (database == null) return;

        MongoCollection<Document> collection = database.getCollection(PRODUCTS_COLLECTION);
        
        for (Product p : inventory) {
           
            Document doc = Document.parse(gson.toJson(p));
          
            collection.replaceOne(eq("id", p.getId()), doc, new ReplaceOptions().upsert(true));
        }
        System.out.println("Inventario sincronizado con MongoDB Atlas.");
    }


    public static ArrayList<Product> loadInventory() {
        ArrayList<Product> inventory = new ArrayList<>();
        MongoDatabase database = MongoDBConnection.getDatabase();
        if (database == null) return inventory;

        MongoCollection<Document> collection = database.getCollection(PRODUCTS_COLLECTION);
        for (Document doc : collection.find()) {
            Product p = gson.fromJson(doc.toJson(), Product.class);
            inventory.add(p);
        }
        return inventory;
    }


    public static void saveCustomers(ArrayList<Customer> customers) {
        MongoDatabase database = MongoDBConnection.getDatabase();
        if (database == null) return;

        MongoCollection<Document> collection = database.getCollection(CUSTOMERS_COLLECTION);
        
        for (Customer c : customers) {
            Document doc = Document.parse(gson.toJson(c));
            collection.replaceOne(eq("ruc", c.getRuc()), doc, new ReplaceOptions().upsert(true));
        }
        System.out.println("Clientes sincronizados con MongoDB Atlas.");
    }


    public static ArrayList<Customer> loadCustomers() {
        ArrayList<Customer> customers = new ArrayList<>();
        MongoDatabase database = MongoDBConnection.getDatabase();
        if (database == null) return customers;

        MongoCollection<Document> collection = database.getCollection(CUSTOMERS_COLLECTION);
        for (Document doc : collection.find()) {
            Customer c = gson.fromJson(doc.toJson(), Customer.class);
            customers.add(c);
        }
        return customers;
    }
}
