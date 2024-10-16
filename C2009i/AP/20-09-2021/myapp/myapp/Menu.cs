using System;
using System.Collections.Generic;
using System.Globalization;
using System.IO;
using CsvHelper;
using myapp.Helpers;
using myapp.models;

namespace myapp
{
    public class Menu
    {
        private int numberOfProducts;//field = variable
        private List<Product> products = new List<Product>();

        public void ShowMenu() {            
            Console.WriteLine("1.Input data of product list");
            Console.WriteLine("2.Sort & display data of product list");
            Console.WriteLine("3.Export data into file product.dat");
            Console.WriteLine("4.Exit");
            int choice = 0;
            while (true)
            {
                Console.WriteLine("Enter your choice");
                choice = Convert.ToInt32(Console.ReadLine());
                switch (choice)
                {
                    case 1:
                        //Console.WriteLine("choose 1");
                        Input();
                        break;
                    case 2:
                        ///Console.WriteLine("choose 2");
                        this.Display();
                        break;
                    case 3:
                        //should export to standard files : .csv(comma separared value),
                        ExportToCsv();
                        break;
                    case 4:
                        Console.WriteLine("Program ended");
                        return;
                    //break;
                    default:
                        Console.WriteLine("please select 1-4");
                        break;
                }
            }
        }
        private void Input() {
            Console.WriteLine("Enter number of products: ");
            this.numberOfProducts = Convert.ToInt32(Console.ReadLine());
            if (numberOfProducts <= 0) {
                Console.WriteLine("number of products  must be > 0");
                return;
            }
            for (int i = 0; i < numberOfProducts; i++) {
                //viec nhap input la cong viec tung project
                Product? product = Product.Input();
                if (product != null) {
                    products.Add((Product)product);
                } 
                
            }

        }
        private void Display() {            
            products.Sort((productA, productB) => productA.Price - productB.Price);
            foreach (Product product in products)
            {
                Console.WriteLine(product.ToString());
            }            
        }
        private void CreateFakeData() {
            products = new List<Product>()
            {
                new Product() {
                    Name = "aa",
                    Brand = "aaa",
                    Madein = "aaaa",
                    Price = 13,
                    ImportedDate = Utility.convertStringToDateTime("01/01/2000"),
                    ExpiredDate = Utility.convertStringToDateTime("01/01/2000")
                },
                new Product() {
                    Name = "bb",
                    Brand = "bbb",
                    Madein = "bbbb",
                    Price = 15,
                    ImportedDate = Utility.convertStringToDateTime("01/01/2000"),
                    ExpiredDate = Utility.convertStringToDateTime("01/01/2000")
                },
                new Product() {
                    Name = "cc",
                    Brand = "ccc",
                    Madein = "cccc",
                    Price = 12,
                    ImportedDate = Utility.convertStringToDateTime("01/01/2000"),
                    ExpiredDate = Utility.convertStringToDateTime("01/01/2000")
                },
            };
        }
        private void ExportToCsv() {
            CreateFakeData();
            string fileName = "";
            try
            {
                Console.WriteLine("Enter filename to save: ");
                fileName = Console.ReadLine();

                /*
                string updatedFileName = "";
                if (fileName.ToLower().Contains(".csv"))
                {
                    updatedFileName = fileName;
                }
                else {
                    updatedFileName = $"{fileName}.csv";
                }
                var writer = new StreamWriter(updatedFileName);
                */

                string updatedFileName = fileName.ToLower().Contains(".csv") ? fileName : $"{fileName}.csv";
                using StreamWriter file = new(updatedFileName);

                foreach (Product product in products)
                {
                    file.WriteLine($"{product.Name},{product.Brand},{product.Madein},{product.Price},{product.ImportedDate},{product.ExpiredDate},");                    
                }
                file.Close();
            }
            catch (Exception ex) {
                Console.WriteLine($"Cannot save to file {fileName}: {ex.Message}");
            }
                     
        }
    }
}
