using System;
namespace Exam2
{
    public class BookList
    {
        //field = variable
        private List<Book> list = new List<Book>();
        public void AddBook()
        {

            Book book = new Book();            

            Console.WriteLine("Input title: ");
            book.Title = Console.ReadLine() ?? "";

            Console.WriteLine("Input author: ");
            book.Author = Console.ReadLine() ?? "";

            Console.WriteLine("Input publisher: ");
            book.Publisher = Console.ReadLine() ?? "";

            Console.WriteLine("Input year: ");
            book.Year = Convert.ToInt32(Console.ReadLine());

            Console.WriteLine("Input isbn: ");
            book.ISBN = Console.ReadLine() ?? "";

            Console.WriteLine("Input chapter(finish with empty string)");
            int chapterNumber = 0;
            string eachChapter = "something";
            while(eachChapter.Trim().Length > 0)
            {
                chapterNumber++;
                Console.WriteLine($"Input chapter {chapterNumber}: ");
                eachChapter = Console.ReadLine() ?? "";
                if(eachChapter.Trim().Length > 0)
                {
                    book.Chapters.Add(eachChapter);
                }
            }            
            list.Add(book);
        }
        public void ShowList()
        {
            Console.WriteLine($"Amount of books: {list.Count}");
            foreach(Book book in list)
            {
                book.Show();
            }
        }
        public void InputList()
        {
            Console.WriteLine("Enter number of books: ");
            int numberOfBooks = Convert.ToInt32(Console.ReadLine());
            for (int i = 0; i < numberOfBooks; i++)
            {
                Console.WriteLine($"Enter book[{i+1}]");
                AddBook();
            }
        }
    }
}

