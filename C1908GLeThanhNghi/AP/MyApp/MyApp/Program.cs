using MyApp.Helpers;
using System;
using System.Diagnostics;
using System.Reflection.Metadata.Ecma335;
using System.Collections;
using System.Collections.Generic;

namespace MyApp
{
    class Program
    {
        static void Main(string[] args)
        {
            Helper helper = new Helper();
            List<int> someNumbers = new List<int>() { 1,2,3};                        
            helper.GetSquared(someNumbers);            
            foreach(var eachNumber in someNumbers)
            {
                Console.WriteLine(eachNumber);
            }
            MyNumber myNumber = new MyNumber() { x = 100 };
            myNumber.x = 300;
            helper.doSomething(myNumber);
            Console.WriteLine($"x = {myNumber.x}");
            //helper.CheckDivideBy3();
            Console.WriteLine($"abs of -5 = > {helper.GetAbsoluteValue(-5)}");
            Console.WriteLine($"abs of 10 = > {helper.GetAbsoluteValue(10)}");
            Console.WriteLine("Start calculate");
            const int NUMBER_OF_STEPS = 1_0;
            long t1 = new DateTimeOffset(DateTime.UtcNow).ToUnixTimeMilliseconds();
            for (long i = 0; i < NUMBER_OF_STEPS; i++) {
                //Console.WriteLine($"sum from start to end : {helper.GetSum(1, 100_000)}");
                //Helper.WriteToFile($"sum from start to end : {helper.GetSum(1, 100_000)}");
                Helper.SaveLog($"sum from start to end : {helper.GetSum(1, 100_000)}");
                helper.GetSum(1, 100_000);
            }
            long t2 = new DateTimeOffset(DateTime.UtcNow).ToUnixTimeMilliseconds();
            Console.WriteLine($"Each step: {(t2 - t1)/NUMBER_OF_STEPS} ms");
            Console.WriteLine($"It takes {t2 - t1} ms");
            Console.WriteLine("End calculate");
        }
        
    }
}
