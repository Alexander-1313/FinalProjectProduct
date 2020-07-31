package by.rybak.FinalProjectProduct.service;

import by.rybak.FinalProjectProduct.model.Category;
import by.rybak.FinalProjectProduct.model.Product;

import java.util.List;

public interface IProductService {

    List<Product> findByCategory(Category category);

    void addDiscountByCategory(double discount, Category category);
}
