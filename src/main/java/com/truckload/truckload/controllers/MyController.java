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
	
	@GetMapping("/home")
	public String home() {
		return "Welcome to Truck load application";
	}
	
	@GetMapping("/load")
	public List<Load> getCourses(@RequestParam String shipperId) {
		return this.loadService.getLoads(Long.parseLong(shipperId));
	}
	
	@GetMapping("/load/{loadId}")
	public Load getCourse(@PathVariable String loadId) {
		return this.loadService.getLoad(Long.parseLong(loadId));
	}
	
	@PostMapping("/load")
	public Load addCourse(@RequestBody Load course) {
		return this.loadService.addLoad(course);
	}
	//Updating a method
	@PutMapping("/load/{loadId}")
	public void updateCourse(@RequestBody Load load, @PathVariable String loadId) {
		//Load existCourse = getCourse(courseId);
		this.loadService.updateLoad(load);
	}
	
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
