using System;
using System.Collections.Generic;

namespace MyApp.Models
{   
    // Lớp Cell đại diện cho một ô trống trong mảnh đất
    public class Cell
    {
        public int Row { get; set; }
        public int Col { get; set; }
        public bool HasGold { get; set; }
        
    }
}
