using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace BookApp
{
    public class Book
    {        
        public string Code {  get; set; } //Code = getter/setter = function 
        public DateTime InputDate {  get; set; }
        public double Price {  get; set; }
        public int Count {  get; set; }
        public string Publisher { get; set; }
        public virtual double TotalPrice { get; }

    }

}
