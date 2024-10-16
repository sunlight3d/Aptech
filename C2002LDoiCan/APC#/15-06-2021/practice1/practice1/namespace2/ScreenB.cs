using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace practice1.namespace2
{
    public class ScreenB
    {
        public event EventHandler Changed;
        private String name;
        public String Name { 
            get {
                return name;
            } 
            set {
                
                name = value;
                //dat event vao day
                Changed?.Invoke(this, EventArgs.Empty);
            }
        }
        //khi nao thay doi Name, thi goi event

        public void functionB() { 

        }
    }
}
