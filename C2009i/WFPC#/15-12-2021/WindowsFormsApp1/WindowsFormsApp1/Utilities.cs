using System;
using System.Collections.Generic;
using System.Globalization;
using System.Linq;
using System.Text;
using System.Text.RegularExpressions;
using System.Threading.Tasks;

namespace WindowsFormsApp1
{
    public class Utilities
    {
        public static bool IsValidEmail(string email) =>
            new Regex(@"^([\w\.\-]+)@([\w\-]+)((\.(\w){2,3})+)$")
                .Match(email).Success;
        //ClassName.StaticMethodName(params,...)
        public static bool isValidPassword(string password) =>
            password.Length > 2;
    }   
}
