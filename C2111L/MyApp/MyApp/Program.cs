
using System;
class Program {
    public static void Main(string[] args)
    {
        // See https://aka.ms/new-console-template for more information
        int x = 10;
        int y = 20;
        int sum = x + y;
        Console.WriteLine(sum);
        string firstName = "Nguyen";
        string lastName = "Van A";
        string fullName = firstName + lastName;
        Console.WriteLine($"My fullname is {fullName}");
        
        Console.WriteLine("Enter your name: ");
        string name = Console.ReadLine() ?? "";

        Console.WriteLine("Enter year of birth: ");
        int year = int.Parse(Console.ReadLine() ?? "2000");
        DateTime dateTime = DateTime.Now;
        
        Console.WriteLine($"Name : {name}, age : {dateTime.Year - year}");
    }
}