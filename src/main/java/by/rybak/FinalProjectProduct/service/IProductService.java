package by.rybak.FinalProjectProduct.service;

import by.rybak.FinalProjectProduct.model.Category;
import by.rybak.FinalProjectProduct.model.Product;
import org.hibernate.Session;
import org.springframework.data.jpa.repository.JpaRepository;

import java.math.BigDecimal;
import java.util.List;

public interface IProductService {

    public List<Product> findByCategory(Category category);

    public void addDiscountByCategory(double discount, Category category);
}
