package ec.edu.espe.Billing.model;

import java.util.List;

/**
 * @author Christopher Lomas, <Code_Bros>
 */
public interface IProduct {
    boolean save(Product product);
    Product findById(String id);
    List<Product> findAll();
    boolean update(Product product);
    boolean delete(String id);
}