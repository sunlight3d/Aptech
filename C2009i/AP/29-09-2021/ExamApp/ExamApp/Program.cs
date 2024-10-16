// See https://aka.ms/new-console-template for more information

//Console.WriteLine("Hello, World!");
//Sprint
namespace ExamApp
{
    public class Program
    { 
        public static void Main(string[] args)
        {
            int numberOfLaptops = 3;
            LaptopList myList = new LaptopList(numberOfLaptops);
            try
            {
                for (int i = 0; i < numberOfLaptops; i++)
                {
                    //ID, name, price, manufacturer
                    Console.WriteLine("Enter id: ");
                    int id = Convert.ToInt32(Console.ReadLine());

                    Console.WriteLine("Enter name: ");
                    string name = Console.ReadLine();

                    Console.WriteLine("Enter price: ");
                    int price = Convert.ToInt32(Console.ReadLine());
                    Laptop laptop = new Laptop(id, name, price);
                    myList[i] = laptop;

                }
            }
            catch (Exception ex)
            {
                Console.WriteLine($"Cannot input laptop, error: {ex}");
            }
            Console.WriteLine("Enter max price: ");
            float maxprice = (float)Convert.ToDouble(Console.ReadLine());
            Console.WriteLine($"There are {myList.ShowFilterLaptop(maxprice)} laptops");

        }
    }
}