package com.udd.cls.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class SearchDTO  {
    
    private String firstname;
    private String firstnameQuery;

    private String lastname;
    private String lastnameQuery;

    private String administrationLevel;
    private String administrationLevelQuery;

    private String address;
    private String addressQuery;

    private String content;
    private String contentQuery;

    private String city;
    private String radius;
}