using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace ConsoleApp.Models
{
    internal class Rectangle
    {

        /*
        public float GetWidth() { 
            //DONT DO THAT !
            return width;
        }
        */
        /*
        private float width, height;
        public float Width { 
            get { 
                return width; 
            } 
            set { 
                width = value >=0 ? value : 0;
            } 
        }
        public float Height
        {
            get
            {
                return height;
            }
            set
            {
                height = value >= 0 ? value : 0;
            }
        }
        */
        public float Width { get; set; }
        public float Height { get; set; }
        //all arguments contructor
        /*
        public Rectangle(float width, float height) { 
            //DON'T DO THAT !
            this.Width = width;
            this.Height = height;
        }
        */
        public float Area() => Width * Height;
        public override string ToString()
        {
            return $"width: {Width}, height: {Height}";  //string literal          
        }
        public double Perimeter() => 2 * (Width + Height);
    }
}
