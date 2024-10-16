using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace apDe6
{
    class Helper
    {
        public static int InputInt() { 
            return Convert.ToUInt16(Console.ReadLine());
        }
        public static string InputString()
        {
            return Console.ReadLine() ?? "";
        }
        public static Double InputDouble()
        {
            return Convert.ToDouble(Console.ReadLine());
        }
    }
}
