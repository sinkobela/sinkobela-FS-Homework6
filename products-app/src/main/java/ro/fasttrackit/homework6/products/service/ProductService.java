package ro.fasttrackit.homework6.products.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ro.fasttrackit.homework6.products.domain.Category;
import ro.fasttrackit.homework6.products.domain.Product;
import ro.fasttrackit.homework6.products.repository.ProductRepository;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ProductService {
    private final ProductRepository repository;

    public List<Product> getProducts(String categoryName, Integer price) {
        if (categoryName == null && price == null) {
            return repository.findAll();
        } else if (categoryName != null && price == null) {
            return getProductsByCategory(categoryName);
        } else if (categoryName == null) {
            return getProductsByPrice(price);
        } else {
            return getProductsByCategoryAndPrice(categoryName, price);
        }
    }

    private List<Product> getProductsByCategory(String categoryName) {
//        return repository.findAllByCategoryOrName(null, categoryName);
        return repository.findAllByCategory(Category.valueOf(categoryName));
    }

    private List<Product> getProductsByPrice(Integer maxPrice) {
        return repository.findAllByPriceIsLessThanEqual(maxPrice);
    }

    private List<Product> getProductsByCategoryAndPrice(String categoryName, Integer price) {
//        return repository.findAllByCategoryOrNameAndPriceIsLessThanEqual(null, categoryName, price);
        return repository.findAllByCategoryAndPriceIsLessThanEqual(Category.valueOf(categoryName), price);
    }

    public Optional<Product> getProductById(Long id) {
        return repository.findById(id);
    }

    public Product addProduct(Product newProduct) {
        return repository.save(newProduct);
    }

    public Optional<Product> deleteProduct(Long id) {
        Optional<Product> productToDelete = getProductById(id);
        if (productToDelete.isPresent()) {
            repository.deleteById(id);
        }
        return productToDelete;
    }

}
