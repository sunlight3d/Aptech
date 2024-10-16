namespace CarApp
{
    internal class Program
    {
        static void Main(string[] args)
        {
            try {
                LuxuryCar myLuxuryCar = new LuxuryCar();
                myLuxuryCar.Input();
            }
            catch(Exception ex)
            {
                Console.WriteLine(ex.Message);
            }
        }
    }
}