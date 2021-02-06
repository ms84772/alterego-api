package com.alterego.api.service;

import com.alterego.api.model.Person;
import com.alterego.api.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class PersonService {
    @Autowired
    private PersonRepository personRepository;

    public Person getPersonById(int id){
        return personRepository.findById(id).orElse(null);
    }

    public List<Person> getAllPerson() {
        List<Person> personList = new ArrayList<>();
        personRepository.findAll().forEach(personList::add);
        return personList;
    }

    public Person createPerson(Person person) {
        Person personRs= personRepository.save(person);
        return personRs;
    }

    public Person updatePerson(Person person) {
        return personRepository.save(person);
    }

    public boolean deletePerson(int id) {
        Person person = new Person();
        person.setId(id);
        personRepository.delete(person);
        return true;
    }
}
