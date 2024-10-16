using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace CarApp
{
    public class LuxuryCar:Car
    {
        private float specialRate = 0.8f;
        public override float CalculatePrice() => base.CalculatePrice() + Price * specialRate;
        public float CalculatePrice(float transportCost) =>
            this.CalculatePrice() + transportCost;
        public void Input() {
            //Name, Produderr, Year, Seat, proice
            Console.WriteLine("Enter name: ");
            Name = Console.ReadLine() ?? "";

            Console.WriteLine("Enter Producer: ");
            Producer = Console.ReadLine() ?? "";

            Console.WriteLine("Enter year: ");
            Year = int.Parse(Console.ReadLine());

            Console.WriteLine("Enter seat: ");
            Seat = int.Parse(Console.ReadLine());

            Console.WriteLine("Enter price: ");
            Price = float.Parse(Console.ReadLine());



        }

    }
}
