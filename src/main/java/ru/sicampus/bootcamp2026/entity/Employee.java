package ru.sicampus.bootcamp2026.entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.ToString;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Set;

@Data
@Entity
@Table(name = "employee")
public class Employee implements UserDetails {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "name")
    private String name;

    @Column(name = "username")
    private String username;

    @Column(name = "password")
    private String password;


    @Column(name = "email")
    private String email;

    @ToString.Exclude
    @ManyToOne
    @JoinColumn(name = "rented_place", nullable = false)
    private Place place;

    @ManyToMany(fetch = FetchType.EAGER)
    private Set<Authority> authorities;
}
