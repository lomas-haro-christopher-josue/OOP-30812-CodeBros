package ec.edu.espe.Billing.Utils;

import com.mongodb.client.MongoDatabase;
import ec.edu.espe.Billing.utils.MongoDBConnection;
import javax.swing.JOptionPane;


 
public class TestMongo {
    public static void main(String[] args) {
        System.out.println("Iniciando prueba de conexión...");
        
        try {
            MongoDatabase db = MongoDBConnection.getDatabase();
            if (db != null) {
                System.out.println("¡CONEXIÓN EXITOSA!");
                System.out.println("Base de datos: " + db.getName());
                
               
                System.out.println("Colecciones disponibles:");
                for (String name : db.listCollectionNames()) {
                    System.out.println("- " + name);
                }
                
                JOptionPane.showMessageDialog(null, "Conexión a MongoDB Atlas exitosa.\nBase de datos: " + db.getName(), "Prueba Exitosa", JOptionPane.INFORMATION_MESSAGE);
            } else {
                System.out.println("La base de datos retornó null.");
            }
        } catch (Exception e) {
            System.err.println("Error durante la prueba: " + e.getMessage());
            e.printStackTrace();
        } finally {
            MongoDBConnection.closeConnection();
        }
    }
}
