package by.rybak.FinalProjectProduct.model;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class ProductForm {

    private Long id;
    private String name;
    private BigDecimal price;
    private Category category;
    private BigDecimal discount;
    private String description;
}
