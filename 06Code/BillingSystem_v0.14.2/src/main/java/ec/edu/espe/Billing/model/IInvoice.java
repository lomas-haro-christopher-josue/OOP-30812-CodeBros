
package ec.edu.espe.Billing.model;
import java.util.List;
/**
 *
 * @author Christopher Lomas,<CodeBros,@ESPE>
 */
public interface IInvoice {
    boolean saveInvoice(Invoice invoice, Payment payment);
    Cashier login(String userName, String password);
    List<Invoice> findAllInvoices(); 
}
