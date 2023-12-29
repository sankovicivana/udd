package com.udd.cls.indexmodel;

// import lombok.Getter;
import lombok.Setter;
import org.springframework.data.elasticsearch.annotations.Document;
import org.springframework.data.elasticsearch.annotations.Field;
import org.springframework.data.elasticsearch.annotations.FieldType;
import org.springframework.data.annotation.Id;

@Setter
@Document(indexName = "contractindex")
public class ContractIndex {
  @Id
  private String id;

  @Field(type = FieldType.Text, name = "objectKey")
  private String objectKey;
  
  @Field(type = FieldType.Text, name = "firstName")
  private String firstName;
  
  @Field(type = FieldType.Text, name = "lastName")
  private String lastName;
  
  @Field(type = FieldType.Text, name = "address")
  private String address;
  
  @Field(type = FieldType.Text, name = "administrationLevel")
  private String administrationLevel;
  
  @Field(type = FieldType.Text, name = "content")
  private String content;

  // todo - add geo

}