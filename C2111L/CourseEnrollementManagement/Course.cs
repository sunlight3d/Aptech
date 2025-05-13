using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace CourseEnrollementManagement
{
    internal class Course : ICourse
    {
        private int courseId;
        private string courseName;
        private float feePerStudent;
        private int enrolledCount;

        public int CourseId { get => courseId; set {
                if(value <= 0 ) throw new Exception("id must be > 0");
                courseId = value;
            } 
        }

        public string CourseName
        {
            get => courseName; 
            set
            {
                if (value.Trim().Length < 3 || value.Trim().Length > 100) throw new Exception("Length must be 3 to 100");
                courseName = value;
            }
        }
        public float FeePerStudent
        {
            get => feePerStudent; set
            {
                if (value <= 0) throw new Exception("FeePerStudent must be > 0");
                feePerStudent = value;
            }
        }
        public int EnrolledCount
        {
            get => enrolledCount; set
            {
                if (value <= 0) throw new Exception("enrolledCount must be > 0");
                enrolledCount = value;
            }
        }

        public Course() { }
        public Course(int _courseId, string _courseName, float _feePerStudent, int _enrollent) {
            CourseId = _courseId;
            CourseName = _courseName;
            FeePerStudent = _feePerStudent;
            EnrolledCount = _enrollent;

        }        


        public virtual float CalculateTotalFee()
        {
            return FeePerStudent * EnrolledCount;
        }

        public virtual void DisplayCourseInfo()
        {
            Console.WriteLine($"Course: {CourseName} | Students: {enrolledCount} | Total Fee: {CalculateTotalFee()}");
        }
        public void Input() {
            Console.WriteLine("Enter id: "); 
            this.CourseId = int.Parse(Console.ReadLine() ?? "1");

            Console.WriteLine("Enter name: ");
            this.CourseName = Console.ReadLine() ?? "";

            Console.WriteLine("Fee per student: "); 
            this.FeePerStudent = float.Parse(Console.ReadLine() ?? "1");

            Console.WriteLine("enrolledCount: ");
            this.FeePerStudent = int.Parse(Console.ReadLine() ?? "1");
        }
    }
}
