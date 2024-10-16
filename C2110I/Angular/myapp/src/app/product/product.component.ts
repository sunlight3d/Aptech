import { Component, OnInit  } from '@angular/core';
import { ProductService } from '../services/product/product.service';
import { Product } from '../models/product.model';
@Component({
  selector: 'app-product',
  templateUrl: './product.component.html',
  styleUrls: ['./product.component.css']
})
export class ProductComponent implements OnInit {
  products: Product[] = [];
  public constructor(public productService: ProductService) {

  }
  ngOnInit() {
    this.productService.loadAllProducts().then(products => {
      debugger
      this.products = products
    }).catch(error => this.products = [])
  }

}
