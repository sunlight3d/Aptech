using System;
using System.Collections.Generic;
using System.Text;

namespace myApp
{
    
    public class Stack
    {        
        public List<int> Numbers { get; set; }
        public int this[int index] {
            get {
                return Numbers[index];
            }
            set {
                Numbers[index] = value;
            }
        }
    }
}
