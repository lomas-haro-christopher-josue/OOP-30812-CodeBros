package ec.edu.espe.Billing.model;

import java.util.List;

/**
 * @author Christopher Lomas, <Code_Bros>, ESPE
 */
public interface ICategory {
    boolean save(Category category);
    Category findById(String id);
    List<Category> findAll();
}