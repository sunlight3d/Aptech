using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace de02
{
    internal class LuxuryCar:Car
    {
        public float specialRate = 80/100;
        public override float CalculatePrice()
        {
            return base.CalculatePrice() + RootPrice * specialRate;
        }
        public float CalculatePrice(float? transportCost) {
 
            return this.CalculatePrice()+transportCost ?? 0;
        }
    }
}
