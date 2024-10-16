using System;
namespace MillionairesManagement.Models
{
    class Person : IPerson
    {
        public string? Name { get; set; }
        public string? Nationality { get; set; }
        public int BirthYear { get; set; }
        public float NetWorth { get; set; }

        public override string ToString() => $"|{Name} |{Nationality} |{BirthYear} |{NetWorth} |";
        //calculated value
        public int Age
        {
            get => BirthYear == 0 ? 0 : DateTime.Now.Year - BirthYear;
        }

        public void Input()
        {
            Console.WriteLine("Enter name: ");
            Name = Console.ReadLine()?.Trim() ?? "";
            Console.WriteLine("Enter Nationality: ");
            Nationality = Console.ReadLine().Trim() ?? "";
            Console.WriteLine("haha");
            while (Age <= 30)
            {
                Console.WriteLine("Enter BirthYear: ");
                BirthYear = Convert.ToInt32(Console.ReadLine());
                if (Age <= 30)
                {
                    Console.WriteLine("Person age must be greater than 30 in the current year");
                }
            }

            while (NetWorth < 1 || NetWorth > 100)
            {
                Console.WriteLine("Enter NetWorth: ");
                NetWorth = (float)Convert.ToDouble(Console.ReadLine());
                if (NetWorth < 1 || NetWorth > 100)
                {
                    Console.WriteLine("Networth must be between 1(billion $) and 100(billion $).");
                }
            }

        }
    }
}
