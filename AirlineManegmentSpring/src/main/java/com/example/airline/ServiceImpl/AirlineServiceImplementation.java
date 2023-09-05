package com.example.airline.ServiceImpl;

import java.util.ArrayList;

import java.util.List;
import java.util.Optional;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;

import com.example.airline.Repository.AirlineRepository;
import com.example.airline.model.Airline;
import com.example.airline.serviceInte.AirlineService;


/* The AirlineServiceImplementation class is a service class that provides the business logic 
   It implements the AirlineService interface to perform operations(Insert, Read, Update, Delete) on items.
  */


@Service
public class AirlineServiceImplementation implements AirlineService {
	AirlineRepository airlineRepository;

	public AirlineServiceImplementation(AirlineRepository airlineRepository) {
		this.airlineRepository = airlineRepository;
	}

	public Airline saveAirline(Airline airline) {
		return airlineRepository.save(airline);
	}

	// get all airlines or get by airlineName form database
	@Override
	public List<Airline> getAllAirline(String airlineName) {
		List<Airline> airline = new ArrayList<Airline>();

		if (airlineName == null)
			airlineRepository.findAll().forEach(airline::add);
		else
			airlineRepository.findByAirlineNameContainingIgnoreCase(airlineName).forEach(airline::add);

		return airline;
	}

	// get airline by id
	@Override
	public Optional<Airline> getAirlineById(int flightId) {
		Optional<Airline> airline = airlineRepository.findById(flightId);
		return airline;
	}

	// update airline by id
	@Override
	public Airline updateAirlineDetailsById(Optional<Airline> existingData, Airline newAirlineData) {
		Airline airline = existingData.get();
		airline.setDestination(newAirlineData.getDestination());
		airline.setDeparture(newAirlineData.getDeparture());
		airline.setCost(newAirlineData.getCost());
		airline.setRating(newAirlineData.getRating());
		airline.setAirlineName(newAirlineData.getAirlineName());
		airline.setIsinternational(newAirlineData.getIsinternational());
		return airlineRepository.save(airline);
	}

	// delete airline by id
	@Override
	public void deleteAirlineById(int flightId) {
		airlineRepository.deleteById(flightId);
	}


	// Delete All data
	public void deleteAllAirlines() {
		airlineRepository.deleteAll();
	}



//get all international flight 
	public List<Airline> findByisinternational(boolean status) {

		return airlineRepository.findByisinternational(status);
	}

   
	//get search by departure and destination
	public List<Airline> getAirlineDetails(String dest, String depa) {
		List<Airline> airline = new ArrayList<Airline>();
		airlineRepository.findByDestinationAndDeparture(dest, depa).forEach(airline::add);
		return airline;
	}

	//get sorting by cost
	public List<Airline> getAllAirlineByCostDesc(String direction,String cost) {
        List<Airline> airline = airlineRepository.findAll(Sort.by(getSortDirection(direction), cost));
		return airline;
	}
	
	//get sorting by rating
	public List<Airline> getAllAirlineByRatingDesc(String direction,String rating) {
        List<Airline> airline = airlineRepository.findAll(Sort.by(getSortDirection(direction), rating));
		return airline;
	}
	
	
	private Sort.Direction getSortDirection(String direction){
		if (direction.equals("asc")) {
			System.out.println(" came here");
			return Sort.Direction.ASC;
		}else if (direction.equals("desc")) {
			System.out.println("came here desc");
			return Sort.Direction.DESC;
		}
		return Sort.Direction.ASC;
	}

}
