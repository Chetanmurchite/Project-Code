import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { HttpClientModule } from '@angular/common/http'
import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { CreateAirlineComponent } from './create-airline/create-airline.component';
import { AirlineDetailsComponent } from './airline-details/airline-details.component';
import { AirlineListComponent } from './airline-list/airline-list.component';
import { UpdateAirlineComponent } from './update-airline/update-airline.component';
import { FormsModule} from '@angular/forms';
import { HomeComponent } from './home/home.component';
import { LoginComponent } from './login/login.component';
import { LogoutComponent } from './logout/logout.component';
import { NgxPaginationModule } from 'ngx-pagination';

@NgModule({
  declarations: [
    AppComponent,
    CreateAirlineComponent,
    AirlineDetailsComponent,
    AirlineListComponent,
    UpdateAirlineComponent,
    HomeComponent,
    LoginComponent,
    LogoutComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    HttpClientModule,
    FormsModule,
    NgxPaginationModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
