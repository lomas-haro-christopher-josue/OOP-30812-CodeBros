package ec.edu.espe.Billing.controller;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import ec.edu.espe.Billing.model.Product;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

/**
 * 
 *
 * @author Christopher Lomas
 */
public class InvoiceController {

    private static final String JSON_FILE = "product.json";
    private static final String CSV_FILE = "product.csv";

    public static void saveInventory(ArrayList<Product> inventory) {
        System.out.println("\n Iniciando guardado de datos...");
        saveAsJSON(inventory);
        saveAsCSV(inventory);
    }

    private static void saveAsJSON(ArrayList<Product> inventory) {
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        try (FileWriter writer = new FileWriter(JSON_FILE)) {
            gson.toJson(inventory, writer);
            System.out.println("Archivo JSON actualizado correctamente.");
        } catch (IOException e) {
            System.err.println("Error al guardar JSON: " + e.getMessage());
        }
    }

    private static void saveAsCSV(ArrayList<Product> inventory) {
        try (FileWriter writer = new FileWriter(CSV_FILE)) {
            writer.write("sep=,\n");
            writer.write("ID,Nombre,Precio,Stock\n");

            for (Product p : inventory) {
                writer.write(p.getId() + ","
                        + p.getName() + ","
                        + p.getUnitPrice() + ","
                        + p.getStock() + "\n");
            }
            System.out.println("Archivo CSV actualizado correctamente.");
        } catch (IOException e) {
            System.err.println("Error al guardar CSV: " + e.getMessage());
        }
    }

}
