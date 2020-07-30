package by.rybak.FinalProjectProduct.service.validation;

import by.rybak.FinalProjectProduct.exception.ProductException;
import by.rybak.FinalProjectProduct.model.Product;

public class ProductNameValidation implements ProductValidation{
    @Override
    public void validate(Product product) throws ProductException {
        checkNotNull(product);
        if(product.getName() == null){
            throw new ProductException("Product name must be not null");
        }
    }
}
