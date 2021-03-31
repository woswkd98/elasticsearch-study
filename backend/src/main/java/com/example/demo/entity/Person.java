package com.example.demo.entity;

import java.math.BigInteger;

import javax.persistence.Id;

import org.springframework.data.elasticsearch.annotations.Document;
import org.springframework.data.elasticsearch.annotations.Field;
import org.springframework.data.elasticsearch.annotations.Setting;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;


@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Getter
@Document(indexName = "person")
@Setting(settingPath = "/src/main/resources/elasticsearch_setting/setting/nori_setting.json")
public class Person {
 
    @Id
    private String id;
   
    private String name;
    private int age;
    private String inquiry;
    private String area;

}

