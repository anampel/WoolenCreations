package com.site.woolencreations.user;

import com.site.woolencreations.misc.Address;
import com.site.woolencreations.product.Product;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "USER")
@SuperBuilder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class User {
    @Id
    @GeneratedValue( strategy= GenerationType.AUTO )
    private Long id;
    @Column(unique = true, nullable = false, length = 64)
    private String username;
    private String password;
    private String first_name;
    private String last_name;
    private String phone;
    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(
            name = "user_address",
            joinColumns = @JoinColumn(name = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "address_id"))
    private List<Address> addressList;

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(
            name = "wishlist",
            joinColumns = @JoinColumn(name = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "product_id"))
    private List<Product> wishList;
    private String role;
    private int points;
    private Boolean guest;


}
