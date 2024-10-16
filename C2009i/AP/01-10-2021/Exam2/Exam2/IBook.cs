using System;
namespace Exam2
{
    public interface IBook
    {
        public string this[int i] { get; set;}
        //property in C# = getter/setter = function/method
        public string Title { get; set; }
        public string Author { get; set; }
        public string Publisher { get; set; }
        public int Year { get; set; }
        public string ISBN { get; set; }
        public void Show();
    }
}

