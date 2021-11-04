package com.site.woolencreations.product;

import com.site.woolencreations.misc.Category;
import com.site.woolencreations.misc.Offer;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

import javax.persistence.*;
import java.util.List;

@Table(name = "PRODUCT")
@Entity
@SuperBuilder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Product {

    @Id
    @GeneratedValue( strategy= GenerationType.AUTO )
    private long id;
    private String name;
    private String description;
    private Double price;

    @ManyToMany(cascade = CascadeType.ALL )
    @JoinTable(
            name = "product_category",
            joinColumns = @JoinColumn(name = "product_id"),
            inverseJoinColumns = @JoinColumn(name = "categoryId"))
    private List<Category> categoryList;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name="offer_id")
    private Offer offer;

    private int points;
    private Double discount;

}
