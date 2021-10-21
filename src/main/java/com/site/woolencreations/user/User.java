package com.site.woolencreations.user;

import javax.persistence.*;

@Entity
@Table
public class User {
    @Id
    @SequenceGenerator(
            name = "user_sequence",
            sequenceName = "user_sequence"
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "user_sequence"
    )
    private String username;
    private String password;
    private String first_name;
    private String last_name;
    private String phone;
    private int addressID;
    private String role;
    private int points;
    private boolean guest;

    public User() {
    }

    @Override
    public String toString() {
        return "User{" +
                "username : " + username +
                ", password: '" + password + '\'' +
                ", first_name: '" + first_name + '\'' +
                ", last_name:" + last_name +
                ", phone:" + phone +
                ", addressID:" + addressID +
                ", role:" + role +
                ", points:" + points +
                ", guest:" + guest +
                '}';
    }


    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getFirst_name() {
        return first_name;
    }

    public void setFirst_name(String first_name) {
        this.first_name = first_name;
    }

    public String getLast_name() {
        return last_name;
    }

    public void setLast_name(String last_name) {
        this.last_name = last_name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public int getAddressID() {
        return addressID;
    }

    public void setAddressID(int addressID) {
        this.addressID = addressID;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public int getPoints() {
        return points;
    }

    public void setPoints(int points) {
        this.points = points;
    }

    public boolean getGuest(boolean b) {
        return guest;
    }

    public void setGuest(boolean guest) {
        this.guest = guest;
    }
}
