using System;

namespace _13_09_2021
{
    class Program
    {
        static void Main(string[] args)
        {
            Console.WriteLine("Hello World!");
            //struct and class in C ?
            
            //example
            Product productA = new Product(
                "iphone 12",
                "Apple",
                "Vietnam",
                new DateTime(2021,06, 25),
                new DateTime(2023, 06, 25)
            );
            Product productB = new Product(
                "iphone 11",
                "Apple",
                "Vietnam",
                new DateTime(2020, 07, 20),
                new DateTime(2023, 08, 20)
            );
            Product productC = productA;//clone object ! //struct is "assignment", class is "reference"
            //productC and productA: 2 separated objects? Yes
            productA.name = "iphone X";
            Console.WriteLine($"productA : {productA}");
            Console.WriteLine($"productB : {productB}");
            Console.WriteLine($"productC : {productC}");
            //example of class
            Student studentA = new Student("nguyen van A", 11);
            Student studentB = new Student("nguyen van A", 22);
            Student studentC = studentA;//reference
            studentA.name = "xxxx";
            Console.WriteLine($"studentA : {studentA}");
            Console.WriteLine($"studentB : {studentB}");
            Console.WriteLine($"studentC : {studentC}");
            //test user's class
            User userA = new User()
            {
                PhoneNumber = "1111111111", //setter
                Email = "usera@gmail.com",//setter
                FullName = "user A", //setter                                
            }; //builder pattern
            User userB = new User()
            {
                FullName = "user bb", //setter
                Email = "userbb@gmail.com",//setter                
                PhoneNumber = "22222222222", //setter
            }; //builder pattern
            userA.Email = "useraaaaaa@yahoo.com";//call setter
            Console.WriteLine($"email of A : {userA.Email}"); //call getter

            Console.WriteLine($"userA :{userA}");
            Console.WriteLine($"userB :{userB}");

            userB.DateOfBirth = new DateTime(1987, 12, 30);
            Console.WriteLine($"age of mr B = {userB.Age}");
            Console.WriteLine("1.Input data of product list");
            Console.WriteLine("2.Sort & display data of product list");
            Console.WriteLine("3.Export data into file product.dat");
            Console.WriteLine("4.Exit");
            int choice = 0;
            while (true) {
                Console.WriteLine("Enter your choice");
                choice = Convert.ToInt32(Console.ReadLine());
                switch (choice)
                {
                    case 1:
                        Console.WriteLine("choose 1");
                        break;
                    case 2:
                        Console.WriteLine("choose 2");
                        break;
                    case 3:
                        Console.WriteLine("choose 3");
                        break;
                    case 4:
                        Console.WriteLine("Program ended");
                        return;
                        //break;
                    default:
                        Console.WriteLine("please select 1-4");
                        break;
                }
                //if (choice == 4)
                //{
                //    break;
                //}

            }


        }
    }
}
