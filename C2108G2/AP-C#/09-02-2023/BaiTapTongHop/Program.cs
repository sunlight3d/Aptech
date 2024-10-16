namespace BaiTapTongHop
{
    internal class Program
    {
        static void Main(string[] args)
        {
            Console.WriteLine("Please input 3 laptops");              
            LaptopList myList = new LaptopList(3);
            myList.Input();
            Console.WriteLine("Search products by price !");
            Console.WriteLine("Input max price: ");
            int maxPrice = int.Parse(Console.ReadLine() ?? "0");   
            myList.ShowFilterLaptop(maxPrice);
        }
    }
}