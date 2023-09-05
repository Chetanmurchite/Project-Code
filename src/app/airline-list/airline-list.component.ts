import { Component, OnInit } from '@angular/core';
import { Airline } from '../airline'
import { AirlineService } from '../airline.service'
import { Router } from '@angular/router';
@Component({
  selector: 'app-airline-list',
  templateUrl: './airline-list.component.html',
  styleUrls: ['./airline-list.component.css']
})
export class AirlineListComponent implements OnInit{
  
  airline: Airline[] = [];
  airlineName : String = "";
  pageNo: number = 1;
  count: number = 5;
  details : string = "";
  selectedSearchType: string = 'text';
  destination: string ="";
  departure: string = "";
  constructor(private airlineService: AirlineService,
    private router: Router) { }

  ngOnInit(): void {
    this.getAirline();
  }

  search(selectedSearchType:string) {
    if (this.selectedSearchType === 'airlineName') {
      this.searchByAirlineName();
    } else if (this.selectedSearchType === 'destinationDeparture') {
      this.getAirlineDetailsByDestDepa();
    }
  }

  searchByAirlineName() : any{
    this.airlineService.findByAirlineName(this.airlineName).subscribe(details => {
      this.airline= details;
      console.log(this.details);
    },
      error => {
        console.log(error);
      });
  }

  // getAirlineDetailsByDestDepa() {
  //   // console.log('Detalis to search:', this.details);
    
  //   this.airlineService.getAirlineDetalisByDestinationDeparture(this.destinationDeparture).subscribe( details => {
  //       console.log('Response from service:', details);
  //       this.airline = details;
  //     },
  //     error => {
  //       console.log('Error:', error);
  //     }
  //   );
  // }

  getAirlineDetailsByDestDepa(){
    this.airlineService. findByDestinationAndDeparture(this.destination,this.departure).subscribe(details =>{
      
      console.log('Response from service:',details);
       this.airline= details;
    },
        error => {
          console.log(error);
       });
      
   }

  removeAllAirlines() : void{
    var status = confirm("Are you sure to delete all the records?");
    if (status == true) {
      this.airlineService.deleteAll().subscribe(details => {
        console.log(details);
        this.getAirline();
      },
        error => {
          console.log(error);
        })
    }
    else{
    this.getAirline();
  }
  }
  
  getisinternational() {
    this.airlineService.findByisinternational().subscribe({
      next: (airline) => {
      console.log(airline);
      this.airline = airline;
    },
    error: (e) => console.error(e)
  });
  }

  getisdomastic(){
    this.airlineService.findByisdomastic().subscribe({
      next: (airline) => {
      console.log(airline);
      this.airline = airline;
    },
    error: (e) => console.error(e)
  });
  }

  private getAirline(){
    this.airlineService.getAirlineList().subscribe(data => {
      this.airline = data;

  
    });
  }

  airlineDetails(flightid: number){
    this.router.navigate(['airline-details', flightid]);
  }

  updateAirline(flightid: number){
    this.router.navigate(['update-airline', flightid]);
  }

  deleteAirline(flightid: number){
    var status = confirm("Are you sure to delete this record?");
    if (status == true) {
    this.airlineService.deleteAirline(flightid).subscribe( data => {
      console.log(data);
      this.getAirline();
    })
  }
  else{
    this.getAirline();
  }

  }

  sortBy(sort: string): void{
    switch (sort){
      case 'costHigh':
      this.airlineService.sortByCost("desc","cost").subscribe(details =>{

        console.log('Response from service:',details);
        this.airline= details;
      },
      error => {
        console.log(error);
      });
      break;

      case 'costLow':
        this.airlineService.sortByCost("asc","cost").subscribe(details =>{

          console.log('Response from service:',details);
          this.airline= details;
        },
        error => {
          console.log(error);
        });
        break;

        case 'ratingLow':
        this.airlineService.sortByRating("asc","rating").subscribe(details =>{

          console.log('Response from service:',details);
          this.airline= details;
        },
        error => {
          console.log(error);
        });
        break;

        case 'ratingHigh':
          this.airlineService.sortByRating("desc","rating").subscribe(details =>{
  
            console.log('Response from service:',details);
            this.airline= details;
          },
          error => {
            console.log(error);
          });
          break;
          default:
          break;

      
    }
  }
}
