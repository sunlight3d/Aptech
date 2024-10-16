import { Component, OnInit } from '@angular/core';
import {NgForm, } from '@angular/forms';
import { HttpClient, HttpHeaders, HttpErrorResponse } from '@angular/common/http';


@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.scss']
})

export class LoginComponent implements OnInit{
  email: string = '';
  password: string = '';  
  
  ngOnInit(): void {
    debugger
  }  

  login() {    
    debugger
    console.log('Login button clicked');
    console.log('Username:', this.email);
    console.log('Password:', this.password);
  }
  isValidEmail():boolean {
    const validRegex = /^[a-zA-Z0-9.!#$%&'*+/=?^_`{|}~-]+@[a-zA-Z0-9-]+(?:\.[a-zA-Z0-9-]+)*$/;
    debugger
    return this.email.match(validRegex) != null;
  }
}
