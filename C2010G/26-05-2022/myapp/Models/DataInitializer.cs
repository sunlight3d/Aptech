using System;
using System.Collections.Generic;
using System.Data.Entity;
using System.Linq;
using System.Web;

namespace myapp.Models
{
    public class DataInitializer : DropCreateDatabaseIfModelChanges<DataContext>
    {
        protected override void Seed(DataContext context)
        {
            base.Seed(context);
            context.Employees.Add(new Employee { 
                EmployeeId = 1,
                EmployeeName = "Nguyen Van A",
                EmployeeDOB = new DateTime(1993, 12, 20),
                EmployeeDepartment = "aa"
            });
            context.Projects.Add(new Project { 
                ProjectId = 1,
                ProjectName = "project aa",
                ProjectStartDate = new DateTime()
            });

            context.ProjectEmployees.Add(new ProjectEmployee
            {
                ProjectId = 1,
                EmployeeId = 1,
                Tasks = "di choi",

            });
            //commit to DB
            context.SaveChanges();
        }
    }
}