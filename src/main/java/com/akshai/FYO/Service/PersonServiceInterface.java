package com.akshai.FYO.Service;

import com.akshai.FYO.DTO.AddressDto;
import com.akshai.FYO.DTO.PersonDto;
import com.akshai.FYO.DTO.PhoneNumberDto;
import com.akshai.FYO.Exception.PersonNotFoundException;
import com.fasterxml.jackson.databind.JsonNode;
import jakarta.servlet.http.HttpServletRequest;

import java.io.IOException;
import java.util.List;

public interface PersonServiceInterface {
    PersonDto createPerson(PersonDto personDto);
    PersonDto getPerson(Long id) throws PersonNotFoundException;
    List<PersonDto> getAllPersons();
    AddressDto getAddress(Long personId) throws PersonNotFoundException;
    List<PhoneNumberDto> getPhoneNumbers(Long personId) throws PersonNotFoundException;
    List<PersonDto> getNearByPersons(HttpServletRequest req, Long personId) throws PersonNotFoundException, IOException;

}
