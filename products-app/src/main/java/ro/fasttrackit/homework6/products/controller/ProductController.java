package ro.fasttrackit.homework6.products.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import ro.fasttrackit.homework6.products.domain.Product;
import ro.fasttrackit.homework6.products.exceptions.ResourceNotFoundException;
import ro.fasttrackit.homework6.products.service.ProductService;

import java.util.List;

@RestController
@RequestMapping("products")
@RequiredArgsConstructor
public class ProductController {

    private final ProductService service;

    @GetMapping
    public List<Product> getProducts(@RequestParam(required = false) String categoryName,
                                     @RequestParam(required = false) Integer price) {
        return service.getProducts(categoryName, price);
    }

    @GetMapping("{id}")
    public Product getProductById(@PathVariable Long id) {
        return service.getProductById(id)
                .orElseThrow(() -> new ResourceNotFoundException("There is no product with id: " + id));
    }

    @PostMapping
    public Product addProduct(@RequestBody Product newProduct) {
        return service.addProduct(newProduct);
    }

    @DeleteMapping("{id}")
    public Product deleteProduct(@PathVariable Long id) {
        return service.deleteProduct(id)
                .orElseThrow(() -> new ResourceNotFoundException("There is no product with id: " + id));
    }
}
