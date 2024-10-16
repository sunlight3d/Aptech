using EmployeeManagementApp.Models;
using System;
using System.Collections.Generic;
using System.Data.SqlClient;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace EmployeeManagementApp.Repositories
{
    public class EmployeeRepository
    {
        public void DeleteEmployeeById(int employeeId) {
            try
            {
                using (SqlConnection sqlConnection = new SqlConnection(Database.CONNECTION_STRING)) {
                    SqlCommand sqlCommand = sqlConnection.CreateCommand();
                    sqlConnection.Open();
                    sqlCommand.CommandText = @"DELETE FROM Employees WHERE EmployeeID = @employeeId";
                    sqlCommand.Parameters.AddWithValue("@employeeId", employeeId);
                    sqlCommand.ExecuteNonQuery();
                }                
            }
            catch (Exception e)
            {
                Console.WriteLine($"Error delete item: {e.ToString()}");
            }
        }
        public void InsertEmployee(Employee employee)
        {
            try
            {
                using (SqlConnection sqlConnection = new SqlConnection(Database.CONNECTION_STRING))
                {
                    SqlCommand sqlCommand = sqlConnection.CreateCommand();
                    sqlConnection.Open();
                    sqlCommand.CommandText = @"INSERT INTO Employees(EmployeeName, DeptID, Gender, BirthDate, Tel, Address)"+
                        @" VALUES(@EmployeeName, @DeptID, @Gender, @BirthDate, @Tel, @Address)";
                    sqlCommand.Parameters.AddWithValue("@EmployeeName", employee.EmployeeName);
                    sqlCommand.Parameters.AddWithValue("@DeptID", employee.DeparmentId);
                    sqlCommand.Parameters.AddWithValue("@Gender", employee.Gender);
                    sqlCommand.Parameters.AddWithValue("@BirthDate", employee.BirthDate);
                    sqlCommand.Parameters.AddWithValue("@Tel", employee.Telephone);
                    sqlCommand.Parameters.AddWithValue("@Address", employee.Address);
                    sqlCommand.ExecuteNonQuery();
                }
            }
            catch (Exception e)
            {
                Console.WriteLine($"Error insert item: {e.ToString()}");
            }
        }
    }
}
