package com.example.airline.controller;

import java.util.List;
import java.util.Optional;

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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.airline.ServiceImpl.AirlineServiceImplementation;
import com.example.airline.model.Airline;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/airline.com/airline")
/* The AirlineController is a controller class that helps to accept the request 
	and returns the responses*/

public class AirlineController {
	@Autowired
	public AirlineServiceImplementation airlineServImpl;

	public AirlineController(AirlineServiceImplementation airlineServImpl) {
		this.airlineServImpl = airlineServImpl;
	}
	
	//search airline by destination and departure
	@GetMapping("matchRoutes")
	public ResponseEntity<List<Airline>> getAirlineDetailsByDestDepa(@RequestParam(required = true) String dest,
			@RequestParam(required = true) String depa) {

		try {

			List<Airline> airlineList = airlineServImpl.getAirlineDetails(dest, depa);

			if (airlineList.isEmpty()) {
				return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			}

			return new ResponseEntity<>(airlineList, HttpStatus.OK);

		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	// search all airlines by airlineName
	@GetMapping
	public ResponseEntity<List<Airline>> getAllAirline(@RequestParam(required = false) String airlineName) {
		try {
			List<Airline> airlineList = airlineServImpl.getAllAirline(airlineName);

			if (airlineList.isEmpty()) {
				return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			}

			return new ResponseEntity<>(airlineList, HttpStatus.OK);

		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	// create airline record rest api
	@PostMapping
	public ResponseEntity<Airline> saveAirline(@RequestBody Airline airline) {
		System.out.println(airline);
		try {
			return new ResponseEntity<>(airlineServImpl.saveAirline(airline), HttpStatus.CREATED);
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}

	}

	// get any specific airline by id
	@GetMapping("/{id}")
	public ResponseEntity<Airline> getAirlineById(@PathVariable("id") int flightId) {
		System.out.println(flightId);
		Optional<Airline> airline = airlineServImpl.getAirlineById(flightId);

		if (airline.isPresent()) {
			return new ResponseEntity<>(airline.get(), HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}

	// Update any specific airline by id
	@PutMapping("/{id}")
	public ResponseEntity<Airline> updateAirlineDetailsById(@PathVariable("id") int flightid,
			@RequestBody Airline flightDetails) {
		Optional<Airline> airlineData = airlineServImpl.getAirlineById(flightid);

		if (airlineData.isPresent()) {

			airlineServImpl.updateAirlineDetailsById(airlineData, flightDetails);
			return new ResponseEntity<>(airlineServImpl.updateAirlineDetailsById(airlineData, flightDetails),
					HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}

	}

	// Delete specific airline by id
	@DeleteMapping("/{id}")
	public ResponseEntity<String> deleteAirlineById(@PathVariable("id") int flightId) {
		Optional<Airline> airlineData = airlineServImpl.getAirlineById(flightId);

		try {
			if (airlineData.isPresent()) {
				airlineServImpl.deleteAirlineById(flightId);
				return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			} else {
				return new ResponseEntity<>(HttpStatus.NOT_FOUND);
			}
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}

	}

	// deleteAll airline
	@DeleteMapping
	public ResponseEntity<HttpStatus> deleteAllAirlines() {
		try {
			airlineServImpl.deleteAllAirlines();
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		} catch (Exception exception) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	// search international airline
	@GetMapping("/isinternational")
	public ResponseEntity<List<Airline>> findByInternationalDomain() {
		try {
			List<Airline> airline = airlineServImpl.findByisinternational(true);

			if (airline.isEmpty()) {
				return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			}
			return new ResponseEntity<>(airline, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	// search domestic airline
	@GetMapping("/domastic")
	public ResponseEntity<List<Airline>> findBydomasticDomain() {
		try {

			List<Airline> airline = airlineServImpl.findByisinternational(false);

			if (airline.isEmpty()) {
				return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			}
			return new ResponseEntity<>(airline, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);

		}
	}
	
	//sort by cost 
	@GetMapping("filter/Cost/{direction}")
	public ResponseEntity<List<Airline>> getAllAirlineByCostHighToLow(@PathVariable("direction") String direction,@RequestParam(required = true)String cost){
		try {

			List<Airline> airline = airlineServImpl.getAllAirlineByCostDesc(direction,cost);

			if (airline.isEmpty()) {
				return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			}
			return new ResponseEntity<>(airline, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);

		}
	}
	
	//sort by rate
	@GetMapping("filter/Rating/{direction}")
	public ResponseEntity<List<Airline>> getAllAirlineByRatingHighToLow(@PathVariable("direction") String direction,@RequestParam(required = true)String rating){
		try {

			List<Airline> airline = airlineServImpl.getAllAirlineByRatingDesc(direction,rating);

			if (airline.isEmpty()) {
				return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			}
			return new ResponseEntity<>(airline, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);

		}
	}

	
}
