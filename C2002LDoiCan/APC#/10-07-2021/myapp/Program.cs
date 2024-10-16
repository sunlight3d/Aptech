using System;
using myapp.models;
using myapp.repositories;
namespace myapp
{
    class Program
    {
        static void Main(string[] args)
        {
            Console.WriteLine("Hello World!");
            //Khoi tao REpository
            //Sau nay se dung "Dependency Injection"
            MarkRepository markRepository = new MarkRepository();
            markRepository.GetMarks();
        }
    }
}
