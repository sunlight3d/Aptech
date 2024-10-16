using Microsoft.VisualBasic;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace BookManagement
{
    internal class Book : IBook
    {
        private string title;
        private string author;
        private string publisher;
        private int year;
        private string isbn;
        private List<string> chapters;
        public Book() {
            chapters = new List<string>();
        }
        public string this[int index] { 
            get => index >= chapters.Count - 1 || index < 0 
                    ? throw new Exception("chapter is out of range"): chapters[index]; 
            set => 
                chapters[index] =  index >= chapters.Count - 1 || index < 0
                    ? throw new IndexOutOfRangeException("chapter is out of range") : chapters[index]
            ; 
        }

        public string Title
        {
            get { return title; }
            set {
                /*
                if (value.Length >= 6 && value.Length <= 40)
                {
                    title = value;
                }
                else {
                    throw new Exception("length must be 6 - 40 characters");
                }
                */
                title = value.Length >= 6 && value.Length <= 40 ?
                          value : throw new Exception("length must be 6 - 40 characters");
            }
        }

        public string Author
        {
            get { return author; }
            set { author = value; }
        }

        public string Publisher
        {
            get { return publisher; }
            set { publisher = value; }
        }

        public int Year
        {
            get { return year; }
            set
            {
                year = (value >= 1900 && value <= DateTime.Now.Year) 
                    ? value : throw new ArgumentException("Year must be between 1900 and the current year");
            }
        }

        public string ISBN
        {
            get { return isbn; }
            set
            {
                isbn = (value.Length == 13) ? value : 
                    throw new ArgumentException("ISBN must be 13 characters in length");
            }
        }

        public List<string> Chapters
        {
            get { return chapters; }
        }

        public void Show()
        {
            Console.WriteLine($"Title: {title}\n" +
                $"Author: {author}\n" +
                $"Publisher: {publisher}\n" +
                $"Year: {year}\n" +
                $"ISBN: {isbn}\n" +
                $"Chapters: {string.Join(", ", chapters)}") ;

        }
        public void Input() {
            Console.WriteLine("Enter book title: ");
            Title = Console.ReadLine() ?? "";

            Console.WriteLine("Enter book author: ");
            Author = Console.ReadLine() ?? "";

            Console.WriteLine("Enter book publisher: ");
            Publisher = Console.ReadLine() ?? "";

            Console.WriteLine("Enter book year: ");
            Year = int.Parse(Console.ReadLine());

            Console.WriteLine("Enter book ISBN: ");
            ISBN = Console.ReadLine();
            string chapter = "";

            while (chapter != "")
            {
                Console.WriteLine("Enter a string (blank to exit): ");
                chapter = Console.ReadLine();

                if (chapter != "")
                {
                    chapters.Add(chapter);
                }
            }
        }
    }
}
