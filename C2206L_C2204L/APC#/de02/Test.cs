using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace de02
{
    internal class Test
    {
        public void TestSomething() { 
            LuxuryCar myLuxuryCar = new LuxuryCar();
            try {
                Console.WriteLine("enter name: ");
                myLuxuryCar.Name = Console.ReadLine() ?? "";//nil-coalescing
                Console.WriteLine("enter producer: ");
                myLuxuryCar.Producer = Console.ReadLine() ?? "";//nil-coalescing

                Console.WriteLine("Year : ");
                myLuxuryCar.Year = int.Parse(Console.ReadLine());

                Console.WriteLine("seat : ");
                myLuxuryCar.Seat = int.Parse(Console.ReadLine());

                Console.WriteLine("root price : ");
                myLuxuryCar.RootPrice = float.Parse(Console.ReadLine());

            }
            catch(Exception e)
            {
                Console.WriteLine("Cannot input");
                Console.WriteLine(e.Message);
            }
        }
    }
}
