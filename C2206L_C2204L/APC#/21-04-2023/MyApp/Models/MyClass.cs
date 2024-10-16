using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace MyApp.Models
{
    class MyClass
    {
        public string Name { get; set; }

        public MyClass(string name)
        {
            Name = name;
        }

        ~MyClass()
        {
            //destructor
            Console.WriteLine("Object {0} is being finalized", Name);
        }
    }
}
