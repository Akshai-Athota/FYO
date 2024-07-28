package com.akshai.FYO.Mapper;

import com.akshai.FYO.DTO.PhoneNumberDto;
import com.akshai.FYO.Model.PhoneNumber;

public class PhoneNumberMapper {

    public static PhoneNumber phoneNumberDtoToPhoneNumber(PhoneNumberDto phoneNumberDto){
        PhoneNumber phoneNumber = new PhoneNumber();
        phoneNumber.setMobileNumber(phoneNumberDto.getMobileNumber());
        phoneNumber.setCountryCode(phoneNumberDto.getCountryCode());
        return phoneNumber;
    }

    public static PhoneNumberDto phoneNumberToPhoneNumberDto(PhoneNumber phoneNumber){
        PhoneNumberDto phoneNumberDto = new PhoneNumberDto();
        phoneNumberDto.setMobileNumber(phoneNumber.getMobileNumber());
        phoneNumberDto.setCountryCode(phoneNumber.getCountryCode());
        return phoneNumberDto;
    }
}
