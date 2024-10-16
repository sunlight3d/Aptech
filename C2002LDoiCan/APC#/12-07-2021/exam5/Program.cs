using System;
using exam5.Models;

namespace exam5
{
    class Program
    {
        static void Main(string[] args)
        {
            Console.WriteLine("Please input the three laptops:");
            LaptopList laptopList = new LaptopList(3);
            for(int i = 0; i < 3; i++) {
                Console.WriteLine($"Laptop no {i+1}");            
                
                Console.WriteLine("Name: ");
                String name = Console.ReadLine();

                Console.WriteLine("Price: ");
                int price = Convert.ToInt32(Console.ReadLine());
                Laptop laptop = new Laptop(i, name, price);
                laptopList.AddLaptop(laptop);
            }
            Console.WriteLine("Search Product by price!");
            float maxprice = float.Parse(Console.ReadLine());
            laptopList.ShowFilterLaptop(maxprice));
        }
    }
}
