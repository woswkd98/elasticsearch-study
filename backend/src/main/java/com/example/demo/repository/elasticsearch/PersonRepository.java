package com.example.demo.repository.elasticsearch;

import org.springframework.data.elasticsearch.annotations.Query;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

import java.util.List;

import com.example.demo.entity.Person;


public interface PersonRepository extends ElasticsearchRepository<Person, Long> {
    
    List<Person> findByNameAndAge(String name, int age);
    
}
