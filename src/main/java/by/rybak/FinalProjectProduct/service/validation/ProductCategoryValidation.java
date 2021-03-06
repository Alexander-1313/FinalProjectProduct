package by.rybak.FinalProjectProduct.service.validation;

import by.rybak.FinalProjectProduct.exception.ProductException;
import by.rybak.FinalProjectProduct.model.Product;

public class ProductCategoryValidation implements ProductValidation{
    @Override
    public void validate(Product product) throws ProductException {
        checkNotNull(product);
        if(product.getCategory() == null){
            throw new ProductException("Product category must be not null");
        }
    }
}
