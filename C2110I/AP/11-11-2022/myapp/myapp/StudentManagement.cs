using System;
using myapp.models;

namespace myapp
{
	public class StudentManagement
	{
		private List<Student> _students = new List<Student>();//eager init
		//private List<Student> _students;//lazy, field

		//property(Getter, Setter)
		//public List<Student> Students {
		//	get {
		//		_students = _students ?? new List<Student>();
  //              return _students;
  //          }
		//}

        public void Input() {
			Console.WriteLine("Number of students : ");
			int numberOfStudents = Convert.ToInt32(Console.ReadLine());			
			for (int i = 0; i < numberOfStudents; i++) {
				Student student = new Student();
				student.Input();
                _students.Add(student);
			}
		}
	}
}

