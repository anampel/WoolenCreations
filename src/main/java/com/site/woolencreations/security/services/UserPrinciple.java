package com.site.woolencreations.security.services;

import java.util.Collection;
import java.util.List;
import java.util.Objects;
import java.util.Set;
import java.util.stream.Collectors;

import com.site.woolencreations.user.User;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.fasterxml.jackson.annotation.JsonIgnore;


public class UserPrinciple implements UserDetails {
    private static final long serialVersionUID = 1L;

    private Long id;

    private String name;

    private String username;

    @JsonIgnore
    private String password;

    private String role;

    public UserPrinciple(Long id, String name,
                         String username, String password,
                         String role) {
        this.id = id;
        this.name = name;
        this.username = username;
        this.password = password;
        this.role = role;
    }

    public static UserPrinciple build(User user) {
        return new UserPrinciple(
                user.getId(),
                user.getFirstName(),
                user.getUsername(),
                user.getPassword(),
                user.getRole()
        );
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    @Override
    public String getUsername() {
        return username;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return null;
    }

    @Override
    public String getPassword() {
        return password;
    }

    public String getRole() { return role; }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        UserPrinciple user = (UserPrinciple) o;
        return Objects.equals(id, user.id);
    }
}
