package ro.fasttrackit.homework6.products;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import ro.fasttrackit.homework6.products.domain.Category;
import ro.fasttrackit.homework6.products.domain.Product;
import ro.fasttrackit.homework6.products.repository.ProductRepository;

import java.util.List;

@SpringBootApplication
public class ProductsAppApplication {

    public static void main(String[] args) {
        SpringApplication.run(ProductsAppApplication.class, args);
    }

    @Bean
    CommandLineRunner atStartup(ProductRepository repository) {
        return args ->
                repository.saveAll(List.of(
                        new Product("Hamburger", 35, "tasty", Category.FOOD),
                        new Product("Pizza", 50, "capriciosa", Category.FOOD),
                        new Product("Coca Cola", 5, "sweet", Category.DRINKS),
                        new Product("Water", 3, "meh...", Category.DRINKS),
                        new Product("Laptop", 3500, "rgb", Category.ELECTRONICS),
                        new Product("Fridge", 350, "hot", Category.ELECTRONICS),
                        new Product("Jeans", 300, "skinny", Category.CLOTHES),
                        new Product("T-shirt", 50, "slim", Category.CLOTHES)
                ));
    }
}
