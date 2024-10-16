// See https://aka.ms/new-console-template for more information

using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace BillionairesManagementProgram
{
    public class Program
    {
        
        public static void Main(string [] args)
        {
            Menu menu = new Menu();
            Console.WriteLine("Bilionaires Management Program");
            menu.ShowMenu();
        }
    }
}


