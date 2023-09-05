import { Component } from '@angular/core';
import { Router } from '@angular/router';
import { AuthenticationServiceService } from '../authentication-service.service';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent {
  username = '';
  password = '';
  invalidLogin = false

  constructor(private router: Router,
    private loginservice:AuthenticationServiceService ) { }

  checkLogin() {
    if (this.loginservice.authenticate(this.username, this.password)
    ) {
      this.router.navigate(['airline']);
      console.log("navigate..");
      this.invalidLogin = false;
    } else
      this.invalidLogin = true;
  }
}
