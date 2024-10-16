using System;
using System.Collections.Generic;
using System.Text;

namespace ConsoleApp
{
    public abstract class Employee
    {
        private int _id;
        private string _name;
        public int ID {
            get {
                return _id;
            }
        }
        public string Name   // property
        {
            get { return _name; }
            set {
                if (value.Length < 3) {
                    throw new Exception("Name must be >= 3 characters");
                }
                _name = value; 
            }
        }
        public abstract void ShowInfo();

        public Employee(int id) {
            _id = id;
            _name = "No name";
        }
        public Employee(int id, string name)
        {
            _id = id;
            _name = name;
        }

    }
    
}
