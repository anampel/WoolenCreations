package com.site.woolencreations.order;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

import javax.persistence.*;
import java.util.Date;

@Table(name = "ORDERS")
@Entity
@SuperBuilder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Order {
    @Id
    @GeneratedValue( strategy= GenerationType.AUTO )
    private Long orderID;
    private Date date;
    private String phone;
    private Boolean paid;
    private String state;
    //shippingID
}
