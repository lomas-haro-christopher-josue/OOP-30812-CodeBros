package ec.edu.espe.Billing.controller;

import ec.edu.espe.Billing.model.ICategory;
import ec.edu.espe.Billing.model.Category;
import java.util.List;

/**
 *
 * @author Christopher Lomas,<CodeBros,@ESPE>
 */
public class CategoryController {
    
    private final ICategory categoryRepository;

    public CategoryController(ICategory categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    public boolean addCategory(Category category) {
        if (category == null || category.getId().trim().isEmpty()) return false;
        return categoryRepository.save(category);
    }

    public Category getCategoryById(String id) {
        if (id == null || id.trim().isEmpty()) return null;
        return categoryRepository.findById(id);
    }

    public List<Category> getAllCategories() {
        return categoryRepository.findAll();
    }
}
