using System;
using System.Collections.Generic;
using System.Data.Entity;
using System.Linq;
using System.Web;

namespace WAD_C2108G2_NguyenVanA.Models
{
    public class DataInitializer : DropCreateDatabaseIfModelChanges<DataContext>
    {
        public override void InitializeDatabase(DataContext context)
        {
            base.InitializeDatabase(context);
        }
        public static void SeedData(DataContext context) {
            if (!context.Projects.Any() && !context.Employees.Any()
                    && !context.ProjectEmployees.Any())
            {
                context.Projects.AddRange(new List<Project> {
                new Project {
                    ProjectId = 1,
                    ProjectName = "pro 11",
                    ProjectStartDate =DateTime.Parse("2023-12-23"),
                    ProjectEndDate = DateTime.Parse("2024-12-23"),
                },
                new Project {
                    ProjectId = 2,
                    ProjectName = "pro 22",
                    ProjectStartDate =DateTime.Parse("2021-12-23"),
                    ProjectEndDate = DateTime.Parse("2022-10-23"),
                },
                new Project {
                    ProjectId = 3,
                    ProjectName = "pro 33",
                    ProjectStartDate =DateTime.Parse("2020-11-21"),
                    ProjectEndDate = DateTime.Parse("2021-09-23"),
                }
                });
                context.SaveChanges();
                context.Employees.AddRange(new List<Employee> {
                new Employee {
                    EmployeeId = 1,
                    EmployeeName = "name11",
                    EmployeeDOB = DateTime.Parse("1993-12-12"),
                    EmployeeDepartment = "IT",
                },
                new Employee {
                    EmployeeId = 2,
                    EmployeeName = "name11",
                    EmployeeDOB = DateTime.Parse("1993-12-12"),
                    EmployeeDepartment = "IT",
                }
                });
                context.SaveChanges();
                context.ProjectEmployees.AddRange(new List<ProjectEmployee> {
                    new ProjectEmployee{
                        EmployeeId = 1,
                        ProjectId = 2,
                        Tasks = "Java app",
                    },
                    new ProjectEmployee{
                        EmployeeId = 1,
                        ProjectId = 2,
                        Tasks = ".net core mvc",
                    }
                });
                context.SaveChanges();
            }
        }
        protected override void Seed(DataContext context)
        {
            base.Seed(context);
            DataInitializer.SeedData(context);                       
        }
    }
}