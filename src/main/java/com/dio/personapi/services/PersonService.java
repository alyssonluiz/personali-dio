package com.dio.personapi.services;

import com.dio.personapi.dto.response.MessageResponseDTO;
import com.dio.personapi.dto.request.PersonDTO;
import com.dio.personapi.entities.Person;
import com.dio.personapi.dto.mapper.PersonMapper;
import com.dio.personapi.exception.PersonNotFoundException;
import com.dio.personapi.repositories.PersonRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.stream.Collectors;


@Service
@AllArgsConstructor(onConstructor = @__(@Autowired))
public class PersonService {

    private PersonRepository personRepository;
    private final PersonMapper personMapper = PersonMapper.INSTANCE;

//Constructor replaced by annotation - @AllArgsConstructor(onConstructor = @__(@Autowired))
//    @Autowired
//    public PersonService(PersonRepository personRepository) {
//        this.personRepository = personRepository;
//    }


    public MessageResponseDTO createPerson(PersonDTO personDTO){
        Person personToSave = personMapper.toModel(personDTO);
        Person savedPerson = personRepository.save(personToSave);
        return createdMsgResponse(savedPerson.getId(), "Created person with ID ");
    }

    public List<PersonDTO> listAll() {
        List<Person> allPeople = personRepository.findAll();
        return allPeople.stream()
                .map(personMapper::toDTO)
                .collect(Collectors.toList());
    }


    public PersonDTO findById(Long id) throws PersonNotFoundException {
        Person person = verifyIfExists(id);
        //Optional<Person> optionalPerson = personRepository.findById(id);
//        if(optionalPerson.isEmpty()){
//            throw new PersonNotFoundException(id);
//        }
        return personMapper.toDTO(person);
    }


    public void delete(Long id) throws PersonNotFoundException {
        verifyIfExists(id);
        personRepository.deleteById(id);
    }


    public MessageResponseDTO updateById(Long id, PersonDTO personDTO) throws PersonNotFoundException {
        verifyIfExists(id);
        Person personToUpdate = personMapper.toModel(personDTO);
        Person updatedPerson = personRepository.save(personToUpdate);
        return createdMsgResponse(updatedPerson.getId(), "Updated person with ID ");
    }


    private MessageResponseDTO createdMsgResponse(Long id, String message) {
        return MessageResponseDTO
                .builder()
                .message(message + id)
                .build();
    }


    private Person verifyIfExists(Long id) throws PersonNotFoundException {
        return personRepository
                .findById(id)
                .orElseThrow(() -> new PersonNotFoundException(id));
    }

}
