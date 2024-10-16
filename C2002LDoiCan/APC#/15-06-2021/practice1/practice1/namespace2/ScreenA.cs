using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace practice1.namespace2
{
    public class ScreenA
    {
        public void ListenEventFromB(object sender, EventArgs e) {
            Console.WriteLine($"Thang B thay doi day: {((ScreenB)sender).Name}");
        }
    }
}
