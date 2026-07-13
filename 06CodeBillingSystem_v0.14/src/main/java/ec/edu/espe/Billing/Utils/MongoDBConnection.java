package ec.edu.espe.Billing.utils; 

import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoDatabase;
import javax.swing.JOptionPane;

public class MongoDBConnection {

    private static final String URI = "mongodb+srv://christopher:christopher171206@christopher.i75hlaj.mongodb.net/?appName=christopher";
    private static final String DATABASE_NAME = "BillingSystem"; 
    
    private static MongoClient mongoClient = null;
    private static MongoDatabase database = null;

    public static MongoDatabase getDatabase() {
        if (database == null) {
            try {
                mongoClient = MongoClients.create(URI);
                database = mongoClient.getDatabase(DATABASE_NAME);
                System.out.println("Successful connection to MongoDB Atlas.");
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "Error connecting to MongoDB: " + e.getMessage(), "Connection Error", JOptionPane.ERROR_MESSAGE);
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
            System.out.println("Connection to MongoDB closed.");
        }
    }
}
