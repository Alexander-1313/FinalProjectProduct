package by.rybak.FinalProjectProduct.service.validation;

import by.rybak.FinalProjectProduct.exception.ProductException;
import by.rybak.FinalProjectProduct.model.Product;

public interface ProductValidation {

    public void validate(Product product) throws ProductException;

    default void checkNotNull(Product product){

    }
}
