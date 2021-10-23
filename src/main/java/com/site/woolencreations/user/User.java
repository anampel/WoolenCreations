package com.site.woolencreations.user;

import com.site.woolencreations.misc.Address;
import com.sun.istack.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

import javax.persistence.*;
import java.util.List;

@Entity
@Table
@SuperBuilder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(unique = true, nullable = false, length = 64)
    private String username;
    private String password;
    private String first_name;
    private String last_name;
    private String phone;
    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
    private List<Address> addresses;
    private String role;
    private int points;
    private boolean guest;

    @Override
    public String toString() {
        return "User{" +
                "username : " + username +
                ", password: '" + password + '\'' +
                ", first_name: '" + first_name + '\'' +
                ", last_name:" + last_name +
                ", phone:" + phone +
                ", addressID: [" +
                addresses
                        .stream()
                        .map(address -> address.toString())

                + "]" +
                ", role:" + role +
                ", points:" + points +
                ", guest:" + guest +
                '}';
    }
}
