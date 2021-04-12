package ro.fasttrackit.homework6.products.client.service;

import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import ro.fasttrackit.homework6.products.client.domain.Product;

import java.util.List;

import static org.springframework.http.HttpMethod.*;

@Service
public class ProductService {

    public List<Product> getAllProducts() {
        RestTemplate restTemplate = new RestTemplate();
        return restTemplate.exchange(
                "http://localhost:8080/products",
                GET,
                new HttpEntity<>(null),
                new ParameterizedTypeReference<List<Product>>() {
                }
        ).getBody();
    }

    public List<Product> getProductsByCategory(String category) {
        RestTemplate restTemplate = new RestTemplate();
        return restTemplate.exchange(
                "http://localhost:8080/products?categoryName=" + category,
                GET,
                new HttpEntity<>(null),
                new ParameterizedTypeReference<List<Product>>() {
                }
        ).getBody();
    }

    public List<Product> getProductsByMaxPrice(Integer maxPrice) {
        RestTemplate restTemplate = new RestTemplate();
        return restTemplate.exchange(
                "http://localhost:8080/products?price=" + maxPrice,
                GET,
                new HttpEntity<>(null),
                new ParameterizedTypeReference<List<Product>>() {
                }
        ).getBody();
    }

    public List<Product> getProductsByCategoryAndMaxPrice(String category, Integer maxPrice) {
        RestTemplate restTemplate = new RestTemplate();
        return restTemplate.exchange(
                "http://localhost:8080/products?categoryName=" + category + "&price=" + maxPrice,
                GET,
                new HttpEntity<>(null),
                new ParameterizedTypeReference<List<Product>>() {
                }
        ).getBody();
    }

    public Product getProductById(Long id) {
        RestTemplate restTemplate = new RestTemplate();
        return restTemplate.getForObject("http://localhost:8080/products/" + id, Product.class);
    }

    public Product addProduct(Product newProduct) {
        RestTemplate restTemplate = new RestTemplate();
        return restTemplate.postForObject("http://localhost:8080/products", newProduct, Product.class);
    }

    public Product deleteProduct(Long id) {
        RestTemplate restTemplate = new RestTemplate();
        Product deletedProduct = getProductById(id);
        restTemplate.delete("http://localhost:8080/products/" + id);
        return deletedProduct;
    }
}
