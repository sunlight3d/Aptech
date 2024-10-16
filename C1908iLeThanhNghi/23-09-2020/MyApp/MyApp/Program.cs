using System;
using System.Collections.Generic;
using System.Linq;

namespace MyApp
{
    class Program   
    {
        public static void inputSomething()
        {
            //nhap ten va tuoi tu ban phim
            Console.WriteLine("Nhap ten cua ban : "); //output
            string name = Console.ReadLine();//input
            Console.WriteLine("Nhap tuoi: ");
            int age = Convert.ToInt32(Console.ReadLine());
            Console.WriteLine("name = {0}, age = {1}", name, age);
            Console.Write("Press any key to exit");
            Console.ReadLine();
        }
        public static List<int> getMinPositionAtMaxValue(List<int> listOfInteger) {
            /*
            for (uint i = 0; i < listOfInteger.Length; i++) {
                int eachNumber = listOfInteger[i];

            }
            */
            /*
            int minValue = int.MaxValue;
            foreach(int eachNumber in listOfInteger) {
                //Nen viet gon ntn :
                minValue = eachNumber < minValue ? eachNumber : minValue;
            }//doan nay dang viet bang tay => kieu gi cung cham hon so voi ham san co
            */
            int minValue = listOfInteger.Min();
            List<int> result = new List<int>(); 
            //den day thi moi biet min
            for (int i = 0; i < listOfInteger.Count(); i++)
            {
                int eachNumber = listOfInteger.ElementAt(i);
                if (eachNumber == minValue) {
                    result.Add(i);
                }   
            }
            return result;
        }
        public static double calculateFx(double x) {
            double result = 0.00;
            //f(x) = 2x^2 + 5x + 9 khi x >= 5, f(x) = -2x^2 + 4x – 9 khi x < 5
            result = x >= 5 ? 2 * Math.Pow(x, 2) + 5 * x + 9 :
                             -2 * Math.Pow(x, 2) + 4 * x - 9;
            return result;
        }
        static void Main(string[] args)
        {
            Random random = new Random();
            long t1 = DateTimeOffset.Now.ToUnixTimeMilliseconds();
            //foreach (int j in Enumerable.Range(0, 1_000_000_000)) { 
            for (int j = 0; j < 1_000_000_000; j++) {
                double randomNumber = random.Next(100, 100_000);
                //Console.WriteLine(calculateFx(randomNumber));
            }
            long t2 = DateTimeOffset.Now.ToUnixTimeMilliseconds();
            Console.WriteLine("Duration = {0}", (t2 - t1));
            List<int> listOfIntegers = new List<int>() {
                1,2,-5,-1,1,-5
            };
            List<int> result = getMinPositionAtMaxValue(listOfIntegers);
            foreach (int value in result) {
                Console.WriteLine(value);
            }
            //Khai bao bien(variable)
            /*
            int x = 100;//day goi la cac value type
            var y = 200;
            long z = 300L;
            double t = 123.45;
            float x1 = 1133.33f;
            //string literals hoac string concatenation
            Console.WriteLine("Gia tri x = {0}, gia tri y = {1}, z = {2}", x, y, z);
            string aString = "\u20A9";
            Console.OutputEncoding = System.Text.Encoding.UTF8;
            Console.WriteLine("Dong won la : {0}", aString);
            */
            //inputSomething();
            Console.WriteLine("Toi co {0:C} tien", 122);            
            long myVisaCard = 3225_1112_2254_8888L;
            Console.WriteLine("my visaCard = {0}", myVisaCard);
            //imlicit casting = ep kieu tu nho => to => luc nao cung ok
            int x2 = 120;
            long x3 = x2;//always successful
            //explicit casting = ep kieu tu to ve nho => kieu gi cung tran(overflow)
            /*
            int a = 257;
            char b = (char)a;
            Console.WriteLine("b = {0}", b);
            */
            /*
            Console.WriteLine("Min int = {0}", int.MinValue);
            Console.WriteLine("Max int = {0}", int.MaxValue);
            long a = int.MaxValue + 1L;
            int b = (int)a;
            Console.WriteLine("b = {0}", b);
            */


        }
    }
}
