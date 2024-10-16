using System;
using System.Collections.Generic;
using System.Text;

namespace MyApp.Helpers //namespace = package
{
    public class Helper
    {
        public const bool IS_DEVELOPMENT_MODE = false;
        public int GetSum(int start, int end) {
            int sum = 0;
            for (int i = start; i <= end; i++) {
                sum += i;
            }
            return sum;
        }
        public void GetSquared(List<int> numbers)
        {
            //List<int> result = new List<int>();           
            for (int i = 0; i < numbers.Count; i++)
            {
                //result.Add((int)Math.Pow(eachNumber, 2));                                
                numbers[i] = (int)Math.Pow(numbers[i], 2);
                i++;
            }

        }
        public void doSomething(MyNumber myNumber)
        {
            myNumber.x = 200;
        }
        public void CheckDivideBy3()
        {
            for (int i = 1; i <= 100; i++)
            {
                if (i % 3 == 0)
                {
                    Console.WriteLine($"i = {i}, BUZZZ");
                }
            }
            int numberOfElementsToPrint = 0;
            long index = 2;
            while(index <= 20_000_000_000 && numberOfElementsToPrint < 200)            
            {
                double log2X = Math.Log2(index);
                if (log2X - ((int)log2X) == 0)
                {                    
                    Console.WriteLine($"i = {index}, power(n) = {log2X}");
                    numberOfElementsToPrint++;
                }
                index += 1;                
            }
        }
        public int GetAbsoluteValue(int x) => x > 0 ? x : -x;//one-line function
        public static void SaveLog(string content)
        {
            if (IS_DEVELOPMENT_MODE)
            {
                Console.WriteLine(content);
            }
            else { 
                //save to file
            }
        }
    }    
    
}
