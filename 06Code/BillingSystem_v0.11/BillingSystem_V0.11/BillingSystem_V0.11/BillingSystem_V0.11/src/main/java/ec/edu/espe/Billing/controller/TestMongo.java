package ec.edu.espe.Billing.controller;

import com.mongodb.client.MongoDatabase;
import javax.swing.JOptionPane;

/**
 * Clase de prueba rápida para verificar la conexión a MongoDB Atlas.
 * Puedes ejecutar este archivo (Shift + F6 en NetBeans) para probar.
 */
public class TestMongo {
    public static void main(String[] args) {
        System.out.println("Iniciando prueba de conexión...");
        
        try {
            MongoDatabase db = MongoDBConnection.getDatabase();
            if (db != null) {
                System.out.println("¡CONEXIÓN EXITOSA!");
                System.out.println("Base de datos: " + db.getName());
                
                // Intentamos listar las colecciones para confirmar acceso real
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
