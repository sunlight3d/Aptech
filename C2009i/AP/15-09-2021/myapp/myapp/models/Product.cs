using System;
using myapp.Helpers;

namespace myapp.models
{
    public struct Product
    {
        public String Name { get; set;}
        public String Brand { get; set; }
        public String Madein { get; set; }
        public int Price { get; set; }

        public DateTime ImportedDate { get; set; } //convention
        public DateTime ExpiredDate { get; set; } //convention


        public override string ToString() =>
                   $"name = {Name}, " +
                   $"brand = {Brand}, " +
                   $"madein = {Madein}, " +
                   $"price = {Price}, " +
                   $"importedDate = {ImportedDate}, " +
                   $"expiredDate = {ExpiredDate}";

        //Creational pattern(Factory method)
        public static Product? Input()
        {
            //vay muon cua Swift-Apple
            try
            {
                Console.WriteLine("Input name: ");
                string name = Console.ReadLine();

                Console.WriteLine("Input branch: ");
                string branch = Console.ReadLine();

                Console.WriteLine("Input madein: ");
                string madeIn = Console.ReadLine();

                Console.WriteLine("Input price: ");
                int price = Convert.ToInt32(Console.ReadLine());

                Console.WriteLine("Input importer date(dd/mm/yyyy): ");
                string importedDate = Console.ReadLine();

                Console.WriteLine("Input expired date(dd/mm/yyyy): ");
                string expiredDate = Console.ReadLine();

                return new Product()
                {
                    Name = name,
                    Brand = branch,
                    Madein = madeIn,
                    ImportedDate = Utility.convertStringToDateTime(importedDate),
                    ExpiredDate = Utility.convertStringToDateTime(expiredDate),
                };
            }
            catch (Exception exception) {
                Console.WriteLine(exception.Message);
                return null;
            }
        }
    }
}
