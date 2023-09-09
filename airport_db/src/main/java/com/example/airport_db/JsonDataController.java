package com.example.airport_db;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class JsonDataController {
	@Autowired
private JsonDataService jds;

    @GetMapping("/fetch-json")
    public ResponseEntity<String> fetchJSONData() throws IOException {
    	return ResponseEntity.ok(jds.readJsonFromFileSystem("src/main/resources/json/airport.json"));
    }
    }

