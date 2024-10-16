using System;
using System.Collections.Generic;
using System.Linq;
using System.Runtime.CompilerServices;
using System.Text;
using System.Threading.Tasks;

namespace APDe07
{
    public interface IAction<T>
    {
        void AddToList(T item);
        void Dislay();
        public T this[int index] {get; set; }
    }
}
