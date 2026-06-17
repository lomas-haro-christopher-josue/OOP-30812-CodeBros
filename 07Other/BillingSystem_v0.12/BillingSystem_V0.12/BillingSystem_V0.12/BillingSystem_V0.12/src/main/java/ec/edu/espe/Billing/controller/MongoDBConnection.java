package ec.edu.espe.Billing.controller;

import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoDatabase;
import javax.swing.JOptionPane;


public class MongoDBConnection {
    

    private static final String URI = "mongodb+srv://Didier:Didier123456@cluster0.jrfeap2.mongodb.net/?appName=Cluster0";
    private static final String DATABASE_NAME = "BillingSystem"; 
    
    private static MongoClient mongoClient = null;
    private static MongoDatabase database = null;


    public static MongoDatabase getDatabase() {
        if (database == null) {
            try {
                mongoClient = MongoClients.create(URI);
                database = mongoClient.getDatabase(DATABASE_NAME);
                System.out.println("Conexion exitosa a MongoDB Atlas.");
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "Error al conectar a MongoDB: " + e.getMessage(), "Error de Conexion", JOptionPane.ERROR_MESSAGE);
                e.printStackTrace();
            }
        }
        return database;
    }


    public static void closeConnection() {
        if (mongoClient != null) {
            mongoClient.close();
            mongoClient = null;
            database = null;
            System.out.println("Conexion a MongoDB cerrada.");
        }
    }
}