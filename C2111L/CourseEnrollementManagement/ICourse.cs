using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace CourseEnrollementManagement
{
    interface ICourse
    {
        float CalculateTotalFee();
        void DisplayCourseInfo();
    }
}
