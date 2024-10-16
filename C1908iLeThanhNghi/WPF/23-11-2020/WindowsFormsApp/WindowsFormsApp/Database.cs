using System;
using System.Collections.Generic;
using System.Data;
using System.Data.Common;
using System.Data.SqlClient;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using WindowsFormsApp.Models;

namespace WindowsFormsApp
{
    public class Database
    {
        private static Database instance;
        public static Database GetInstance() {
            if (instance == null) {
                instance = new Database();
                instance.GetConnection();
            }
            return instance;
        }
        private SqlConnection connection;
        private const string CONNECTION_STRING = "Server=DESKTOP-7PS7HG8\\SQLEXPRESS;Database=C1908iLTN;User Id=sa;Password=123456;";
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
        public Department GetDepartmentById(int departmentId)
        {
            Department department = null;
            try
            {
                string sql = $"SELECT * FROM Departments WHERE DeptID = {departmentId}";//SQL Injection
                SqlCommand command = new SqlCommand(sql, GetConnection());
                connection.Open();
                using (SqlDataReader sqlDataReader = command.ExecuteReader())
                {
                    while (sqlDataReader.Read())
                    {
                        return new Department()
                        {
                            DepartmentID = Convert.ToInt32(sqlDataReader["DeptID"]),
                            DepartmentName = sqlDataReader["DeptName"].ToString()
                        };
                        
                    }
                }
                return department;
            }
            catch (Exception e)
            {
                Console.WriteLine($"exception = {e.Message}");
                return department;
            }
            finally
            {
                connection.Close();                
            }
        }
        public List<Employee> GetEmployees(int departmentId) {
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
        public List<Department> GetAllDepartments() {
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
            finally {
                connection.Close();
            }
        }
        

    }
}
