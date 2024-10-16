using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using EmployeeManagementApp.Models;

namespace EmployeeManagementApp.Repositories
{
    public class DepartmentRepository
    {
        public List<Department> GetAllDepartments() {
            List<Department> result = new List<Department>();
            string sql = "SELECT * FROM Department;";
            //to be continue...
            return result;            
        }
    }
}
