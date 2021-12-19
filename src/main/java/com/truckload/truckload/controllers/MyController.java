package com.truckload.truckload.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.truckload.truckload.entities.Load;
import com.truckload.truckload.services.LoadService;

@RestController
public class MyController {
	@Autowired
	public LoadService loadService;
	
	// A home endpoint to about the application
	
	@GetMapping("/home")
	public String home() {
		return "Welcome to Truck load application";
	}
	
	// A load endpoint which will expect a ahipperId and 
	// will display all the list of loads with that shipperId
	
	@GetMapping("/load")
	public ResponseEntity<List<Load>> getLoades(@RequestParam String shipperId) {
		try {
			return new ResponseEntity<List<Load>> (this.loadService.getLoads(Long.parseLong(shipperId)), HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	// A load endpoint which will have a load Id (Primary Key)
	// will return the particular load with that given ID
	
	@GetMapping("/load/{loadId}")
	public ResponseEntity<Load> getLoad(@PathVariable String loadId) {
		try {
			return new ResponseEntity<Load>(this.loadService.getLoad(Long.parseLong(loadId)), HttpStatus.OK);
		} catch (Exception e){
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
	}
	
	// A load endpoint which will send a POST request to
	// add a load in the database
	
	@PostMapping("/load")
	public ResponseEntity<Load> addLoad(@RequestBody Load load) {
		try {
			return new ResponseEntity<Load>(this.loadService.addLoad(load), HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
	}
	
	// A load endpoint which will have a load Id (Primary Key)
	// and a updated data which will be send to update an existing data
	
	@PutMapping("/load/{loadId}")
	public void updateLoad(@RequestBody Load load, @PathVariable String loadId) {
		//Load existCourse = getCourse(courseId);
		this.loadService.updateLoad(load);
	}
	
	// A load endpoint which will contain a load Id (Primary Key)
	// will be send as a Delete request to delete the particular load with that id
	
	@DeleteMapping("/load/{loadId}")
	public ResponseEntity<HttpStatus> deleteCourse(@PathVariable String loadId) {
		try {
			this.loadService.deleteLoad(Long.parseLong(loadId));
			return new ResponseEntity<>(HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
}
