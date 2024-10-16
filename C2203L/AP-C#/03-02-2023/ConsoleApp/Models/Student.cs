using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Text.RegularExpressions;
using System.Threading.Tasks;

namespace ConsoleApp.Models
{
    internal class Student
    {
        private string _name = ""; //this is variable
        private string _rollNumber = "";
        private string _address = "";
        private int _age;

        public string Name //this is function
        {
            get => _name;
            set { _name = value; }
        }

        public string RollNumber
        {
            get { return _rollNumber; }
            set { _rollNumber = value; }
        }

        public string Address
        {
            get { return _address; }
            set { _address = value; }
        }

        public int Age
        {
            get { return _age; }
            set { _age = value; }
        }

        public override string ToString()
        {
            return $"Name: {Name}, Roll Number: {RollNumber}, Address: {Address}, Age: {Age}";
        }
        public void Input() {
            Console.WriteLine("Enter name for student : ");
            this.Name = Console.ReadLine() ?? "";

                        

            bool isValid = false;
            do
            {
                Console.WriteLine("Enter roll number for student : ");
                string rollNumber = Console.ReadLine() ?? "";//C0909GV0908
                isValid = Regex.IsMatch(rollNumber, @"^[A-Za-z][0-9]{4}[A-Za-z]{1,2}[0-9]{4}$");
                if (!isValid)
                {
                    Console.WriteLine("Invalid roll number");
                }else {
                    this.RollNumber = rollNumber;
                }
            } while (!isValid);

            
            


            Console.WriteLine("Enter address for student : ");
            this.Address = Console.ReadLine() ?? "";

            Console.WriteLine("Enter age for student : ");
            this.Age = int.Parse(Console.ReadLine() ?? "0");
        }
    }
}
