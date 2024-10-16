using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace ConsoleApp
{
    internal class Rectangle
    {
        private float width = 1.0f, height  = 1.0f;
        public float Width { get => width; set {
                if (value > 0.0f && value < 20.0f)
                {
                    width = value;
                }
                /*
                else { 
                    throw new Exception("Width must be between 0.0 and 20");
                } 
                */
            }
        }
        public float Height { get => height; set
            {
                if (value > 0.0f && value < 20.0f)
                {
                    height = value;
                }
                /*
                else
                {
                    throw new Exception("Height must be between 0.0 and 20");
                }
                */
            }
        }
        public float Perimeter { get => 2 * (width + height); }
        public float Area { get => width * height; }
      
        public override string? ToString()
        {
            return $"width: {width}," +
                    $"height: {height}, "+
                     $"perimeter: {Perimeter},"+
                     $"area: {Area}";
        }
    }
}
