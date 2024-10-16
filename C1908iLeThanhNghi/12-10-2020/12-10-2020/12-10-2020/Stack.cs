using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;

namespace _12_10_2020
{
    public class Stack<T>
    {
        //Giong nhu tu quan ao = Last IN first OUT (LIFO)
        private List<T> items = new List<T>();
        //phuong thuc cho Stack: pop, push
        public void Push(T newItem) {
            //items.Append(newItem);
            items.Add(newItem);
        }
        public T Pop() {
            if (items.Count == 0) {
                return default(T);
            }
            var selectedItem = items[items.Count - 1];
            items.Remove(selectedItem);
            return selectedItem;
        }
        public Boolean IsEmpty() {
            return items.Count == 0;
        }
    }
}
