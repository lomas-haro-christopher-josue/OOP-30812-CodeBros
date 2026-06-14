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
        
        System.out.println("Producto guardado");
    }

    
  private static void sellAndInvoice() {
    if (inventory.isEmpty()) {
        System.out.println("Error: No hay productos en el inventario.");
        return;
    }

    
    System.out.println("\n--- PRODUCTOS DISPONIBLES ---");
    for (int i = 0; i < inventory.size(); i++) {
        System.out.println((i + 1) + ". " + inventory.get(i).getName() + " (Stock: " + inventory.get(i).getStock() + ")");
    }

    System.out.print("\nElija el ID del producto: ");
    int idProduct= input.nextInt() - 1;

    if (idProduct >= 0 && idProduct < inventory.size()) {
        Product selectedProduct = inventory.get(idProduct);

        System.out.print("Digite la cantidad que desea vender: ");
        int quantityProduct = input.nextInt();
        input.nextLine(); 

 
        if (quantityProduct > selectedProduct.getStock()) {
            System.out.println("Error: No hay suficiente stock disponible.");
            return;
        }

    
        double subtotal = selectedProduct.getUnitPrice() * quantityProduct;
        double total = subtotal * 1.15; 

        Invoice currentInvoice = new Invoice();
        currentInvoice.setInvoiceNumber(1); 
        currentInvoice.setCustomer("Consumidor Final");
        currentInvoice.setSubtotal(subtotal);
        currentInvoice.setTotal(total);

        selectedProduct.setStock(selectedProduct.getStock() - quantityProduct);

      
        System.out.println("\n--------------------------------");
        System.out.println("      TICKET DE VENTA       \n");
        System.out.println("Producto: " + selectedProduct.getName());
        System.out.println("Cantidad: " + quantityProduct);
        System.out.printf("Subtotal: $%.2f%n", currentInvoice.getSubtotal());
        System.out.printf("Total (IVA 15%%): $%.2f%n", currentInvoice.getTotal());
        System.out.println("--------------------------------");

     
        ec.edu.espe.Billing.controller.InvoiceController.saveInventory(inventory);
        
        System.out.println("Venta realizada y archivos actualizados.");

    } else {
        System.out.println("Opción no válida.");
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
