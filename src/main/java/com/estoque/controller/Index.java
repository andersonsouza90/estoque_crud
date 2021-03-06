package com.estoque.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/index")
public class Index {
	
	@GetMapping(value = "/", produces = "application/json")
	public ResponseEntity<String> index() {
		return new ResponseEntity<String>("Aquii!", HttpStatus.OK);
	}
}
