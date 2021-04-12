package ro.fasttrackit.homework6.products.client;

import lombok.RequiredArgsConstructor;
import org.springframework.shell.standard.ShellComponent;
import org.springframework.shell.standard.ShellMethod;
import ro.fasttrackit.homework6.products.client.domain.Category;
import ro.fasttrackit.homework6.products.client.domain.Product;
import ro.fasttrackit.homework6.products.client.service.ProductService;

import java.util.Scanner;

@ShellComponent
@RequiredArgsConstructor
public class ProductCommands {

    private final ProductService service;

    @ShellMethod("Print all Products")
    void printAllProducts() {
        System.out.println("All the products:");
        service.getAllProducts()
                .forEach(System.out::println);
    }

    @ShellMethod("Print Products by category")
    void printProductsByCategory() {
        Scanner scanner = new Scanner(System.in);
        String category = scanner.next();
        System.out.println("All the products by category: " + category);
        service.getProductsByCategory(category)
                .forEach(System.out::println);
    }

    @ShellMethod("Print Products by maxPrice")
    void printProductsByMaxPrice() {
        Scanner scanner = new Scanner(System.in);
        Integer price = scanner.nextInt();
        System.out.println("All the products with max price: " + price);
        service.getProductsByMaxPrice(price)
                .forEach(System.out::println);
    }

    @ShellMethod("Print Products by all filters")
    void printProductsByCategoryAndPrice() {
        Scanner scanner = new Scanner(System.in);
        String category = scanner.next();
        Integer price = scanner.nextInt();
        System.out.println("All the products by category: " + category + " and max price of: " + price);
        service.getProductsByCategoryAndMaxPrice(category, price)
                .forEach(System.out::println);
    }

    @ShellMethod("Add Product")
    void addProduct() {
        System.out.println(service.addProduct(new Product("TV", 1500, "FullHD", Category.ELECTRONICS)));
    }

    @ShellMethod("Delete Product")
    void deleteProduct() {
        Scanner scanner = new Scanner(System.in);
        long id = scanner.nextLong();
        System.out.println(service.deleteProduct(id));
    }

}
