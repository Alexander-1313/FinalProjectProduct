package by.rybak.FinalProjectProduct.service.validation;

import by.rybak.FinalProjectProduct.exception.ProductException;
import by.rybak.FinalProjectProduct.model.Product;
import by.rybak.FinalProjectProduct.service.HibernateUtil;
import org.hibernate.Session;

import java.util.ArrayList;
import java.util.List;

public class ProductUniqueNameValidation implements ProductValidation{
    @Override
    public void validate(Product product) throws ProductException {
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        List<Product> products = new ArrayList<>();
        checkNotNull(product);
        for(Product prod: products){
            if(prod.getName().equals(product.getName())){
                throw new ProductException("Product name must be unique");
            }
        }
    }
}
