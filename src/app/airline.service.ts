import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http'
import { Observable } from 'rxjs';
import { Airline } from './airline';

@Injectable({
  providedIn: 'root'
})
export class AirlineService {

  private baseURL = "http://localhost:8081/airline.com/airline";

  constructor(private httpClient: HttpClient) { }

  getAirlineList(): Observable<Airline[]>{
    return this.httpClient.get<Airline[]>(`${this.baseURL}`);
  }

  findByAirlineName(airlineName: any): Observable<Airline[]> {
    return this.httpClient.get<Airline[]>(`${this.baseURL}?airlineName=${airlineName}`);
  }

  createAirline(airline: Airline): Observable<Object>{
    return this.httpClient.post(`${this.baseURL}`, airline);
  }

  getAirlineById(flightid: number): Observable<Airline>{
    return this.httpClient.get<Airline>(`${this.baseURL}/${flightid}`);
  }

  updateAirline(flightid: number, airline: Airline): Observable<Object>{
    return this.httpClient.put(`${this.baseURL}/${flightid}`, airline);
  }

  deleteAirline(flightid: number): Observable<Object>{
    return this.httpClient.delete(`${this.baseURL}/${flightid}`);
  }

  deleteAll(): Observable<any> {
    return this.httpClient.delete(`${this.baseURL}`);
  }
  findByisinternational(): Observable<Airline[]> {
    return this.httpClient.get<Airline[]>(`${this.baseURL}/isinternational`);
  }

  findByisdomastic(): Observable<Airline[]> {
    return this.httpClient.get<Airline[]>(`${this.baseURL}/domastic`);
}

  findByDestinationAndDeparture(destination : string, departure:string) :Observable<Airline[]>{
    console.log(destination,departure); return this.httpClient.get<Airline[]>(`${this.baseURL}/matchRoutes?dest=${destination}&depa=${departure}`);
  }

  sortByRating(pathVar : string,fieldName : string): Observable<Airline[]> {
  return this.httpClient.get<Airline[]>(`${this.baseURL}/filter/Rating/${pathVar}?rating=${fieldName}`);
  }

  sortByCost(pathVar : string,fieldName : string): Observable<Airline[]> {
    return this.httpClient.get<Airline[]>(`${this.baseURL}/filter/Cost/${pathVar}?cost=${fieldName}`);
    }
}
