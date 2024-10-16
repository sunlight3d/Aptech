using System;
using System.Collections.Generic;
using System.Data;
using System.Data.SqlClient;
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
            string queryString = "SELECT * FROM Departments;";
            try
            {                                
                using (SqlConnection sqlConnection = new SqlConnection(Database.CONNECTION_STRING))
                {
                    SqlCommand sqlCommand = new SqlCommand(queryString, sqlConnection);
                    sqlConnection.Open();

                    SqlDataReader reader = sqlCommand.ExecuteReader();

                    // Call Read before accessing data.
                    while (reader.Read())
                    {
                        Console.WriteLine("haha");
                        Department department = new Department() {
                            DeparmentId = (string)reader[0],
                            DeparmentName = (string)reader[1]
                        };
                        result.Add(department);
                        //ReadSingleRow((IDataRecord)reader);
                    }
                    
                    reader.Close();
                }
                return result;
            }            
            catch (Exception error) {
                Console.WriteLine($"Error access DB: ${error.ToString()}");
                return result;
            }                                          
        }
        //key-value => Dictionary (da hoc o mon C#)
        public List<Dictionary<string, string>> getEmployees(string departmentId) {
            List<Dictionary<string, string>> dictionaries = 
                new List<Dictionary<string, string>>();
            List<Department> result = new List<Department>();
            //string queryString = "SELECT * FROM Employees WHERE Employees.DeptID = @deparmentId;";            
            string queryString = "SELECT " +
            "	Employees.EmployeeID as EmployeeID," +
            "	Employees.EmployeeName as EmployeeName," +
            "	Departments.DeptName as Department," +
            "	case Employees.Gender when 0 then 'False' else 'True' end as Gender," +
            "	FORMAT(Employees.BirthDate, 'MM/dd/yyyy') as BirthDate," +
            "	Employees.Tel as Tel," +
            "	Employees.Address as Address " +
            "FROM Employees " +
            "INNER JOIN Departments ON Employees.DeptID = Departments.DeptID " +
            "WHERE Employees.DeptID = @deparmentId;";            
            try
            {
                using (SqlConnection sqlConnection = new SqlConnection(Database.CONNECTION_STRING))
                {
                    sqlConnection.Open();
                    SqlCommand sqlCommand =
                        new SqlCommand(queryString, sqlConnection);
                    sqlCommand.CommandType = CommandType.Text;                    
                    sqlCommand.Parameters.Add("@deparmentId", departmentId);
                    SqlDataReader reader = sqlCommand.ExecuteReader();
                    // Call Read before accessing data.
                    while (reader.Read())
                    {
                        Dictionary<string, string> dictionary = new Dictionary<string, string>();                        
                        dictionary.Add("EmployeeID", reader[0].ToString());
                        dictionary.Add("EmployeeName", reader[1].ToString());
                        dictionary.Add("Department", reader[2].ToString());
                        dictionary.Add("Gender", reader[3].ToString());
                        dictionary.Add("BirthDate", reader[4].ToString());
                        dictionary.Add("Tel", reader[5].ToString());
                        dictionary.Add("Address", reader[6].ToString());
                        dictionaries.Add(dictionary);
                    }

                }
                return dictionaries;
            }
            catch (Exception error)
            {
                Console.WriteLine($"Error access DB: ${error.ToString()}");
                return dictionaries;
            }
            
        }
    }
}
