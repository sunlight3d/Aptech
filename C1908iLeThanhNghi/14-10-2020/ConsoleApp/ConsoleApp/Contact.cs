using System;
using System.Collections.Generic;
using System.Text;

namespace ConsoleApp
{
    public class Contact
    {
        public string ContactName { get; set; }
        public long PhoneNumber { get; set; }
        public override string ToString()
        {
            return $"ContactName = {ContactName},phoneNumber = { PhoneNumber}";
        }
    }
}
