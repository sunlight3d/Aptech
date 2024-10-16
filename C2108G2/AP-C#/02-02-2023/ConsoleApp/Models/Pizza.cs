using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace ConsoleApp.Models
{
    public class Pizza
    {
        private float diameter;
        private int numberOfSlices;

        public float Diameter
        {
            get { return diameter; }
            set { diameter = value; }
        }

        public int NumberOfSlices
        {
            get { return numberOfSlices; }
            set { numberOfSlices = value; }
        }

        public override string ToString()
        {
            return "Diameter: " + diameter 
                + " inches" + "\n" +
                "Number of Slices: " + numberOfSlices;
        }
    }
}
