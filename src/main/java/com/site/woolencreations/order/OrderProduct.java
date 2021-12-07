package com.site.woolencreations.order;

import com.site.woolencreations.product.Product;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

import javax.persistence.*;
import java.io.Serializable;

@Table(name = "ORDER_PRODUCT")
@Entity
@SuperBuilder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class OrderProduct implements Serializable {
    @Id
    @SequenceGenerator(
            name = "orderProduct_sequence",
            sequenceName = "orderProduct_sequence"
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "orderProduct_sequence"
    )
    private Long id;
    @OneToOne
    private Product product;
    @Column(nullable = false)
    private int quantity;


}
