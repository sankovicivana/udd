package com.udd.cls.indexmodel;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.elasticsearch.annotations.Document;
import org.springframework.data.elasticsearch.annotations.Field;
import org.springframework.data.elasticsearch.annotations.FieldType;
import org.springframework.data.elasticsearch.annotations.Setting;
import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.GeoPointField;
import org.springframework.data.elasticsearch.core.geo.GeoPoint;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Document(indexName = "contracts")
@Setting(settingPath = "/configuration/serbian-analyzer-config.json")
public class SearchIndex {

    @Id
    private String id;

    // @Field(type = FieldType.Text, store = true, name = "title")
    // private String title;
    
    // @Field(type = FieldType.Text, searchAnalyzer = "serbian", analyzer = "serbian")
    // private String content;

    // @Field(type = FieldType.Text)
    // private String firstname;

    // @Field(type = FieldType.Text)
    // private String lastname;

    // @Field(type = FieldType.Text)
    // private String address;

    // @Field(type = FieldType.Text)
    // private String administration;

    // @GeoPointField
    // private GeoPoint location;
}