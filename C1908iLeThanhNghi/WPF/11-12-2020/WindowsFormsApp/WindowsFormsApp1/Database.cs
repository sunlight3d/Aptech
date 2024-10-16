using System;
using System.Collections.Generic;
using System.Data.SqlClient;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using WindowsFormsApp1.models;

namespace WindowsFormsApp1
{
    public class Database
    {
    	public const string SERVER_NAME = "DESKTOP-7PS7HG8";
        public const string DATABASE_NAME = "C1908iLTN";
        public const string USER_ID = "sa";
        public const string USER_PASSWORD = "123456";
        private static Database instance;
        public static Database GetInstance()
        {
            if (instance == null)
            {
                instance = new Database();
                instance.GetConnection();
            }
            return instance;
        }
        private SqlConnection connection;
        private string CONNECTION_STRING = $"Server={SERVER_NAME}\\SQLEXPRESS;Database={DATABASE_NAME};User Id={USER_ID};Password={USER_PASSWORD};";
        public SqlConnection GetConnection()
        {
            try
            {
                connection = new SqlConnection(CONNECTION_STRING);
                return connection;
            }
            catch (SqlException e)
            {
                Console.WriteLine($"exception = {e.Message}");
                connection = null;
                return connection;
            }
        }
        public Student Login(string UserName, string Password)
        {
            Student student = null;
            try
            {
                string sql = $"SELECT * FROM tblStudent WHERE UserName = {UserName} AND Password = {Password}";//SQL Injection
                SqlCommand command = new SqlCommand(sql, GetConnection());
                connection.Open();
                using (SqlDataReader sqlDataReader = command.ExecuteReader())
                {
                    while (sqlDataReader.Read())
                    {
                        return new Student()
                        {
                            StudentId = Convert.ToInt32(sqlDataReader["StudentId"]),
							StudentName = sqlDataReader["StudentName"].ToString(),
							Gender = Convert.ToInt32(sqlDataReader["Gender"]) > 0 ? true : false,
							DateOfBirth = Convert.ToDateTime(sqlDataReader["DateOfBirth"]),
                            Address = sqlDataReader["Address"].ToString(),
							ClassId = Convert.ToInt32(sqlDataReader["ClassId"])
                        };

                    }
                }
                return student;
            }
            catch (Exception e)
            {
                Console.WriteLine($"exception = {e.Message}");
                return student;
            }
            finally
            {
                connection.Close();
            }
        }
        /*
        public void DeleteEmployeeById(int employeeId)
        {
            try
            {
                string sql = $"DELETE FROM Employees WHERE EmployeeID = '@employeeId'";//SQL Injection
                SqlCommand command = new SqlCommand(sql, GetConnection());
                command.Parameters.AddWithValue("@employeeId", employeeId);
                connection.Open();
                command.ExecuteNonQuery();
            }
            catch (Exception e)
            {
                Console.WriteLine($"Cannot delete Employee: ${employeeId}, exception = {e.Message}");
            }
            finally
            {
                connection.Close();
            }
        }
        public void insertEmployee(Employee employee)
        {
            try
            {
                string sql = $"INSERT INTO Employees(EmployeeName, DeptID, Gender, BirthDate, Tel, Address) " +
                    $"VALUES(@employeeName, @deptID, @gender, @birthDate, @telephone,@address)";//SQL Injection
                SqlCommand command = new SqlCommand(sql, GetConnection());
                command.Parameters.AddWithValue("@employeeName", employee.EmployeeName);
                command.Parameters.AddWithValue("@deptID", employee.DepartmentID);
                command.Parameters.AddWithValue("@gender", employee.Gender);
                command.Parameters.AddWithValue("@birthDate", employee.BirthDate);
                command.Parameters.AddWithValue("@telephone", employee.Telephone);
                command.Parameters.AddWithValue("@address", employee.Address);
                connection.Open();
                command.ExecuteNonQuery();
            }
            catch (Exception e)
            {
                Console.WriteLine($"Cannot insert Employee, exception = {e.Message}");
            }
            finally
            {
                connection.Close();
            }
        }

        public List<Employee> GetEmployees(int departmentId)
        {
            List<Employee> employees = new List<Employee>();
            try
            {
                string sql = $"SELECT * FROM Employees WHERE DeptID = {departmentId}";//SQL Injection
                SqlCommand command = new SqlCommand(sql, GetConnection());
                connection.Open();
                using (SqlDataReader sqlDataReader = command.ExecuteReader())
                {
                    while (sqlDataReader.Read())
                    {
                        employees.Add(new Employee()
                        {
                            EmployeeID = Convert.ToInt32(sqlDataReader["EmployeeID"]),
                            EmployeeName = sqlDataReader["EmployeeName"].ToString(),
                            DepartmentID = Convert.ToInt32(sqlDataReader["DeptID"]),
                            Gender = sqlDataReader["Gender"].ToString(),
                            BirthDate = Convert.ToDateTime(sqlDataReader["BirthDate"]),
                            Telephone = sqlDataReader["Tel"].ToString(),
                            Address = sqlDataReader["Address"].ToString(),
                        });
                        Console.WriteLine("Hello");
                    }
                }
                return employees;
            }
            catch (Exception e)
            {
                Console.WriteLine($"exception = {e.Message}");
                return employees;
            }
            finally
            {
                connection.Close();
            }
        }
        public List<Department> GetAllDepartments()
        {
            List<Department> departments = new List<Department>();
            try
            {
                string sql = "SELECT * FROM Departments";
                SqlCommand command = new SqlCommand(sql, GetConnection());
                connection.Open();
                using (SqlDataReader sqlDataReader = command.ExecuteReader())
                {
                    while (sqlDataReader.Read())
                    {
                        departments.Add(new Department()
                        {
                            DepartmentID = Convert.ToInt32(sqlDataReader["DeptID"]),
                            DepartmentName = sqlDataReader["DeptName"].ToString(),
                        });
                    }
                }
                return departments;
            }
            catch (Exception e)
            {
                Console.WriteLine($"exception = {e.Message}");
                return departments;
            }
            finally
            {
                connection.Close();
            }
        }
		*/

    }
}
