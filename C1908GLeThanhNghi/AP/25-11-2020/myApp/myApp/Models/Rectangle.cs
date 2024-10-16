using System;
using System.Collections.Generic;
using System.Text;

namespace myApp.Models
{
    public class Rectangle
    {
        private float length;
        private float width;
        public float Length {
            get {
                return length;
            }
            set {
                length = (value < 0.0f || value > 20.0f) ? 0.0f : value;
                //length = value;
            }
        }
        public float Width { get; set; }
    }
}
