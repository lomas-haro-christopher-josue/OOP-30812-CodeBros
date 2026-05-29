
package ec.edu.espe.Billing.model;
import java.util.Scanner;
/**
 *
 * @author Didier Elbay  <Code_Bros , @ESPE>
 */
public class Payment {
    private double moneyPurchased,change;
    private int paymentMethod;
    int option; 
    
    Scanner scanner=new Scanner (System.in);


    public Payment() {
        this.moneyPurchased =0;
        this.change = 0;
        this.paymentMethod = 0;
    }

    public Payment(double moneyPurchased, double change, int paymentMethod) {
        this.moneyPurchased = moneyPurchased;
        this.change = change;
        this.paymentMethod = paymentMethod;
    }

    public double getMoneyPurchased() {
        return moneyPurchased;
    }

    public void setMoneyPurchased(double moneyPurchased) {
        this.moneyPurchased = moneyPurchased;
    }

    public double getChange() {
        return change;
    }

    public void setChange(double change) {
        this.change = change;
    }

    public int getPaymentMethod() {
        return paymentMethod;
    }

    public void setPaymentMethod(int paymentMethod) {
        this.paymentMethod = paymentMethod;
    }
    
    public void PaymentMethod (){
    System.out.println("Seleccione el metodo de pago:");
    System.out.println("1)Efectivo");
    System.out.println("2)Tarjeta");
    System.out.println("3)Transferencia Bancaria");
    
    option = scanner.nextInt();
    scanner.nextLine();
    


}
    
    
}
