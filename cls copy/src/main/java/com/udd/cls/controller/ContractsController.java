package com.udd.cls.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ContractsController {

	@GetMapping("/api/contracts")
	public String index() {
		return "<h2>HELLO !asdassadsds </h2>";
	}

}