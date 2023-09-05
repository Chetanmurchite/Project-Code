import { Injectable } from '@angular/core';



@Injectable({
  providedIn: 'root'
})
export class AuthenticationServiceService {

  constructor() { }
  
authenticate(username : any, password : any)  {
  if (username === "Chetan" && password === "Pass@123") { //pass
    sessionStorage.setItem('username', username)
    return true;
  } else {
    return false;
  }
}

isUserLoggedIn() {
  let user = sessionStorage.getItem('username') 
  console.log(!(user === null)) //!false
  return !(user === null)
}

logOut() {
  sessionStorage.removeItem('username')
}

}
