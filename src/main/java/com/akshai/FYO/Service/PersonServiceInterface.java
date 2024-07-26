package com.akshai.FYO.Service;

import com.akshai.FYO.DTO.PersonDto;

import java.util.List;

public interface PersonServiceInterface {
    PersonDto createPerson(PersonDto personDto);
    PersonDto getPerson(Long id);
    List<PersonDto> getAllPersons();

}
