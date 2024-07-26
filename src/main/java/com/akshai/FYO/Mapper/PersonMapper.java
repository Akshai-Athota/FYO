package com.akshai.FYO.Mapper;

import com.akshai.FYO.DTO.PersonDto;
import com.akshai.FYO.Model.Person;

import java.util.stream.Collectors;

public class PersonMapper {

    public static PersonDto perosnToPersonDto(Person person){
        PersonDto personDto = new PersonDto();
        personDto.setName(person.getName());
        personDto.setAddress(AddressMapper.addressToAddressDto(person.getAddress()));
        personDto.setPhoneNumbers(person.getPhoneNumbers().stream().map(PhoneNumberMapper::phoneNumberToPhoneNumberDto)
                .collect(Collectors.toList()));
        return personDto;
    }

    public static Person perosnDtoToPerson(PersonDto personDto){
        Person person = new Person();
        person.setName(personDto.getName());
        person.setAddress(AddressMapper.addressDtoToAddress(personDto.getAddress()));
        person.setPhoneNumbers(personDto.getPhoneNumbers().stream().map(PhoneNumberMapper::phoneNumberDtoToPhoneNumber)
                .collect(Collectors.toList()));
        return person;
    }
}
