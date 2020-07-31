package by.rybak.FinalProjectProduct.service.validation;

import by.rybak.FinalProjectProduct.exception.ProductException;
import by.rybak.FinalProjectProduct.model.Product;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

@Service
public class ValidationService {
    private Set<ProductValidation> validation = new HashSet<>();

    public void validate(Product product){
        validation.add(new ProductUniqueNameValidation());
        validation.add(new ProductCategoryValidation());
        validation.add(new ProductNameValidation());
        validation.add(new ProductPriceValidation());

        validation.forEach(s -> {
            try {
                s.validate(product);
            } catch (ProductException e) {
                e.printStackTrace();
            }
        });
    }
}
