using System;
using System.Collections.Generic;
using System.Text;

namespace ConsoleApp
{
    interface IPerson
    {
        public String Skills { get; set; }
        public DateTime DateOfBirth { get; }
        public int Age { get; }
    }
}
