using System;
namespace Exam2
{
    public class Book : IBook
    {
        //field = variables
        private string title = "";
        private string author = "";
        private string publisher = "";
        private int year;
        private string isbn = "";
        private List<string> chapters;
        public Book()
        {
            chapters = new List<string>();
        }


        public string this[int i] {
            get => i >= chapters.Count || i < 0  ? throw new Exception("Out of range") : chapters[i];
            set {
                if (i >= chapters.Count || i < 0)
                {
                    throw new IndexOutOfRangeException("Out of range");
                }
                chapters[i] = value;
            }
        }

        public string Title {
            get => title;
            set {
                if (value.Length < 6 || value.Length > 40)
                {
                    throw new Exception("Title must be 6 and 40 in length");
                }
                title = value;
            }
        }
        public string Author { get => author; set => author = value; }
        public string Publisher { get => publisher; set => publisher = value; }
        public List<String> Chapters { get => chapters; set => chapters = value; }
        public int Year {
            get => year;
            set {
                if (value < 1900 || value > DateTime.Now.Year)
                {
                    throw new Exception("Year must be 1900 to Now");
                }
                year = value;
            }
        }
        public string ISBN {
            get => isbn;
            set {
                if (value.Length != 13)
                {
                    throw new Exception("ISBN must be 13 characters in length");
                }
                isbn = value;
            }
        }

        public void Show()
        {
            Console.WriteLine("===================================================");
            Console.WriteLine($"Title: {title}\n" +
                $"Author: {author}\n" +
                $"publisher: {publisher}\n" +
                $"Year: {year}\n" +
                $"ISBN: {isbn}\n");
            Console.WriteLine("Chapter: ");
            int i = 0;
            foreach(string eachChapter in Chapters)
            {
                i++;
                Console.WriteLine($"       {i}: {eachChapter}");
            }
            Console.WriteLine("===================================================");
        }
        
    }
}

