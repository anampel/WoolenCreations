package com.site.woolencreations.misc;

import com.site.woolencreations.user.User;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import javax.persistence.*;

@Table
@Entity
@SuperBuilder
@AllArgsConstructor
@NoArgsConstructor
public class Address {
    @Id
    @SequenceGenerator(
            name = "address_sequence",
            sequenceName = "address_sequence"
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "address_sequence"
    )
    private int addressId;
    private String address;
    private int number;
    private String postCode;
    private String city;
    private String country;

    @ManyToOne(cascade = CascadeType.ALL)
    private User user;


    //TODO override toString (json)
}
