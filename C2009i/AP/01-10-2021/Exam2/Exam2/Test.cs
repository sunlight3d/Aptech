using System;

namespace Exam2
{

    public class Test
    {
        public delegate void MyDelegate(string inputString);

        public void DelegateMethod(string inputString)
        {
            Console.WriteLine($"You typed: {inputString}");
        }

        public void TestAll()
        {
            /*
            BookList bookList = new BookList();
            bookList.InputList();            
            bookList.ShowList();
            */
            // Instantiate the delegate.
            MyDelegate delegateObject = DelegateMethod;

            // Call the delegate.
            delegateObject("Hello World");
        }
    }
}

