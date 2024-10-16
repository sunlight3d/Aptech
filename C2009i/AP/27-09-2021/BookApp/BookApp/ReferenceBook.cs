using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace BookApp
{
    class ReferenceBook: Book
    {
        public float Tax { get; set; }
        public override double TotalPrice
        {
            get => Count * Price * (1 + Tax);
        }
    }
}
