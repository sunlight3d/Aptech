using System;
using System.Collections.Generic;
using System.ComponentModel.Design;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace CourseEnrollementManagement
{
    internal class CourseManager
    {
        private List<Course> courses = [];
        public void ViewAllCourses()
        {
            foreach (var course in courses)
            {
                course.DisplayCourseInfo();
            }
        }
        public void AddCourse()
        {
            Console.WriteLine("Course online(1) or offline(2)");
            int courseType = int.Parse(Console.ReadLine() ?? "1");            
            Course course = (courseType == 1) ? new OnlineCourse() : 
                ((courseType == 2) ? new Course() : 
                throw new InvalidDataException("Invalid course"));
            course.Input();
            courses.Add(course);

        }
        public void DeleteCourse() {
            Console.WriteLine("Enter course's id to delete: ");
            int courseId = int.Parse(Console.ReadLine() ?? string.Empty);
            courses.Remove(courses.Where(c => c.CourseId == courseId).First());
        }
        public void UpdateCourse() { 

            Console.WriteLine(); 
        }
    }
}
