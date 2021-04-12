package ro.fasttrackit.homework6.products.client.domain;

import lombok.AllArgsConstructor;
import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
@Data
@AllArgsConstructor
public class Product {
    @Id
    @GeneratedValue
    private Long id;

    private String name;
    private Integer price;
    private String description;
    private Category category;

    public Product() {
    }

    public Product(String name, Integer price, String description, Category category) {
        this(null, name, price, description, category);
    }

}
