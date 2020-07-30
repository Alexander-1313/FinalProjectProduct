package by.rybak.FinalProjectProduct.service;

import by.rybak.FinalProjectProduct.model.Category;
import by.rybak.FinalProjectProduct.model.Product;
import by.rybak.FinalProjectProduct.repository.ProductRepository;
import by.rybak.FinalProjectProduct.service.validation.ValidationService;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;

@Service
public class ProductService implements IProductService {

    private ValidationService validationService = new ValidationService();
    private final String getAll = "select * from products;";

    final
    ProductRepository repository;

    public ProductService(ProductRepository repository) {
        this.repository = repository;
    }

    public Product saveProduct(Product product){
        return repository.save(product);
    }


    public void deleteProduct(Long id){
        repository.deleteById(id);
    }

    public List<Product> getAll(){
        return repository.findAll();
    }


    public Product getById(long id) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Product product = session.get(Product.class, id);
        session.close();
        return product;
    }

    public List<Product> findByCategory(Category category) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        String sql = "select * from products where category = \"" + category + "\";";
        List<Product> products = session.createSQLQuery(sql).addEntity(Product.class).list();
        session.close();
        return products;
    }

    public void addDiscountByCategory(double discount, Category category) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        List<Product> products = findByCategory(category);
        for (Product product : products) {
            product.setDiscount(BigDecimal.valueOf(discount));
            session.saveOrUpdate(product);
            session.flush();
        }
        session.getTransaction().commit();
        session.close();
    }

}
