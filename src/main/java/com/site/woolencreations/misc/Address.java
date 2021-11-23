package com.site.woolencreations.misc;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

import javax.persistence.*;

@Table(name = "ADDRESS")
@Entity
@SuperBuilder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Address {
    @Id
    @GeneratedValue( strategy= GenerationType.AUTO )
    private Long addressId;
    private String address;
    private int number;
    private String postCode;
    private String city;
    private String country;

}
