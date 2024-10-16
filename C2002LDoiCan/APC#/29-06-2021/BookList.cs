using System;
using System.Collections.Generic;
namespace _26_06_2021
{
    public class BookList {
        private List<Book> list = new List<Book>();
        public List<Book> Books { 
            get {
                return list;
            } 
        }
        public void AddBook() {
            Console.WriteLine("==============================================");
            Console.WriteLine("Input book information");
            Console.Write("Input title:"); 
            string title = Console.ReadLine();

            Console.Write("Input author:"); 
            string author = Console.ReadLine();

            Console.Write("Input publisher:"); 
            string publisher = Console.ReadLine();

            Console.Write("Input ISBN:"); 
            string isbn = Console.ReadLine();

            Console.Write("Input year:"); 
            int year = Convert.ToInt32(Console.ReadLine());

            List<string> chapters = new List<string>();
            string eachChapter = "";
            int i = 0;
            do {
                i++;
                Console.WriteLine("Input chapter(finish with empty string): "); 
                Console.WriteLine($"Input chapter {i}: "); 
                eachChapter = Console.ReadLine();
                if(eachChapter.Trim().Length > 0) {
                    chapters.Add(eachChapter);
                }
            }while(eachChapter.Trim().Length > 0);
            //ko phai nho thu tu
            Book book = new Book() {
                Title = title,
                Author = author,
                ISBN = isbn,
                Publisher = publisher,                
                Year = year,
                Chapter = chapters
            };
            list.Add(book);
        }
        public void ShowList() {
            foreach (Book book in this.list) {
                book.Show();
            }
        }
        public void InputList() {
            Console.Write("Amount of book: ");
            int amountOfBooks = Convert.ToInt32(Console.ReadLine());
            for(int i = 0; i < amountOfBooks; i++) {
                this.AddBook();
            }
        }
    }
}