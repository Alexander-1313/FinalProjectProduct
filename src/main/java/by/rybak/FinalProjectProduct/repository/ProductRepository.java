package by.rybak.FinalProjectProduct.repository;

import by.rybak.FinalProjectProduct.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Long> {

}
