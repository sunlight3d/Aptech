using ConsoleApp.Models;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.IO;

namespace ConsoleApp
{
    internal class StudentTest
    {
        private string fileName = "student.dat";
        private List<Student> students = new List<Student>();
        public void InputSomeStudents() {           

            for (int i = 0; i < 2; i++)
            {
                Student student = new Student();

                student.Input();

                students.Add(student);
            }

        }
        public void WriteDataToFile() {
            try
            {
                using (BinaryWriter writer = new BinaryWriter(File.Open(this.fileName, FileMode.Create)))
                {                    
                    foreach (Student student in students)
                    {
                        writer.Write(student.RollNumber);
                        writer.Write(student.Name);
                        writer.Write(student.Age);
                        writer.Write(student.Address);
                    }
                }
            }
            catch (Exception ex)
            {
                Console.WriteLine("Error writing to file: " + ex.Message);
            }
        }
        public void readDataFromFile() {
            students.Clear();
            try
            {
                using (BinaryReader reader = new BinaryReader(File.Open(this.fileName, 
                    FileMode.Open)))
                {
                    while (reader.PeekChar() > -1)
                    {
                        string rollNumber = reader.ReadString();
                        string name = reader.ReadString();
                        int age = reader.ReadInt32();
                        string address = reader.ReadString();

                        students.Add(new Student
                        {
                            RollNumber = rollNumber,
                            Name = name,
                            Age = age,
                            Address = address
                        });
                    }
                }
                var filteredStudents = this.students
                                        .Where(student => student.Age < 18)
                                        .ToList();
                foreach(Student student in filteredStudents) {
                    Console.WriteLine(student);
                }
            }
            catch (Exception ex)
            {
                Console.WriteLine("Error reading from file: " + ex.Message);
            }
        }
    }
}
