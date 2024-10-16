using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace ProductApp
{
    public interface IGood
    {
        int Price { get; set; }
        string Stock { get; set; }
        float VAT { get; } //read only, donot have setter
        float PriceCal { get; }
    }
}
