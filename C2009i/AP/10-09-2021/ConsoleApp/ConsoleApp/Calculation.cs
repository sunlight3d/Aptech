using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace ConsoleApp
{
    class Calculation
    {
        public static double Sum2Numbers(double x, double y) {
            return x + y;
        }
        //one-line function/lambda expression
        //like "stream in Java"
        public static double Substract2Numbers(double x, double y) => x - y;

        //optional parameters
        public static int GetRectangleArea(int height, int? width) {
            //?? = Elvis Operator
            //width ?? height => neu width thi bieu thuc width ?? height nhan gia tri la "height"
            return (width ?? height) * height;
        }
        //function with default value 
        public static int FunctionA(int y, int x = 10) {

            return x + y;
        }

        //viet function tinh toan => tinh thoi gian tinh toan
        public static double CalculateSomething(double x) {
            //pow = power
            return Math.Pow(x, 100) + 20 * Math.Pow(x, 30) + 123;
        }
        /*
        public static long Fibonaci(long n){            
            if (n == 0 || n == 1)
            {
                return 1;
            }
            else {
                return Fibonaci(n - 1) + Fibonaci(n - 2);
            }                        
        }
        */
        public static long Fibonaci(long n) =>
            (n == 0 || n == 1) ? 1 : Fibonaci(n - 1) + Fibonaci(n - 2);
    }
}
