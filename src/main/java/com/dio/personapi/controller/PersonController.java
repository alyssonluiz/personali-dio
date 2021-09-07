package com.dio.personapi.controller;

import com.dio.personapi.dto.response.MessageResponseDTO;
import com.dio.personapi.dto.request.PersonDTO;
import com.dio.personapi.exception.PersonNotFoundException;
import com.dio.personapi.services.PersonService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController//Enter point
@RequestMapping("api/v1/people") //Acess path
@AllArgsConstructor(onConstructor = @__(@Autowired))
public class PersonController {

    private PersonService personService;


//Constructor replaced by annotation - @AllArgsConstructor(onConstructor = @__(@Autowired))
//    @Autowired
//    public PersonController(PersonService personService) {
//        this.personService = personService;
//    }

    @PostMapping//Verb HTTP POST
    @ResponseStatus(HttpStatus.CREATED)
    public MessageResponseDTO createPerson(@RequestBody @Valid PersonDTO personDTO){
        return personService.createPerson(personDTO);
    }

    @GetMapping
    public List<PersonDTO> listAll(){
        return personService.listAll();
    }

    @GetMapping("/{id}")
    public PersonDTO getById(@PathVariable Long id) throws PersonNotFoundException {
        return personService.findById(id);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteById(@PathVariable Long id) throws PersonNotFoundException {
        personService.delete(id);
    }

    @PutMapping("/{id}")
    public MessageResponseDTO updateById(@PathVariable Long id, @RequestBody @Valid PersonDTO personDTO) throws PersonNotFoundException {
        return personService.updateById(id, personDTO);
    }

}
