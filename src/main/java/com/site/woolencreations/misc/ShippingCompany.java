package com.site.woolencreations.misc;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

import javax.persistence.*;

@Table(name = "SHIPPINGCOMPANY")
@Entity
@SuperBuilder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class ShippingCompany {
    @Id
    @GeneratedValue( strategy= GenerationType.AUTO )
    private int shippingID;
    private String company_name;
    private String company_phone;
    private Double shipping_cost;
}
