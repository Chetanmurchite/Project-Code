package com.example.airline.serviceInte;

import java.util.List;
import java.util.Optional;

import com.example.airline.model.Airline;

/* The AirlineService is service interface 
  and abstract method declaration
  */
public interface AirlineService {
	Airline saveAirline(Airline airline);
	List<Airline>getAllAirline(String title);
	Optional<Airline> getAirlineById(int flightId);
    Airline updateAirlineDetailsById(Optional<Airline> existingData,Airline newAirlineData);
	void deleteAirlineById(int flightId);
	void deleteAllAirlines();
	List<Airline> getAirlineDetails(String src,String dest);
}
