package com.udd.cls.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.udd.cls.dto.SearchDTO;
import com.udd.cls.service.SearchService;

@RestController
public class SearchController {

	@Autowired
	SearchService searchService;

	@PostMapping("/api/search")
	public ResponseEntity<?> search(@RequestBody SearchDTO searchForm) {
        System.out.println(searchForm.toString());
		searchService.searchContracts(searchForm);
		return  new ResponseEntity<String>("success", HttpStatus.OK);
	}

}