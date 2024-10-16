using _25_09_2020.models;
using System;
using System.Collections.Generic;
using System.Linq;

namespace _25_09_2020
{
    class Program
    {
        static void Main(string[] args)
        {

            //This is a block
            float width = 20.0f;
            float height = 30.0f;
            float area = 0.0f;
            {
                area = width * height;
            }
            Console.WriteLine("Area = {0}", area);
            int x1 = 2;
            int a = x1++;
            Console.WriteLine("a = {0}", a);
            byte x3 = 255;
            unchecked {
                byte x4 = (byte)(x3 + 3);
                Console.WriteLine("x4 = {0}", x4);
            }
            int c = 10;
            int d = 3;
            Console.WriteLine("thuong = {0}", (float)c / (float)d);
            Something something = new Something();
            something.x = 99;
            doSomething(something);
            Console.WriteLine("xx = {0}", something.x);
            int yy = 111;
       //     doSomething2(yy);
            Console.WriteLine("yy = {0}", yy);
            //BaiTapNgay23092020();
            //MenuExample();
            Car c1 = new Car("Mazda", 1233);
            c1.Name = "Honda"; //c1.setName("Honda"); trong Java

        }
        static void doSomething(Something something) {
            something.x = 120;
        }
        static void BaiTapNgay23092020()
        {
            //Bai tap ngay 23-09-2020
            Console.WriteLine("Enter total number of items inside the array : ");
            int numberOfItems = Convert.ToInt32(Console.ReadLine());
            List<int> numbers = new List<int>() { };
            int sum = 0;
            int numberOfEvens = 0;
            for (int i = 0; i < numberOfItems; i++)
            {
                Console.WriteLine("Phan tu thu {0}", i + 1);
                int newItem = Convert.ToInt32(Console.ReadLine());
                numbers.Append(newItem);
                sum += newItem;
                if (newItem % 2 == 0)
                {
                    numberOfEvens++;
                }
            }
            Console.WriteLine("sum = {0}, number of evens = {1}", sum, numberOfEvens);
            Console.ReadLine();
        }
        static void MenuExample() {
            Console.WriteLine("Enter a number(1-4): ");
            int choice;
            do
            {
                choice = Convert.ToInt32(Console.ReadLine());
                switch (choice)
                {
                    case 1:
                        Console.WriteLine("Ban chon 1");
                        break;
                    case 2:
                        Console.WriteLine("Ban chon 2");
                        break;
                    case 3:
                        Console.WriteLine("Ban chon 3");
                        break;
                    default:
                        Console.WriteLine("Please enter a choice");
                        break;
                }
            }
            while (choice != 4);
            Console.WriteLine("Program exit ");
            Console.ReadLine();
            
        }
    }
}
