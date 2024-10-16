import { Injectable } from '@angular/core'
import { environment } from 'environment'
import { Product } from 'src/app/models/product.model'
import { lastValueFrom } from 'rxjs'
import { HttpClient, HttpHeaders,HttpErrorResponse  } from '@angular/common/http'
import { catchError } from 'rxjs/operators';
import { throwError } from 'rxjs';


@Injectable({
  providedIn: 'root'
})
export class ProductService {
  //products: Product[] = []
  constructor(private http: HttpClient) { 
    
  }
  async loadAllProducts(): Promise<Product[]> {
    const url = `${environment.apiUrl}/Products/GetAllProducts`   
    const token = localStorage.getItem('token') 

    const headers = new HttpHeaders({
      'Authorization': 'Bearer ' + token
    })
    debugger
    const httpObject = this.http
    return new Promise<Product[]>((resolve, reject) => {
      debugger
      httpObject.get<Product[]>(url, {headers})
      .pipe(
        catchError((error: HttpErrorResponse) => {
          debugger
          console.error('Error occurred:', error);
          return throwError('Something went wrong; please try again later.');
        })
      )
      .subscribe((response: Product[]) => {
          debugger
          resolve(response)
      })      
    })       
  }
}
