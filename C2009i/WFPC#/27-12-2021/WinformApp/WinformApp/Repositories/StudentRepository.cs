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
        public Student login(string userName, string password) {
            try
            {
                using (SqlConnection sqlConnection = database.GetConnection())
                {
                    SqlCommand sqlCommand = new SqlCommand(
                        @"SELECT * FROM tblStudent WHERE UserName = @userName AND Password = @password",
                        sqlConnection);
                    sqlCommand.Parameters.AddWithValue("@userName", userName);//sql injection
                    sqlCommand.Parameters.AddWithValue("@password", password);
                    SqlDataReader sqlDataReader = sqlCommand.ExecuteReader();
                    while (sqlDataReader.Read())
                    {
                        loginStudent = new Student()
                        {
                            Gender = Convert.ToInt32(sqlDataReader["Gender"]),
                            DateOfBirth = (DateTime)sqlDataReader["DateOfBirth"],
                            Address = (string)sqlDataReader["Address"],
                            ClassId = Convert.ToInt32(sqlDataReader["ClassId"]),
                            StudentName = (string)sqlDataReader["StudentName"],
                            UserName = (string)sqlDataReader["UserName"],
                            Password = (string)sqlDataReader["Password"],
                        };
                        Console.WriteLine("haha");
                        return loginStudent;
                    }

                    // Call Close when done reading.
                    return null;
                }
            }
            catch (Exception e) {
                Console.WriteLine("Error login to your account: "+e.ToString());
                return null;
            }
        }
    }
}
