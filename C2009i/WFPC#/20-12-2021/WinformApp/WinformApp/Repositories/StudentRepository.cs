using System;
using System.Collections.Generic;
using System.Data.SqlClient;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

using WinformApp.Models;
namespace WinformApp.Repositories
{
    public class StudentRepository
    {
        private Database database = new Database();
        private Student loginStudent;
        public Boolean login(string userName, string password) {
            try
            {
                using (SqlConnection sqlConnection = database.GetConnection())
                {
                    SqlCommand sqlCommand = new SqlCommand(
                        @"SELECT * FROM Students WHERE UserName = @userName AND Password = @password",
                        sqlConnection);
                    sqlCommand.Parameters.AddWithValue("@userName", userName);//sql injection
                    sqlCommand.Parameters.AddWithValue("@password", password);
                    SqlDataReader sqlDataReader = sqlCommand.ExecuteReader();
                    while (sqlDataReader.Read())
                    {
                        loginStudent = new Student()
                        {
                            UserName = (String)sqlDataReader["UserName"],
                            Password = (String)sqlDataReader["Password"],
                        };
                        Console.WriteLine("haha");
                        return true;
                    }

                    // Call Close when done reading.
                    return false;
                }
            }
            catch (Exception e) {
                Console.WriteLine("Error login to your account: "+e.ToString());
                return false;
            }
        }
    }
}
