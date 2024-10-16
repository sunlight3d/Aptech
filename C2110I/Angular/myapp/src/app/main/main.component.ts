import { Component, Inject, Injectable } from '@angular/core';
import { Language } from './../models/Language.model'
import { Student } from './../models/student.model'

@Component({
  selector: 'app-main',
  templateUrl: './main.component.html',
  styleUrls: ['./main.component.css']
})
export class MainComponent {
  // message:string = 'This is a test message';
  // x:number | string = 123;
  //student:Student;
  students: Student [] = []
  studentName: string = ""
  studentDOB?: Date
  gender: string = "Male"
  klass: string = ""
  klasses: string[] = ["C2110i", "C2003L", "c1234L", "c2233Y"]  
  languages: Language[] = [
    {
      name: "English",
      checked: true
    },
    {
      name: "French",
      checked: false
    },
    
    {
      name: "German",
      checked: false
    },
    {
      name: "Vietnamese",
      checked: false
    },
    {
      name: "Korean",
      checked: false
    }]  

  getSelectedLanguages = () => this.languages
                                   .filter(language => language.checked)
  onClickAdd() {    
    let selectedLanguages = this.getSelectedLanguages()
    this.students.push({
      name: this.studentName,
      dob: !!this.studentDOB ? new Date(this.studentDOB) : new Date(),
      gender: this.gender,
      languages: selectedLanguages,
      klass: this.klass
    })    
  }
  getLanguageString = (student:Student) => 
    student?.languages?.filter(language => !!language.checked)?.map(language => language.name)?.join(', ')
  
  constructor() {
    this.klass = this.klasses[0]
    //debugger
    //this.student =  new Student({name: 'Hoang', age:18});        
  }
  convertDateTimeToString(date: Date):string {    
    const day = date.getDate().toString().padStart(2, '0'); // add leading zero if needed
    const month = (date.getMonth() + 1).toString().padStart(2, '0'); // add leading zero if needed
    const year = date.getFullYear().toString();
    return `${day}-${month}-${year}`;    
  }
  onDeleteStudent(student: Student) {
    debugger  //confirm 
    this.students = this.students.filter(item => item.name != student.name)        
  }
}
