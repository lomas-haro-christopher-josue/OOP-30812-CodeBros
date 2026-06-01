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
                    System.out.println("Opcion no valida.");
            }
        } while (option != 4);
    }

  
    private static void showMenu() {
        System.out.println("\n--- SISTEMA DE FACTURACION ---");
        System.out.println("1. Registrar Producto");
        System.out.println("2. Vender (Facturar)");
        System.out.println("3. Eliminar Producto");
        System.out.println("4. Salir");
        System.out.print("Elija una opcion: ");
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
        input.nextLine();

        Product newProduct = new Product(id, name, price, stock);
        inventory.add(newProduct);
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
        
        System.out.print("Seleccion: ");
        int productSelection = input.nextInt() - 1;
        
        if (productSelection >= 0 && productSelection < inventory.size()) {
            Product selectedProduct = inventory.get(productSelection);
            
            System.out.print("Cantidad a vender: ");
            int quantity = input.nextInt();
            input.nextLine(); 

            System.out.print("Ingrese el numero de factura: ");
            int invoiceNumber = input.nextInt();
            input.nextLine(); 
            
            System.out.print("Ingrese el cajero: ");
            String cashierName = input.nextLine();
            
            System.out.print("Ingrese el cliente: ");
            String customerName = input.nextLine();

            Invoice invoice = new Invoice(invoiceNumber, cashierName, customerName);
            invoice.calculateTotals(selectedProduct, quantity);
            invoice.showInvoiceTicket(selectedProduct.getName(), quantity);
            
        } else {
            System.out.println("Opción de producto no válida.");
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
            System.out.println("No se encontro ese ID.");
        }
    }
}
