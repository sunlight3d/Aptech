using System;
using System.Collections.Generic;
using System.Text;

namespace ConsoleApp
{
    public class Programmer : Employee, IPerson
    {
        private string _skills;
        private DateTime _DOB;
        private int _age;

        public string Skills { get => _skills; set { _skills = value; } }

        public DateTime DateOfBirth { get => _DOB; set { _DOB = value; } }
        
        public int Age {
            get {
                _age = (int)Math.Ceiling(DateTime.Now.Subtract(_DOB).Days / 365.0);
                return _age;
            }
        }
        //constructor 1
        public Programmer(int id, string name) : base(id, name)
        {
            _skills = string.Empty;
            _DOB = DateTime.Now;
        }
        public override void ShowInfo()
        {
            Console.WriteLine($"id = {ID} | " +
                $"Name : {Name} | " +
                $"Skills : {_skills} | " +
                $"DOB : {_DOB} | " +
                $"Age : {_age}");
        }
    }
}
