package com.site.woolencreations.product;

import lombok.*;
import lombok.experimental.SuperBuilder;

import javax.persistence.*;

@Entity
@Table
@SuperBuilder
//@AllArgsConstructor
//@NoArgsConstructor
//@Setter
//@Getter
public class Product {

    @Id
    @SequenceGenerator(
            name="product_sequence",
            sequenceName="product_sequence"
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator ="product_sequence"
    )
    private long id;
    private String name;
    private String description;
    private Double price;
    private long category_id;
    private int points;
    private Double discount;


@Override
public String toString() {
    return "Product{" +
            "id : " + id +
            ", name: '" + name + '\'' +
            ", description: '" + description + '\'' +
            ", price:" + price +
            ", points:" + points +
            ", discount:" + discount +
            '}';
}

    public Product() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public long getCategory_id() {
        return category_id;
    }

    public void setCategory_id(long category_id) {
        this.category_id = category_id;
    }

    public int getPoints() {
        return points;
    }

    public void setPoints(int points) {
        this.points = points;
    }

    public Double getDiscount() {
        return discount;
    }

    public void setDiscount(Double discount) {
        this.discount = discount;
    }
}
