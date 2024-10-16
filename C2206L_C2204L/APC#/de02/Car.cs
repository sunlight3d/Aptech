using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace de02
{
    internal class Car : ICar
    {
        //fields => variable => private 
        private string name;
        private string producer;
        private int year;
        private int seat;
        private float rootPrice;
        
        //properties = getter/setter => public
        public string Name { 
            get => name;
            set {
                if (value.Length < 0 || value.Length > 40) {
                    throw new ArgumentOutOfRangeException("Name must ben 0-40 in length");
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
                    throw new ArgumentOutOfRangeException("Producer must ben 0-40 in length");
                }
                producer = value;
            }
        }
        public int Year
        {
            get => year;
            set
            {
                if (value <= 1900)
                {
                    throw new ArgumentOutOfRangeException("Year must be > 1900");
                }
                year = value;
            }
        }
        public int Seat
        {
            get => seat;
            set
            {
                if (value <= 0 || value > 200)
                {
                    throw new ArgumentOutOfRangeException("Year must be 1-200");
                }
                seat = value;
            }
        }
        public float RootPrice
        {
            get => rootPrice;
            set
            {
                if (value < 0)
                {
                    throw new ArgumentOutOfRangeException("Rootprice must be > 0");
                }
                rootPrice = value;
            }
        }

        public float CalculateTax() => (seat < 7) ? 
                                        rootPrice * 0.6f : rootPrice * 0.7f;

        
        public virtual float CalculatePrice() {

            return RootPrice + CalculateTax();
                    
        } 

        /*
        private string name;
        private string producer;
        private int year;
        private int seat;
        private float rootPrice;
        */
        public void GetInfor()
        {
            Console.WriteLine(
                $"name = {Name}, " +
                $"producer = {Producer}"+
                $"year = {Year}"+
                $"seat = {Seat}" +
                $"rootPrice = {RootPrice}" +
                $"tax = {CalculateTax()}" +
                $"price = {CalculatePrice()}"
                );
        }

        
    }
}
