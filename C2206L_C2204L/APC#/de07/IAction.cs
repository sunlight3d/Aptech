using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using static System.Runtime.InteropServices.JavaScript.JSType;

namespace de07
{
    interface IAction<T>
    {
        void AddToList(T item); //used to add an “item” into a List.
        void Display();// used to display information from a data List
        T this[int index] { get; set; }
    }
}