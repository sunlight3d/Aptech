import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { environment } from 'environment';
@Injectable({
  providedIn: 'root'
})
export class UserService {
  constructor(private http: HttpClient) { 
    
  }
  login(email: string, password: string) {
    const url = `${environment.apiUrl}/users/login`   
    debugger     
    return this.http.post(url, {email, password});        
  }
}
