using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace BillionairesManagementProgram.Models
{
    class Person: IPerson
    {
        public string? Name {  get; set; }
        public string? Nationality { get; set; }
        public int BirthYear {  get; set; }
        public float NetWorth { get; set; }

        //calculated value
        public int Age {
            get => DateTime.Now.Year - BirthYear;
        }

        public void Input()
        {
            Console.WriteLine("Enter name: ");
            Name = Console.ReadLine()?.Trim() ?? "";
            Console.WriteLine("Enter Nationality: ");
            Nationality = Console.ReadLine().Trim() ?? "";

            while (Age <= 30) {
                Console.WriteLine("Enter BirthYear: ");
                BirthYear = Convert.ToInt32(Console.ReadLine());
                if(Age <= 30)
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
