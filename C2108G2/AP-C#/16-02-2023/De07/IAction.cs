using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace De07
{
    internal interface IAction<T>
    {
        void AddToList(T item);
        void Display();
        T this[int index] { get; set; }
    }
}
