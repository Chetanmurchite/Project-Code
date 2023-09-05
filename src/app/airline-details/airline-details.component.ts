import { Component, OnInit } from '@angular/core';
import { Airline } from '../airline';
import { ActivatedRoute } from '@angular/router';
import { AirlineService } from '../airline.service';

@Component({
  selector: 'app-airline-details',
  templateUrl: './airline-details.component.html',
  styleUrls: ['./airline-details.component.css']
})
export class AirlineDetailsComponent implements OnInit {
  flightid: number = 0;
  airline: any = [];
  constructor(private route: ActivatedRoute, private airlineService: AirlineService) { }

  ngOnInit(): void {
    this.flightid = this.route.snapshot.params['flightid'];

    this.airline = new Airline();
    this.airlineService.getAirlineById(this.flightid).subscribe( data => {
    this.airline = data;
    });
  }

}
