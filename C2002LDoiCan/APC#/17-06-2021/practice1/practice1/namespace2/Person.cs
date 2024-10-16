using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace practice1.namespace2
{
    //Thang bi quan sat 
    public class Person : IObserver<Person>
    {
        public String Name { get; set; }

        public void OnCompleted()
        {
            Console.WriteLine("OnCompleted");
        }

        public void OnError(Exception error)
        {
            Console.WriteLine("OnError");
        }

        public void OnNext(Person value)
        {
            Console.WriteLine("OnNext");
        }
    }
}
