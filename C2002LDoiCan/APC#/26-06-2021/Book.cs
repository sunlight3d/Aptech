using System;
using System.Collections.Generic;
namespace _26_06_2021
{
    public class Book:IBook
    {        
        private string title;
        private string author;
        private string publisher;
        private int year;
        private string isbn;

        private List<string> chapter;
        //default constructor
        public Book(){
            this.chapter = new List<string>();
        }
        
        public string this[int index]   // indexer declaration
        {
            // The arr object will throw IndexOutOfRange exception.
            get {
                try {
                    return chapter[index];
                }catch(IndexOutOfRangeException exception) {
                    Console.WriteLine("out of range: "+exception.ToString());
                    return "";
                }
            }
            set {
                if(index >=0 && index <= chapter.Count - 1) {
                    chapter[index] = value;
                } else if(index == chapter.Count) {
                    chapter.Add(value);
                } else {
                    throw new IndexOutOfRangeException("out of range, cannot set");
                }
                
            }
        }           
        public string Title {
            get {
                return title;
            }
            set {
                if(value.Length >= 6 && value.Length <= 40) {
                    title = value;
                } else {
                    Console.WriteLine("Lenth must be between 6 to 40 characters");
                }
            }
        }     
        public string Author {get => author;  set => author = value;}
        public string Publisher {get => publisher;  set => publisher = value;}
        public int Year {get => year;  set {
           if(value >= 1900 && value <= DateTime.Now.Year) {
               year = value;
           } else {
               Console.WriteLine("Year must be from 1900 to now");
           }
        }}
        public string ISBN {get => isbn;  set {
            if(value.Length == 13) {
               isbn = value;
           } else {
               Console.WriteLine("isbn length must be 13 characters");
           }
        }}
        public void Show() {
            Console.WriteLine("===============================================");            
            Console.WriteLine($"Title : {this.title}\n"+
            $"Author: {this.author}\n"+
            $"Publisher = {this.publisher}\n"+
            $"Year = {this.year}\n"+
            $"ISBN = {this.isbn}\n");
            Console.WriteLine("Chapter: ");
            int i = 0;
            foreach(string eachChapter in this.chapter) {
                i++;
                Console.WriteLine($"{i}. ${eachChapter}");    
            }
            Console.WriteLine("===============================================");            
        }
    }
}