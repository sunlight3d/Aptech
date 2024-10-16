import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-counter',
  templateUrl: './counter.component.html',
  styleUrls: ['./counter.component.scss']
})
export class CounterComponent implements OnInit{

  count:number = 0;//a state
  ngOnInit(): void {

  }
  increment() {
    debugger
    this.count++;
  }

  decrement() {
    this.count = this.count > 0 ? this.count - 1: this.count    
  }

  reset() {
    this.count = 0;
  }  
}
