namespace ProjectAppDotNetCore.Models
{
    public class DataInitializer 
    {
        public static void Seed(DataContext dataContext) {
            if (!dataContext.Projects.Any() && !dataContext.Employees.Any()) {
                /*
                dataContext.Projects.Add(new Project
                {
                    ProjectId = 1,
                    ProjectName = "Java project 001",
                    ProjectStartDate = DateTime.Now,
                });
                */
                dataContext.Projects.AddRange(
                    new Project
                    {
                        //ProjectId = 1,
                        ProjectName = "Java project 001",
                        ProjectStartDate = DateTime.Now,
                    },
                    new Project
                    {
                        //ProjectId = 2,
                        ProjectName = "Java project 002",
                        ProjectStartDate = DateTime.Now,
                    },
                    new Project
                    {
                        //ProjectId = 3,
                        ProjectName = "Java project 003",
                        ProjectStartDate = DateTime.Now,
                    });
                dataContext.SaveChanges();//commit
                dataContext.Employees.AddRange(
                    new Employee { 
                        //EmployeeId = 1,
                        EmployeeName = "Nguyen Van A",
                        EmployeeDOB = new DateTime(1989, 12, 25)
                    },
                    new Employee
                    {
                        //EmployeeId = 2,
                        EmployeeName = "Nguyen Van B",
                        EmployeeDOB = new DateTime(2002, 12, 23)
                    },
                    new Employee
                    {
                        //EmployeeId = 3,
                        EmployeeName = "Nguyen Van C",
                        EmployeeDOB = new DateTime(2001, 11, 25)
                    },
                    new Employee
                    {
                        //EmployeeId = 4,
                        EmployeeName = "Nguyen Van D",
                        EmployeeDOB = new DateTime(2000, 9, 25)
                    }
                    );
                dataContext.SaveChanges();//commit
                dataContext.ProjectEmployees.AddRange(
                    new ProjectEmployee { 
                        ProjectId = 1,
                        EmployeeId = 2,
                        Tasks= "Fix bugs, buy books",
                    },
                    new ProjectEmployee
                    {
                        ProjectId = 2,
                        EmployeeId = 2,
                        Tasks = "buy coffee, buy books",
                    }, new ProjectEmployee
                    {
                        ProjectId = 2,
                        EmployeeId = 3,
                        Tasks = "java code, c# code",
                    });
                dataContext.SaveChanges();
            }
        }
    }
}
