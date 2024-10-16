using System;
using System.Collections.Generic;
using System.Linq;
using System.Net;
using System.Text;
using System.Threading;
using System.Threading.Tasks;

namespace ConsoleApp.Models
{
    internal class Student
    {
        private string studentNumber;
        private string studentName;
        private int age;
        private string address;

        public string StudentNumber
        {
            get { return studentNumber; }
            set { studentNumber = value; }
        }

        public string StudentName
        {
            get { return studentName; }
            set { studentName = value; }
        }

        public int Age
        {
            get { return age; }
            set { age = value; }
        }

        public string Address
        {
            get { return address; }
            set { address = value; }
        }

        public override string ToString()
        {
            return "Student Number: " + studentNumber +
                    ", Student Name: " + studentName +
                    ", Age: " + age + 
                    ", Address: " + address;
        }
        public void Input() {
            Console.WriteLine("Enter student number");
            this.studentNumber = Console.ReadLine() ?? "";

            Console.WriteLine("Enter student name");
            this.studentName = Console.ReadLine() ?? "";

            Console.WriteLine("Enter student age");
            this.age = Convert.ToInt32(Console.ReadLine());

            Console.WriteLine("Enter student address");
            this.address = Console.ReadLine() ?? "";

        }
    }    

}
