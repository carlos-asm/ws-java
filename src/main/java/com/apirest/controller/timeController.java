package com.apirest.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.apirest.model.Time;
import com.apirest.repository.ITimeRepository;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/api/v1")
public class timeController {
	@Autowired
	private ITimeRepository timeRepository;
	
	@GetMapping("/times")
	public List<Time> getTimers(){
		return this.timeRepository.findAll();
	}
	
	@PostMapping("/times")
	public Time create(@RequestBody Time time) {		
		return timeRepository.save(time);
	}
	
	@PutMapping("/time/{id}")
	public Time update(@RequestBody Time time, @PathVariable Integer id) {
		Time timeBase = timeRepository.getOne(id);
		timeBase.setTime(time.getTime());
		timeBase.setDescripcion(time.getDescripcion());
		
		return timeRepository.save(timeBase);
	}
	
	@DeleteMapping("/time/{id}")
	public ResponseEntity<Integer> delete(@PathVariable Integer id) {
		timeRepository.deleteById(id);
		return new ResponseEntity<>(id,HttpStatus.OK);
	}
}
