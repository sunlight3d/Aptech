using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace CarApp
{
    public interface ICar
    {
        public float CalculateTax();
        public float CalculatePrice();
        public void GetInfor();

    }
}
