package com.site.woolencreations.order;


import com.site.woolencreations.product.Product;
import com.site.woolencreations.user.User;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Table(name = "ORDERS")
@Entity
@SuperBuilder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Order {
    @Id
    @SequenceGenerator(
            name = "order_sequence",
            sequenceName = "order_sequence"
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "order_sequence"
    )
    private Long id;
    @ManyToOne
    private User user;
    private Date date;
    private String phone;
    private Boolean paid;
    private String state;
    private String shipping_company_name;
    private Double shipping_cost;
    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name = "orderID")
    private List<OrderProduct> orderProduct = new ArrayList<>();

}
