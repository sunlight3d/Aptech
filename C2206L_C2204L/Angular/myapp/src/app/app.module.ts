import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { CommonModule } from '@angular/common';
import { FormsModule } from '@angular/forms';
import { AppComponent } from './app.component';
import { LoginComponent } from './login/login.component';
import { CounterComponent } from './counter/counter.component';
import { DatafetcherComponent } from './datafetcher/datafetcher.component';
import { ColorItem } from './widgets/color.item/color.item';
import { HttpClientModule } from '@angular/common/http';

@NgModule({
  declarations: [
    AppComponent,
    LoginComponent,
    CounterComponent,
    DatafetcherComponent,
    ColorItem
  ],
  imports: [
    CommonModule,
    BrowserModule,
    FormsModule,
    HttpClientModule,
  ],
  providers: [],
  bootstrap: [
    //"root component"
    //AppComponent
    //LoginComponent,
    //CounterComponent,
    DatafetcherComponent
  ]
})
export class AppModule { }
