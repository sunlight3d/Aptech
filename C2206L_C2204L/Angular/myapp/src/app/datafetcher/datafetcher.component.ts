import { Component, OnInit } from '@angular/core';
import {Product} from '../../models/product';
import { 
  ProductService 
} from '../services/product/product.service';
import { environment } from 'src/environments/environment';
@Component({
  selector: 'app-datafetcher',
  templateUrl: './datafetcher.component.html',
  styleUrls: ['./datafetcher.component.scss']
})
export class DatafetcherComponent implements OnInit{
  product?:Product
  colors: string[] = [
    '#3498db', 
    '#2ecc71', 
    '#e74c3c', 
    '#f39c12', 
    '#9b59b6'
  ];
  constructor(private productService: ProductService) { }
  ngOnInit(): void {
    //call api here
    let productId = 5;
    this.productService.fetchData(productId).subscribe({
      next: (response: Product) => {
        this.product = response
        debugger
        if(this.product.thumbnail != null) {
          this.product.thumbnail = `${environment.apiUrl}/products/images/${this.product.thumbnail}`
        }
        this.product.product_images = this.product.product_images.map(item => ({
          ...item,
          image_url: `${environment.apiUrl}/products/images/${item.image_url}`
        }));
      },  
      error: (error: any) => {
        debugger
      },
      complete: () => {
        debugger
      }
    })
  }
  selectedColorIndex: number = 0;//state of DataFetcher
  selectColor(index: number) {
    debugger
    this.selectedColorIndex = index;
  }
}
