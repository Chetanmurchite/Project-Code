package com.example.airline.model;

import org.hibernate.annotations.DynamicUpdate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;


/*In this class, we declare private attribute to represent Airline details 
	and provide getter and setter for accessing these attributes.
*/
@Entity
@Table(name = "flightrecord")
@DynamicUpdate
public class Airline {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int flightid;

	@Column(name = "Destination")
	private String destination;

	@Column(name = "Departure")
	private String departure;

	@Column(name = "Cost",nullable = false)
	private String cost;
	
	@Column(name = "Rating",nullable = false)
	private String rating;

	@Column(name = "airlineName",nullable = false)
	private String airlineName;

	@Column(name = "isinternational", nullable = false)
	private Boolean isinternational;

	

	public Airline() {
	}

	public int getFlightid() {
		return flightid;
	}


	   

	

	public Airline(int flightid, String destination, String departure, String cost, String rating, String airlineName,
			Boolean isinternational) {
		super();
		this.flightid = flightid;
		this.destination = destination;
		this.departure = departure;
		this.cost = cost;
		this.rating = rating;
		this.airlineName = airlineName;
		this.isinternational = isinternational;
	}



	public String getDestination() {
		return destination;
	}

	public void setDestination(String destination) {
		this.destination = destination;
	}

	public String getDeparture() {
		return departure;
	}

	public void setDeparture(String departure) {
		this.departure = departure;
	}

	public String getCost() {
		return cost;
	}

	public void setCost(String cost) {
		this.cost = cost;
	}

	public String getRating() {
		return rating;
	}

	public void setRating(String rating) {
		this.rating = rating;
	}

	public String getAirlineName() {
		return airlineName;
	}

	public void setAirlineName(String airlineName) {
		this.airlineName = airlineName;
	}

	public Boolean getIsinternational() {
		return isinternational;
	}

	public void setIsinternational(Boolean isinternational) {
		this.isinternational = isinternational;
	}

	public void setFlightid(int flightid) {
		this.flightid = flightid;
	}

	@Override
	public String toString() {
		return "Airline [flightid=" + flightid + ", destination=" + destination + ", departure=" + departure + ", cost="
				+ cost + ", rating=" + rating + ", airlineName=" + airlineName + ", isinternational=" + isinternational
				+ "]";
	}

	

	
}
