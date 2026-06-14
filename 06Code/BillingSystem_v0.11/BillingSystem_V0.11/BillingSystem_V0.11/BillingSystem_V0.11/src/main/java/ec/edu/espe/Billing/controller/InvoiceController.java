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

/**
 * Controlador para gestionar la persistencia de Inventario y Clientes en MongoDB.
 * Sustituye la implementación anterior basada en archivos JSON.
 * 
 * @author Christopher Lomas
 * @modified Anahata AI
 */
public class InvoiceController {

    private static final String PRODUCTS_COLLECTION = "products";
    private static final String CUSTOMERS_COLLECTION = "customers";
    private static final Gson gson = new Gson();

    /**
     * Guarda o actualiza el inventario completo en MongoDB.
     * @param inventory Lista de productos.
     */
    public static void saveInventory(ArrayList<Product> inventory) {
        MongoDatabase database = MongoDBConnection.getDatabase();
        if (database == null) return;

        MongoCollection<Document> collection = database.getCollection(PRODUCTS_COLLECTION);
        
        for (Product p : inventory) {
            // Convertimos el objeto a Document de MongoDB usando Gson como puente
            Document doc = Document.parse(gson.toJson(p));
            // Usamos replaceOne con upsert para actualizar si existe o insertar si es nuevo
            collection.replaceOne(eq("id", p.getId()), doc, new ReplaceOptions().upsert(true));
        }
        System.out.println("Inventario sincronizado con MongoDB Atlas.");
    }

    /**
     * Carga todos los productos desde la colección de MongoDB.
     * @return ArrayList de productos.
     */
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

    /**
     * Guarda o actualiza la lista de clientes en MongoDB.
     * @param customers Lista de clientes.
     */
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

    /**
     * Carga todos los clientes desde la colección de MongoDB.
     * @return ArrayList de clientes.
     */
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
