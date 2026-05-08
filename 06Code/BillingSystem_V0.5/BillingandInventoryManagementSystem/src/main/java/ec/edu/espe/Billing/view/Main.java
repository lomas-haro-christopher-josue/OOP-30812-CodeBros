package ec.edu.espe.Billing.view;

import ec.edu.espe.Billing.model.*;
import java.util.Scanner;
import java.util.ArrayList;

/**
 
 * 
 * @author Christopher Lomas
 */
public class Main {
    
    
    private static Scanner input = new Scanner(System.in);
    private static ArrayList<Product> inventory = new ArrayList<>();

    public static void main(String[] args) {
        int option = 0;

        
        do {
            showMenu();
            option = input.nextInt();
            input.nextLine(); 

            switch (option) {
                case 1:
                    registerNewProduct();
                    break;
                case 2:
                    sellAndInvoice();
                    break;
                case 3:
                    deleteProduct();
                    break;
                case 4:
                    System.out.println("Cerrando sistema...");
                    break;
                default:
                    System.out.println("Opción no válida.");
            }
        } while (option != 4);
    }

  
    private static void showMenu() {
        System.out.println("\n--- SISTEMA DE FACTURACIÓN ---");
        System.out.println("1. Registrar Producto");
        System.out.println("2. Vender (Facturar)");
        System.out.println("3. Eliminar Producto");
        System.out.println("4. Salir");
        System.out.print("Elija una opción: ");
    }

    
    private static void registerNewProduct() {
        System.out.print("ID: ");
        String id = input.nextLine();
        System.out.print("Nombre: ");
        String name = input.nextLine();
        System.out.print("Precio: ");
        double price = input.nextDouble();
        System.out.print("Stock: ");
        int stock = input.nextInt();
        
        
        
        inventory.add(new Product(id, name, price, stock));
        ec.edu.espe.Billing.controller.InvoiceController.saveInventory(inventory);
        
        System.out.println("OK: Producto guardado.");
    }

    
    private static void sellAndInvoice() {
        if (inventory.isEmpty()) {
            System.out.println("Error: No hay productos.");
            return;
        }

        
        System.out.println("\nElija el producto:");
        for (int i = 0; i < inventory.size(); i++) {
            System.out.println((i + 1) + ". " + inventory.get(i).getName());
        }
        
        int index = input.nextInt() - 1;
        if (index >= 0 && index < inventory.size()) {
            Product selectedProduct = inventory.get(index);
            double totalWithTax = selectedProduct.getUnitPrice() * 1.15;
            
            System.out.println("\n--- TICKET DE VENTA ---");
            System.out.println("Producto: " + selectedProduct.getName());
            System.out.printf("Total a pagar: $%.2f%n", totalWithTax);
            System.out.println("-----------------------");
        }
    }

  
    private static void deleteProduct() {
        System.out.print("Ingrese ID a borrar: ");
        String idToDelete = input.nextLine();
        
        boolean found = false;
       
        for (int i = 0; i < inventory.size(); i++) {
            Product currentProduct = inventory.get(i);
            if (currentProduct.getId().equals(idToDelete)) {
                inventory.remove(i); 
                found = true;
                break; 
            }
        }
        
      
        if (found) {
            ec.edu.espe.Billing.controller.InvoiceController.saveInventory(inventory);
            System.out.println("Producto eliminado.");
        } else {
            System.out.println("No se encontró ese ID.");
        }
    }
}
