using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace CarApp
{
    public class Car : ICar
    {
        //fields
        private string name, producer;
        private int year, seat;
        private float rootPrice;

        public string  Name { get => name; 
            set {
                if (value.Length < 0 || value.Length > 40) {
                    throw new Exception("Length must be 0 to 40 characters");
                }
                name = value;
            } 
        }
        public string Producer
        {
            get => producer;
            set
            {
                if (value.Length < 0 || value.Length > 40)
                {
                    throw new Exception("Length must be 0 to 40 characters");
                }
                name = value;
            }
        }
        public int Year {
            get => year;
            set
            {
                if (value <= 1900) {
                    throw new Exception("Year must be > 1900");
                }
                year = value;
            }
        }
        public int Seat
        {
            get => year;
            set
            {
                if (value < 0 || value > 200)
                {
                    throw new Exception("Seat must be 0 - 200");
                }
                year = value;
            }
        }
        public float Price
        {
            get => rootPrice;
            set
            {
                if (value < 0 )
                {
                    throw new Exception("Price must be > 0");
                }
                rootPrice = value;
            }
        }
        public float CalculatePrice() => Price + CalculateTax();
       

        public float CalculateTax() => Price * (Seat < 7 ? 0.6f : 0.7f);

        public void GetInfor()
        {
            Console.WriteLine($"{Name} produced by " +
                $"{Producer} in {Year} has " +
                $"{Seat} seats " +
                $"with total price is: {CalculatePrice()}");
        }
    }
}
