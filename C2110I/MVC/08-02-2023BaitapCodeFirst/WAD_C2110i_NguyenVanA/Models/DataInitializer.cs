using System;
using System.Collections.Generic;
using System.Data.Entity;
using System.Linq;
using System.Web;

namespace WAD_C2110i_NguyenVanA.Models
{
    public class DataInitializer : DropCreateDatabaseIfModelChanges<DataContext>
    {
        protected override void Seed(DataContext context)
        {
            var projects = new List<Project>
        {
                        
                /*
                 //homework, add more properties
            new Project { ProjectName = "Project 2", ProjectDescription = "Project 2 description" },
            new Project { ProjectName = "Project 3", ProjectDescription = "Project 3 description" }
                */
        };

            projects.ForEach(p => context.Projects.Add(p));
            context.SaveChanges();

            var employees = new List<Employee>
        {
                /*
                 * //homework, add more properties
                    new Employee { EmployeeName = "Employee 1", EmployeeRole = "Developer" },
                new Employee { EmployeeName = "Employee 2", EmployeeRole = "Tester" },
                new Employee { EmployeeName = "Employee 3", EmployeeRole = "Manager" }
                */
            };

            employees.ForEach(e => context.Employees.Add(e));
            context.SaveChanges();

            var projectEmployees = new List<ProjectEmployee>
        {
            new ProjectEmployee { ProjectId = 1, EmployeeId = 1 },
            new ProjectEmployee { ProjectId = 1, EmployeeId = 2 },
            new ProjectEmployee { ProjectId = 2, EmployeeId = 3 }
        };

            projectEmployees.ForEach(pe => context.ProjectEmployees.Add(pe));
            context.SaveChanges();
        }
    }
}