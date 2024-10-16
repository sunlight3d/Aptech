using Microsoft.EntityFrameworkCore;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace StudentManagementConsole
{    
    public class StudentRepository
    {
        private MyDBContext myDBContext = new MyDBContext();
        public void InsertStudent() {
            Console.WriteLine("Add Student");
            Console.Write("Full Name: ");
            var fullName = Console.ReadLine();
            Console.Write("Gender: ");
            var gender = Console.ReadLine();
            Console.Write("Phone Number: ");
            var phoneNumber = Console.ReadLine();
            Console.Write("Height: ");
            var height = int.Parse(Console.ReadLine());
            Console.Write("DOB (yyyy-mm-dd): ");
            var dob = DateTime.Parse(Console.ReadLine());

            var student = new Student
            {
                FullName = fullName,
                Gender = gender,
                PhoneNumber = phoneNumber,
                Height = height,
                DOB = dob
            };
            myDBContext.Students.Add(student);
            myDBContext.SaveChanges();
            Console.WriteLine("Student added successfully");
        }

        public void ViewStudents()
        {
            Console.WriteLine("View Students");            
            var students = myDBContext.Students.Take(30).AsNoTracking().ToList();
            int i = 0;
            foreach (var student in students)
            {
                i++;                
                Console.WriteLine($"{i} - {student.ToString()}");                
            }
        }

        public void UpdateStudent()
        {
            Console.WriteLine("Update Student");
            Console.Write("Enter student id: ");
            var id = Console.ReadLine();
            var student =  myDBContext.Students.Find(id);
            if (student == null)
            {
                Console.WriteLine("Student not found");
                return;
            }

            Console.Write("Full Name ({0}): ", student.FullName);
            var fullName = Console.ReadLine();
            if (!string.IsNullOrEmpty(fullName))
            {
                student.FullName = fullName;
            }

            Console.Write("Gender ({0}): ", student.Gender);
            var gender = Console.ReadLine();
            if (!string.IsNullOrEmpty(gender))
            {
                student.Gender = gender;
            }

            Console.Write("Phone Number ({0}): ", student.PhoneNumber);
            var phoneNumber = Console.ReadLine();
            if (!string.IsNullOrEmpty(phoneNumber))
            {
                student.PhoneNumber = phoneNumber;
            }

            Console.Write("Height ({0}): ", student.Height);
            var height = Console.ReadLine();
            if (!string.IsNullOrEmpty(height))
            {
                student.Height = int.Parse(height);
            }

            Console.Write("DOB ({0}): ", student.DOB);
            var dob = Console.ReadLine();
            if (!string.IsNullOrEmpty(dob))
            {
                student.DOB = DateTime.Parse(dob);
            }

            myDBContext.SaveChanges();
            Console.WriteLine("Student updated successfully");
        }
        public void DeleteStudent()
        {
            Console.WriteLine("Delete Student");
            Console.Write("Enter student id: ");
            var id = Console.ReadLine();
            var student = myDBContext.Students.Find(id);
            if (student == null)
            {
                Console.WriteLine("Student not found");
                return;
            }

            myDBContext.Students.Remove(student);
            myDBContext.SaveChanges();
            Console.WriteLine("Student deleted successfully");
        }
    }
}
