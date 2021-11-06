package com.site.woolencreations.misc;

import com.site.woolencreations.product.Product;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Table(name = "OFFER")
@Entity
@SuperBuilder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Offer {
    @Id
    @SequenceGenerator(
            name = "offer_sequence",
            sequenceName = "offer_sequence"
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "offer_sequence"
    )
    private int offerId;
    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name="product_id")
    private List<Product> productList;
    private String description;
    private Date start_date;
    private Date end_date;
    private Double discount;
}