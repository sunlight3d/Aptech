using System;

namespace MillionairesManagement
{
    public class Program
    {

        public static void Main(string[] args)
        {
            Menu menu = new Menu();
            Console.WriteLine("Bilionaires Management Program");
            menu.ShowMenu();
        }
    }
}
