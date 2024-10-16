using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace ExamApp
{
    public interface IDevice
    {
        public string Manufacturer {  get; set; }
        public int Price {  get; set; }
        public float VAT { get; }
        public float NetPrice { get; }        
    }
}
