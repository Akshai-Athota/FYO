package com.akshai.FYO.DTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


import javax.validation.constraints.NotBlank;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class AddressDto {
    private String houseNumber;
    private String street;
    private String village;
    private String town;
    @NotBlank(message = "city is required")
    private String city;
    @NotBlank(message = "state is required")
    private String state;
    @NotBlank(message = "country is required")
    private String country;
    @NotBlank(message = "pincode is required")
    private String pinCode;
}
