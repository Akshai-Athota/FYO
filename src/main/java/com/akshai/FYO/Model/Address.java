package com.akshai.FYO.Model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name="address")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Address {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name="house number")
    private String houseNumber;

    @Column(name="street")
    private String street;

    @Column(name="village")
    private String village;

    @Column(name="town",nullable = false)
    private String town;

    @Column(name="city",nullable = false)
    private String city;

    @Column(name="state",nullable = false)
    private String state;

    @Column(name="country",nullable = false)
    private String country;

    @Column(name="pincode",nullable = false)
    private String pinCode;

    @OneToOne(mappedBy = "address")
    private Person person;
}
