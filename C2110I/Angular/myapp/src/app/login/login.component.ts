import { Component } from '@angular/core';
import { UserService } from '../services/user/user.service';
import { JwtHelperService } from '@auth0/angular-jwt';
import { UserResponse } from './../models/user.response.model';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.scss']
})
export class LoginComponent {
  title:string
  email:string
  password:string

  constructor(private userService: UserService, 
    private jwtHelper: JwtHelperService) {    
    this.title = 'Login to your account'
    this.email = 'nguyenvana@gmail.com'
    this.password = '12345678'
  }
  login():void {
    console.log('1')
    debugger
    this.userService.login(this.email, this.password)
    .subscribe(
      (value: UserResponse) => {                
        const decodedToken = this.jwtHelper.decodeToken(value?.token ?? "")
        localStorage.setItem('token', value?.token ?? "");
        debugger        
      },
      error => {
        debugger
        console.error(error)
      },
      () => {
        debugger
        console.log('Complete')
      }
    )    
    console.log('2')
  }
}
