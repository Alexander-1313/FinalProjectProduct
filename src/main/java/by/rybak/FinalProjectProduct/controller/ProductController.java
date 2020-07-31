package by.rybak.FinalProjectProduct.controller;

import by.rybak.FinalProjectProduct.model.Category;
import by.rybak.FinalProjectProduct.model.Product;
import by.rybak.FinalProjectProduct.model.ProductForm;
import by.rybak.FinalProjectProduct.service.ProductService;
import by.rybak.FinalProjectProduct.service.validation.ValidationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import javax.validation.Valid;
import java.util.List;

@Controller
public class ProductController {

    private final ProductService service;
    private final Category[] categories = Category.values();
    private final ValidationService validationService;
    private final String redirectToProducts = "redirect:/products";

    @Autowired
    public ProductController(ProductService service, ValidationService validationService) {
        this.service = service;
        this.validationService = validationService;
    }

    @GetMapping("/")
    public String index(){
        return "index";
    }

    @GetMapping("/products")
    public String findAll(Model model){
        List<Product> products = service.getAll();
        model.addAttribute("products", products);
        model.addAttribute("categories", categories);
        return "product-list";
    }

    @GetMapping("/product-create")
    public String createProductForm(Product product, Model model){
        model.addAttribute("categories", categories);
        return "product-create";
    }

    @PostMapping("/product-create")
    public String createProduct(@Valid Product product, BindingResult bindingResult, Model model){
        model.addAttribute("categories", categories);
        if(bindingResult.hasErrors()){
            return "product-create";
        }
        service.saveProduct(product);
        return redirectToProducts;
    }

    @GetMapping("/product-delete/{id}")
    public String deleteProduct(@PathVariable("id") Long id){
        service.deleteProduct(id);
        return redirectToProducts;
    }

    @GetMapping("/product-update/{id}")
    public String updateProductForm(@PathVariable("id")Long id, Model model){
        model.addAttribute("categories", categories);
        Product product = service.getById(id);
        model.addAttribute("product", product);
        return "/product-update";
    }

    @PostMapping("/product-update")
    public String updateProduct(@Valid Product product, BindingResult bindingResult, Model model){
        model.addAttribute("categories", categories);
        if (bindingResult.hasErrors()){
            return "product-update";
        }
        service.saveProduct(product);
        return redirectToProducts;
    }

    @GetMapping("/product-update-discount")
    public String createProductForm(Model model){
        ProductForm productForm = new ProductForm();
        model.addAttribute("productForm", productForm);
        model.addAttribute("categories", categories);
        return "product-update-discount";
    }

    @PostMapping("/product-update-discount")
    public String createProduct(Model model,
                                @ModelAttribute("productForm") ProductForm productForm){

        double discount = productForm.getDiscount().doubleValue();
        Category category = productForm.getCategory();

        service.addDiscountByCategory(discount, category);

        return redirectToProducts;
    }
}
