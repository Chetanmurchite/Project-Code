import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { CreateAirlineComponent } from './create-airline/create-airline.component';
import { AirlineDetailsComponent } from './airline-details/airline-details.component';
import { AirlineListComponent } from './airline-list/airline-list.component';
import { UpdateAirlineComponent } from './update-airline/update-airline.component';
import { HomeComponent } from './home/home.component';
import { LoginComponent } from './login/login.component';
import { LogoutComponent } from './logout/logout.component';
import { AuthGaurdServiceService } from './auth-gaurd-service.service';
import { AuthenticationServiceService } from './authentication-service.service';

const routes: Routes = [
{path: 'airline', component: AirlineListComponent,canActivate:[AuthGaurdServiceService]},
{path: 'create-airline', component: CreateAirlineComponent,canActivate:[AuthGaurdServiceService]},
{path: '', redirectTo: 'airline', pathMatch: 'full'},
{path: 'update-airline/:flightid', component: UpdateAirlineComponent,canActivate:[AuthGaurdServiceService]},
{path: 'airline-details/:flightid', component: AirlineDetailsComponent,canActivate:[AuthGaurdServiceService]},
{path: 'home',component : HomeComponent},
{path: 'login', component: LoginComponent},
{ path: 'logout', component: LogoutComponent}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
