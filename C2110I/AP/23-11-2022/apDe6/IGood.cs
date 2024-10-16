using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace apDe6
{
    public interface IGood
    {
        //public int x; //NO!, this is instance attribute

        public int Price { get; set; } //this is "function"-property
        public string Stock { get; set; } //read-write = getter + setter
        public float VAT { get; } //read-only = only getter
        public float PriceCal { get; }

        //public static float PI = 3.14f; //interface can contain "static attribute"
        //public static var xxx = 123; //var can not be an "attribute"
        //public var DoSomething(); //function cannot have "var" type !
    }
}
