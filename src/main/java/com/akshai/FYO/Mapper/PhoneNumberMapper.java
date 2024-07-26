package com.akshai.FYO.Mapper;

import com.akshai.FYO.DTO.PhoneNumberDto;
import com.akshai.FYO.Model.PhoneNumber;

public class PhoneNumberMapper {

    public static PhoneNumber phoneNumberDtoToPhoneNumber(PhoneNumberDto phoneNumberDto){
        PhoneNumber phoneNumber = new PhoneNumber();
        phoneNumber.setMobileNumber(phoneNumberDto.getMobileNumber());
        return phoneNumber;
    }

    public static PhoneNumberDto phoneNumberToPhoneNumberDto(PhoneNumber phoneNumber){
        PhoneNumberDto phoneNumberDto = new PhoneNumberDto();
        phoneNumberDto.setMobileNumber(phoneNumber.getMobileNumber());
        return phoneNumberDto;
    }
}
