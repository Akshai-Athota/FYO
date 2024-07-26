package com.akshai.FYO.DTO;

import com.akshai.FYO.Model.Address;
import com.akshai.FYO.Model.PhoneNumber;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.Valid;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PersonDto {

    private String name;

    @Valid
    private AddressDto address;

    @Valid
    private List<PhoneNumberDto> phoneNumbers;
}
