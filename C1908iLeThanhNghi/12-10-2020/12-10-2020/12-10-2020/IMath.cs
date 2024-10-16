using System;
using System.Collections.Generic;
using System.Text;

namespace _12_10_2020
{
    public interface IMath<T> where T : IComparable<T> 
    {
        public T add(T a, T b);
        public T substract(T a, T b);
    }
}
