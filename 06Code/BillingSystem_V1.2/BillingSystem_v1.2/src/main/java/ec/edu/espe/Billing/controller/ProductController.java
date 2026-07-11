package ec.edu.espe.Billing.controller;

import ec.edu.espe.Billing.model.IProduct;
import ec.edu.espe.Billing.model.Product;
import java.util.List;

/**
 * @author Brandon Collahuazo,<Code_Bros>
 */
public class ProductController {
    
    private final IProduct productRepository;

    
    public ProductController(IProduct productRepository) {
        this.productRepository = productRepository;
    }

    public boolean addProduct(Product product) {
        if (product == null || product.getId().trim().isEmpty()) return false;
        return productRepository.save(product);
    }

    public Product getProductById(String id) {
        if (id == null || id.trim().isEmpty()) return null;
        return productRepository.findById(id);
    }

    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }

    public boolean updateProduct(Product product) {
        if (product == null || product.getId().trim().isEmpty()) return false;
        return productRepository.update(product);
    }

    public boolean deleteProduct(String id) {
        if (id == null || id.trim().isEmpty()) return false;
        return productRepository.delete(id);
    }
}