package by.rybak.FinalProjectProduct.service.validation;

import by.rybak.FinalProjectProduct.exception.ProductException;
import by.rybak.FinalProjectProduct.model.Product;

public class ProductPriceValidation implements ProductValidation{
    @Override
    public void validate(Product product) throws ProductException {
        checkNotNull(product);
        if(product.getPrice() == null){
            throw new ProductException("Product price must be not null");
        }
    }
}
