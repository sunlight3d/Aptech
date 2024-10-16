using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace ConsoleApp.Models
{
    internal class Point
    {
        private int x, y;
        //constructor
        /*
        public Point(int x, int y) {
            //java's style            
            this.x = x;
            this.y = y;
        }
        */
        //getter, setter in C#
        /*
        public int X {
            get {
                return x;
            }
            set { 
                x = value;
            }
        }
        */
        //getter, setter in C#(simplified)
        public int X { get; set; }
        public int Y
        {
            get
            {
                return y;
            }
            set
            {
                y = value;
            }
        }
        /*
        public int getX() {
            //DON't DO THIS IN C# !            
            return x;
        }
        public int getY()
        {
            return y;
        }
        public void setX(int x)
        {
            this.x = x;
        }
        public void setY(int y)
        {
            this.y = y;
        }
        */
       
        public override string ToString()
        {
            return  $"x = {X},"+
                    $"y = {Y}"
            ;
        }
    }
}
