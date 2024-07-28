package com.akshai.FYO.Service.Impl;

import com.akshai.FYO.DTO.AddressDto;
import com.akshai.FYO.DTO.PersonDto;
import com.akshai.FYO.DTO.PhoneNumberDto;
import com.akshai.FYO.Exception.PersonNotFoundException;
import com.akshai.FYO.Mapper.AddressMapper;
import com.akshai.FYO.Mapper.PersonMapper;
import com.akshai.FYO.Mapper.PhoneNumberMapper;
import com.akshai.FYO.Model.Address;
import com.akshai.FYO.Model.Person;
import com.akshai.FYO.Repository.PersonRepository;
import com.akshai.FYO.Service.PersonServiceInterface;
import com.fasterxml.jackson.databind.JsonNode;
import jakarta.servlet.http.HttpServletRequest;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.Comparator;
import java.util.List;
import java.util.Set;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class PersonService implements PersonServiceInterface {
    private PersonRepository personRepository;
    private CurrentLocationService currentLocationService;

    @Override
    public PersonDto createPerson(PersonDto personDto) {
        Person person = PersonMapper.perosnDtoToPerson(personDto);
        return PersonMapper.perosnToPersonDto(personRepository.save(person));
    }

    @Override
    public PersonDto getPerson(Long id) throws PersonNotFoundException {
        Optional<Person> opPersron = personRepository.findById(id);
        if(opPersron.isEmpty()){
            throw  new PersonNotFoundException();
        }
        return PersonMapper.perosnToPersonDto(opPersron.get());
    }

    @Override
    public List<PersonDto> getAllPersons() {
        List<Person> persons = personRepository.findAll();
        return persons.stream().map(PersonMapper::perosnToPersonDto)
                .collect(Collectors.toList());
    }

    @Override
    public AddressDto getAddress(Long personId) throws PersonNotFoundException {
        Optional<Person> opPersron = personRepository.findById(personId);
        if(opPersron.isEmpty()){
            throw  new PersonNotFoundException();
        }
        return AddressMapper.addressToAddressDto(opPersron.get().getAddress());
    }

    @Override
    public List<PhoneNumberDto> getPhoneNumbers(Long personId) throws PersonNotFoundException {
        Optional<Person> opPersron = personRepository.findById(personId);
        if(opPersron.isEmpty()){
            throw  new PersonNotFoundException();
        }
        return opPersron.get().getPhoneNumbers().stream()
                .map(PhoneNumberMapper::phoneNumberToPhoneNumberDto).collect(Collectors.toList());
    }

    @Override
    public List<PersonDto> getNearByPersons(HttpServletRequest req,Long personId) throws PersonNotFoundException, IOException {
        Optional<Person> opPerson = personRepository.findById(personId);
        if(opPerson.isEmpty()){
            throw  new PersonNotFoundException();
        }
        Person person=opPerson.get();
        String currentIp = currentLocationService.getPersonIp(req);
        JsonNode currentLocationCity = currentLocationService.getCurrentLocation(currentIp).get("city");
        String city = currentLocationCity != null ? currentLocationCity.asText() : null;
        List<Person> persons = personRepository.findByCurrentLocation(city);
        persons.remove(person);
        if(!persons.isEmpty()) {
            persons = filterByAddress(persons, person.getAddress());
        }
        return persons.stream().map(PersonMapper::perosnToPersonDto).collect(Collectors.toList());
    }

    public List<Person> filterByAddress(List<Person> persons, Address address){
        String city = address.getCity();
        String state = address.getState();
        String pinCode = address.getPinCode();
        return persons.stream()
                .filter(person->person.getAddress().getPinCode().equals(pinCode) ||
                        person.getAddress().getPinCode().equals(state) ||
                        person.getAddress().getPinCode().equals(city))
                .sorted(Comparator.comparing((Person person)->person.getAddress().getPinCode().equals(pinCode)).reversed()
                        .thenComparing(person->person.getAddress().getPinCode().equals(city)).reversed()
                        .thenComparing(person->person.getAddress().getPinCode().equals(state)).reversed())
                .collect(Collectors.toList());
    }

}
