using System;
using System.Collections.Generic;
using System.Data.Entity;
using System.Linq;
using System.Web;

namespace WAD_C2203L_NguyenVanA.Models
{
    public class DataInitializer : DropCreateDatabaseIfModelChanges<DataContext>
    {
        protected override void Seed(DataContext context)
        {
            var projects = new List<Project>
            {
                new Project { ProjectName = "Project A", ProjectStartDate = DateTime.Parse("2023-01-01"), ProjectEndDate = DateTime.Parse("2023-12-31") },
                new Project { ProjectName = "Project B", ProjectStartDate = DateTime.Parse("2023-02-01"), ProjectEndDate = DateTime.Parse("2023-11-30") },
                // Add more projects if needed
            };

            projects.ForEach(p => context.Projects.Add(p));
            context.SaveChanges();

            var employees = new List<Employee>
            {
                new Employee { EmployeeName = "John Doe", EmployeeDOB = DateTime.Parse("1985-01-01"), EmployeeDepartment = "Engineering" },
                new Employee { EmployeeName = "Jane Smith", EmployeeDOB = DateTime.Parse("1990-01-01"), EmployeeDepartment = "Design" },
                // Add more employees if needed
            };

            employees.ForEach(e => context.Employees.Add(e));
            context.SaveChanges();

            var projectEmployees = new List<ProjectEmployee>
            {
                new ProjectEmployee { EmployeeId =1, ProjectId = 1, Tasks = "Task 1" },
                new ProjectEmployee { EmployeeId = 1, ProjectId = 2, Tasks = "Task 2" },
                new ProjectEmployee { EmployeeId = 2, ProjectId = 1, Tasks = "Task 3" },
                new ProjectEmployee { EmployeeId = 2, ProjectId = 2, Tasks = "Task 4" },
                // Add more project-employee relations if needed
                };
            projectEmployees.ForEach(pe => context.ProjectEmployees.Add(pe));
            context.SaveChanges();
            base.Seed(context);
        }
    }
}