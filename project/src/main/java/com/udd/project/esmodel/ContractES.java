package com.udd.project.esmodel;

import org.springframework.data.elasticsearch.annotations.Document;
import org.springframework.data.elasticsearch.annotations.Field;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.FieldType;
import org.springframework.data.elasticsearch.annotations.GeoPointField;
import org.springframework.data.elasticsearch.core.geo.GeoPoint;
import org.springframework.data.elasticsearch.annotations.Setting;

@AllArgsConstructor
@Data
@Document(indexName = "contracts")
@Setting(settingPath = "/configuration/serbian-analyzer-config.json")
public class ContractES {
    
    @Id
    private Long id;
    
    @Field(type = FieldType.Text)
    private String city;

    @GeoPointField
    private GeoPoint location;
}
