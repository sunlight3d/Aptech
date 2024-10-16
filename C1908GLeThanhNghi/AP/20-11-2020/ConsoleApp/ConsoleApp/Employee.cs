using System;
using System.Collections.Generic;
using System.Text;

namespace ConsoleApp
{
    public abstract class Employee
    {
        private int _id;
        private string _name;
        public int ID { get; }
        public string Name { get; set; }
        public Employee(int _id) {
            this._id = _id;
            _name = "No name";
        }
        public Employee()
        {
            
        }
        public Employee(int _id, string _name)
        {
            this._id = _id;
            this._name = _name;
        }
        public abstract void ShowInfo();



    }
}
