package com.alterego.api.controller;


import com.alterego.api.model.Person;
import com.alterego.api.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/person")
public class PersonController {

    @Autowired
    private PersonService personService;

    @GetMapping("{id}")
    public ResponseEntity getPersonById(@PathVariable("id") int id){
        Person person = personService.getPersonById(id);
        ResponseEntity responseEntity ;
        if(person!=null){
            responseEntity = new ResponseEntity(person, HttpStatus.OK);
        }else{
            responseEntity = new ResponseEntity("Person not found",HttpStatus.NOT_FOUND);
        }
        return responseEntity;
    }

    @GetMapping
    public ResponseEntity getAllPerson(){
        List<Person> personList = personService.getAllPerson();
        ResponseEntity responseEntity ;
        if(personList!=null){
            responseEntity = new ResponseEntity(personList, HttpStatus.OK);
        }else{
            responseEntity = new ResponseEntity("Person not found",HttpStatus.NOT_FOUND);
        }
        return responseEntity;
    }

    @PostMapping
    public ResponseEntity createPerson(@RequestBody Person person){
        Person personRs = personService.createPerson(person);
        ResponseEntity responseEntity;
        if(personRs!=null){
            responseEntity = new ResponseEntity(personRs, HttpStatus.CREATED);
        } else{
            responseEntity = new ResponseEntity("Bad request, no person created ", HttpStatus.BAD_REQUEST);
        }
        return responseEntity;
    }

    @PutMapping("{id}")
    public ResponseEntity updatePerson(@RequestBody Person person, @PathVariable int id){
        Person personRs = personService.updatePerson(person);
        ResponseEntity responseEntity;
        if(personRs!=null){
            responseEntity = new ResponseEntity(personRs, HttpStatus.CREATED);
        } else{
            responseEntity = new ResponseEntity("Bad request, no person created ", HttpStatus.BAD_REQUEST);
        }
        return responseEntity;
    }


    @DeleteMapping("{id}")
    public ResponseEntity deletePerson( @PathVariable int id){
        boolean personRs = personService.deletePerson(id);
        ResponseEntity responseEntity;
        if(personRs){
            responseEntity = new ResponseEntity(String.format("Person deleted: %s",id), HttpStatus.CREATED);
        } else{
            responseEntity = new ResponseEntity("Bad request, no person created ", HttpStatus.BAD_REQUEST);
        }
        return responseEntity;
    }
}
