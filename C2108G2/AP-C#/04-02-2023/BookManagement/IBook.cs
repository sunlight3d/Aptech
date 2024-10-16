using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace BookManagement
{
    internal interface IBook
    {
        string this[int index] { get; set; }
        string Title { get; set; }
        string Author { get; set; }
        string Publisher { get; set; }
        int Year { get; set; }
        string ISBN { get; set; }
        void Show();

        //int x;//cannot contain variable/field
        //public static int x;//ok
        //int X { get; set; } //ok, why? because getter, setter is "functions"
        //public void DoSomething();//ok



    }
}
