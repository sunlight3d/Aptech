using System;

namespace _26_06_2021
{
    public interface IBook
    {        
        public string this[int index]
        {
            get; set;
        }        
        public string Title {get; set;}
        public string Author {get; set;}
        public string Publisher {get; set;}
        public int Year {get; set;}
        public string ISBN {get; set;}
        public void Show();
    }
}