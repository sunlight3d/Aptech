using System;
using System.Collections.Generic;
using System.Text;

namespace _12_10_2020
{
    public struct Point
    {
        public int x;
        public int y;
        public Point(int _x, int _y) {
            x = _x;
            y = _y;
        }
    }
    public class Coordinator: ICloneable { 
        public int X { get; set; }
        public int Y { get; set; }

        public object Clone()
        {
            Coordinator clonedObject = new Coordinator() { 
                X = X,
                Y = Y
            };
            return clonedObject;
        }
    }
}
