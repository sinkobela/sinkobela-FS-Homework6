package ro.fasttrackit.homework6.products.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ro.fasttrackit.homework6.products.domain.Category;
import ro.fasttrackit.homework6.products.domain.Product;

import java.util.List;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {

//    List<Product> findAllByCategoryOrName(Category category, String categoryName);
    List<Product> findAllByCategory(Category category);

    List<Product> findAllByPriceIsLessThanEqual(Integer price);

//    List<Product> findAllByCategoryOrNameAndPriceIsLessThanEqual(Category category, String categoryName, Integer price);
    List<Product> findAllByCategoryAndPriceIsLessThanEqual(Category category, Integer price);

}
