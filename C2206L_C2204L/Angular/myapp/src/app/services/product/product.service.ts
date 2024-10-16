import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import {Product} from '../../models/product';
import { environment } from 'src/environments/environment';

@Injectable({
  providedIn: 'root'
})
export class ProductService {
  urlProduct:string = 'http://127.0.0.1:8088/api/v1/products/5';
  //http://127.0.0.1:8088/api/v1/products/images/imageName
  constructor(private http: HttpClient) { }

  fetchData(productId: number): Observable<Product> {    
    return this.http.get<Product>(this.urlProduct);
  }
}
