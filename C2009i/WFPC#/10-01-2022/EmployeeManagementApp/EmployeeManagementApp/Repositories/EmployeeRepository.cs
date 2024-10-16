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
    }
}
