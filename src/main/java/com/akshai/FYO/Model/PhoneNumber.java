package com.akshai.FYO.Model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="phone_number")
public class PhoneNumber {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name="country code")
    private String countryCode;

    @Column(name="mobile number",length = 10)
    private String mobileNumber;

    @ManyToOne
    @JoinColumn(name="person_id",nullable = false)
    private Person person;
}
