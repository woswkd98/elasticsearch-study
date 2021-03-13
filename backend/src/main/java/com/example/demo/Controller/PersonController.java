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

//import com.example.demo.entity.Person;

//import com.example.demo.repository.elasticsearch.PersonRepository;



@RestController
@RequestMapping("/")
public class PersonController {
    /*
    private final ElasticsearchOperations elasticsearchOperations;
    private final PersonRepository personRepository;

    public PersonController(
            ElasticsearchOperations elasticsearchOperations,
            PersonRepository personRepository
        ) {
            this.elasticsearchOperations = elasticsearchOperations;
            this.personRepository = personRepository;
    }*/
    /*
    @PostMapping("/persons")
    public ResponseEntity<String> save(@RequestBody Person person) {
        
        IndexQuery indexQuery = new IndexQueryBuilder()
            .withId(person.getId())
            .withObject(person)
            .build();
        
        String documentId = this.elasticsearchOperations.index(
            indexQuery, IndexCoordinates.of("person"));
        
        return ResponseEntity.ok().body(
            documentId
        );
    }

    @GetMapping("/persons") 
    public ResponseEntity<Person> findById(@PathVariable("id") Long id) {

        return ResponseEntity.ok().body(
            personRepository.findById(id).get()
        );
    }*/



}
