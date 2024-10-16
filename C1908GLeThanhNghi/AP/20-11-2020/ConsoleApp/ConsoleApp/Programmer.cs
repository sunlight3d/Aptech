using System;
using System.Collections.Generic;
using System.Text;

namespace ConsoleApp
{
    public class Programmer : Employee, IPerson
    {
        /*fields*/
        private string _skills;
        private DateTime _DOB;
        private int _age;

        public string Skills { get => _skills; set { _skills = value; } }

        public DateTime dateOfBirth => _DOB;

        public int Age => _age;
        public Programmer(int id, string name): base(id, name)
        {
            this._skills = string.Empty;
            this._DOB = DateTime.Now;

        }
        public override void ShowInfo()
        {
            Console.WriteLine($"Id: {this.ID}| Name : {this.Name}| Skills: {this.Skills}| DOB: {this._DOB}| Age : ");
        }
    }
}
{ 
}