using System;
using System.Collections.Generic;
using System.Text;

namespace ConsoleApp
{
    public interface IPerson
    {
        public string Skills { get; set; }
        public DateTime dateOfBirth { get; }
        public int Age { get; }

    }
}
