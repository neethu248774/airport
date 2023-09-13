package com.example.airport_db;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;



@RestController
@RequestMapping("/api/airport")
public class AirportController {
	@Autowired
private AirportService jds;

    @GetMapping("/fetch-json")
    public ResponseEntity<String> fetchJSONData() throws IOException {
    	return ResponseEntity.ok(jds.readJsonFromFileSystem("src/main/resources/json/airport.json"));
    }
    @GetMapping("/getAll")
    public ResponseEntity<List<Airport>> getAllAirports() {
        List<Airport> airlines = jds.getAllAirports();
        return  ResponseEntity.ok(airlines);
    }
    @GetMapping("get/{code}")
    public ResponseEntity<Airport> getAirportByCode(@PathVariable String code) {
        Airport airline = jds.getAirportByCode(code);
        if (airline != null) {
            return new ResponseEntity<>(airline, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
    }

