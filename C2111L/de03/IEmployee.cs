﻿using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace de03
{
    internal interface IEmployee
    {
        double CalculateBonus(string designation, int tenure, double salary);
        void DisplayDetails();

    }
}
