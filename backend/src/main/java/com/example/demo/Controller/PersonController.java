package com.example.demo.Controller;

import org.springframework.data.elasticsearch.core.ElasticsearchOperations;
import org.springframework.data.elasticsearch.core.mapping.IndexCoordinates;
import org.springframework.data.elasticsearch.core.query.IndexQuery;
import org.springframework.data.elasticsearch.core.query.IndexQueryBuilder;

import org.springframework.http.ResponseEntity;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

import com.example.demo.entity.Person;

import com.example.demo.repository.elasticsearch.PersonRepository;
import com.example.demo.repository.master.UserRepository;
import com.google.common.collect.Lists;

import org.springframework.web.bind.annotation.RequestParam;




@RestController
@RequestMapping("/")
public class PersonController {
    //Repository로 대체 
    //private final ElasticsearchOperations elasticsearchOperations;
    private final PersonRepository personRepository;

    public PersonController(
            //ElasticsearchOperations elasticsearchOperations,
            PersonRepository personRepository
        ) {
            //this.elasticsearchOperations = elasticsearchOperations;
            this.personRepository = personRepository;
    }
    
    @PostMapping("/persons")
    public ResponseEntity<Person> save(@RequestBody Person person) {
        
        /*
        IndexQuery indexQuery = new IndexQueryBuilder()
            .withId(person.getId())
            .withObject(person)
            .build();
        
        String documentId = this.elasticsearchOperations.index(
            indexQuery, IndexCoordinates.of("person"));
        */
        Person rs = personRepository.save(person);

        return ResponseEntity.ok().body(
            rs
        );
    }

    @GetMapping("/persons/{id}") 
    public ResponseEntity<Person> findById(@PathVariable("id") Long id) {
 
        
        return ResponseEntity.ok().body(
            personRepository.findById(id).get()
        );
    }

    @GetMapping(value="/persons")
    public ResponseEntity<List<Person>> getAll() {
        
        return ResponseEntity.ok().body(
            personRepository.findByNameAndAge("사람", 125)    
        );
    }

    



}
