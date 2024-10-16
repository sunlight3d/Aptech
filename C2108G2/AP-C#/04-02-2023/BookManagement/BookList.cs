using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace BookManagement
{
    internal class BookList
    {
        private List<Book> list = new List<Book>();
        public void InputList() {
            Console.WriteLine("Enter number of books");
            int numberOfBooks = int.Parse(Console.ReadLine() ?? "0");
            for(int i = 0; i < numberOfBooks; i++)
            {
                AddBook();
            }
        }
        public void AddBook() {
            Book book = new Book { };
            book.Input();
            list.Add(book);
        }
    }
}
