package com.akshai.FYO.Controller.Person;

import com.akshai.FYO.DTO.AddressDto;
import com.akshai.FYO.DTO.PersonDto;
import com.akshai.FYO.DTO.PhoneNumberDto;
import com.akshai.FYO.Exception.PersonNotFoundException;
import com.akshai.FYO.Service.Impl.PersonService;
import jakarta.servlet.http.HttpServletRequest;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping("/api/fyo/person")
@AllArgsConstructor
public class PersonController {
    private PersonService personService;

    @PostMapping
    public ResponseEntity<PersonDto> createPerson(@Valid @RequestBody PersonDto personDto){
        return ResponseEntity.ok(personService.createPerson(personDto));
    }

    @GetMapping("/{personId}")
    public ResponseEntity<PersonDto> getPerson(@PathVariable Long personId){
        try{
            return ResponseEntity.ok(personService.getPerson(personId));
        }catch (PersonNotFoundException pe){
            return ResponseEntity.badRequest().build();
        }
    }

    @GetMapping("/all")
    public ResponseEntity<List<PersonDto>> getAllPersons(){
        return ResponseEntity.ok(personService.getAllPersons());
    }

    @GetMapping("/{personId}/address")
    public ResponseEntity<AddressDto> getAddress(@PathVariable Long personId){
        try{
            return ResponseEntity.ok(personService.getAddress(personId));
        }catch (PersonNotFoundException pe){
            return ResponseEntity.badRequest().build();
        }
    }

    @GetMapping("/{personId}/phonenumber")
    public ResponseEntity<List<PhoneNumberDto>> getPhoneNumber(@PathVariable Long personId){
        try{
            return ResponseEntity.ok(personService.getPhoneNumbers(personId));
        }catch (PersonNotFoundException pe){
            return ResponseEntity.badRequest().build();
        }
    }

    @GetMapping("/{personId}/nearby")
    public ResponseEntity<List<PersonDto>> getNearByPerson(HttpServletRequest rq,@PathVariable Long personId){
        try{
            return ResponseEntity.ok(personService.getNearByPersons(rq,personId));
        }catch (PersonNotFoundException | IOException pe){
            return ResponseEntity.badRequest().build();
        }
    }

}
