package by.rybak.FinalProjectProduct.model;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;
import javax.validation.constraints.*;
import java.math.BigDecimal;

@Data
@NoArgsConstructor
@Entity
@Table(name = "products")
@ToString
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @Column(name = "name")
    @Size(min = 3, max = 25, message = "длина имени продукта должна быть между 3 и 25")
    @NotNull
    private String name;

    @NotNull
    @Column(name = "price")
    @Positive
    private BigDecimal price;

    @Column(name = "category")
    @Enumerated(EnumType.STRING)
    @NotNull
    private Category category;

    @Column(name = "discount")
    @Max(99)
    @Positive
    private BigDecimal discount;

    @Column(name = "description")
    private String description;

    public Product(String name, double price, Category category) {
        this.name = name;
        this.price = BigDecimal.valueOf(price);
        this.category = category;
    }
}
