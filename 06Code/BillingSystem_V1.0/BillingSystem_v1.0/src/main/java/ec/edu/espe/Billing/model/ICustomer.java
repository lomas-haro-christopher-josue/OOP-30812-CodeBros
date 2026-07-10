
package ec.edu.espe.Billing.model;
import java.util.List;
/**
 *
 * @author Christopher Lomas,<CodeBros,@ESPE>
 */
public interface ICustomer {
    boolean save(Customer customer);
    Customer findByRuc(String ruc);
    List<Customer> findAll();
    boolean update(Customer customer);
    boolean delete(String ruc);
}
