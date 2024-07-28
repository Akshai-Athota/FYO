package com.akshai.FYO.DTO;

import com.akshai.FYO.Model.Person;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PhoneNumberDto {

    @NotBlank(message="phone number is required")
    @Size(min=10,max=10)
    private String mobileNumber;

    @NotBlank(message="country code is mandatory")
    private String countryCode;
}
