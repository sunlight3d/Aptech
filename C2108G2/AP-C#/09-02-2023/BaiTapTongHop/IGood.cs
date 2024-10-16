using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace BaiTapTongHop
{
    internal interface IGood
    {
        public int Price { get; set; }
        public string Stock { get; set; }
        public float VAT { get; }

    }
}
