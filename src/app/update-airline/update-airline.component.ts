import { Component,OnInit} from '@angular/core';
import { AirlineService } from '../airline.service';
import { Airline } from '../airline';
import { ActivatedRoute, Router } from '@angular/router';



@Component({
  selector: 'app-update-airline',
  templateUrl: './update-airline.component.html',
  styleUrls: ['./update-airline.component.css']
})
export class UpdateAirlineComponent implements OnInit {
  flightid: number = 0;
  airline: Airline = new Airline();
  constructor(private airlineService: AirlineService,
    private route: ActivatedRoute,
    private router: Router) { }

  ngOnInit(): void {
    this.flightid = this.route.snapshot.params['flightid'];
    console.log(this.flightid);
    this.airlineService.getAirlineById(this.flightid).subscribe(data => {
      this.airline= data;
    }, error => console.log(error));
  }

  onSubmit(){
    this.airlineService.updateAirline(this.flightid, this.airline).subscribe( data =>{
      this.goToAirlineList();
    }
    , error => console.log(error));
  }

  goToAirlineList(){
    this.router.navigate(['/airline']);
  }
}
