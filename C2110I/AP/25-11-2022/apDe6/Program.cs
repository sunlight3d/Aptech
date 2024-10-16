
using apDe6;
using System.Data;

public class Program {
    public static void Main(string[] args) {        
        LaptopList laptopList = new LaptopList();
        int choice = 0;        
        while (choice != 4) {
            Console.WriteLine("1. Insert Laptop");
            Console.WriteLine("2. Show all Laptops");
            Console.WriteLine("3. Filter laptop");
            Console.WriteLine("4. Exit");
            Console.WriteLine("Enter your choice: ");
            choice = Convert.ToUInt16(Console.ReadLine());
            switch (choice) {
                case 1:
                    Console.WriteLine("Number of laptops: ");                    
                    laptopList.Capacity = Helper.InputInt();
                    laptopList.Input();
                    break;
                case 2:
                    for (int i = 0; i < laptopList.Capacity; i++) {
                        laptopList[i].showInfo();                        
                    }
                    break;
                case 3:
                    Console.WriteLine("Enter max price:");
                    float maxPrice = (float)Helper.InputDouble();
                    laptopList.ShowFilterLaptops(maxPrice);
                    break;
                case 4:
                    break;
                default:
                    Console.WriteLine("Please enter 1-4");
                    break;
            }
        }

    }
}

