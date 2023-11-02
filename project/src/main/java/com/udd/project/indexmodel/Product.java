package com.udd.project.indexmodel;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.elasticsearch.annotations.Document;
import org.springframework.data.elasticsearch.annotations.Field;
import org.springframework.data.elasticsearch.annotations.FieldType;
import org.springframework.data.elasticsearch.annotations.Setting;


@AllArgsConstructor
@Data
@Document(indexName = "products")
public class Product {
    
    private int id;
    private String name;
    private String description;

}
