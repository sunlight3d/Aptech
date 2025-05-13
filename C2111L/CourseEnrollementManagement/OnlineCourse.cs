using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace CourseEnrollementManagement
{
    internal class OnlineCourse:Course
    {
        private float platformFee = 10.0f;
        public override float CalculateTotalFee()
        {
            return (base.FeePerStudent + this.platformFee) * base.EnrolledCount;
        }
        public override void DisplayCourseInfo()
        {
            Console.WriteLine($"Online Course: {CourseName} | Students:{EnrolledCount} | " +
                $"Total Fee: ${this.CalculateTotalFee()} (Includes platform fee)");
        }
    }
}
