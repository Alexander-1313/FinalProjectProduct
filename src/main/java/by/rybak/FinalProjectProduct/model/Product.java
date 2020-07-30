package by.rybak.FinalProjectProduct.model;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;
import javax.validation.constraints.Max;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
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
    @Size(min = 3, max = 25, message = "product name size should be between 3 and 25!")
    @NotNull
    private String name;

    @NotNull
    @Column(name = "price")
    private BigDecimal price;

    @Column(name = "category")
    @Enumerated(EnumType.STRING)
    @NotNull
    private Category category;

    @Column(name = "discount")
    @Max(99)
    private BigDecimal discount;

    @Column(name = "description")
    private String description;

    public Product(String name, double price, Category category) {
        this.name = name;
        this.price = BigDecimal.valueOf(price);
        this.category = category;
    }
}
