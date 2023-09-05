package com.example.airline.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.airline.model.Airline;

/*The AirlineRepository interface is a spring Data JPA repository that provides 
 	databases access and CRUD operations for the Airline entity.
*/

@Repository
public interface AirlineRepository extends JpaRepository<Airline, Integer> {

	List<Airline> findByisinternational(boolean status);

	Iterable<Airline> findByAirlineNameContainingIgnoreCase(String airlineName);

	Iterable<Airline> findByDestinationAndDeparture(String dest, String depa);

}
