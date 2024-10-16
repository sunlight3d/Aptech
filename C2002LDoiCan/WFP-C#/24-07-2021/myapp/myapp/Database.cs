using System;
using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Data;
using System.Data.SqlClient;
using System.Drawing;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace myapp
{
    public class Database
    {
        private const String connectionString
            = @"Server=localhost,1445;Database=testdb;User Id=sa;Password=Abc123456789;";            
        public bool login(String userName, String password) {
            bool result = false;
            using (SqlConnection sqlConnection = new SqlConnection(connectionString)) {
                String sql = "SELECT * FROM tblStudent WHERE tblStudent.UserNm = @userName AND tblStudent.Password = @password;";
                SqlCommand sqlCommand = new SqlCommand(sql, sqlConnection);
                sqlCommand.Parameters.AddWithValue("@userName", userName);
                sqlCommand.Parameters.AddWithValue("@password", password);
                try
                {
                    sqlConnection.Open();
                    SqlDataReader reader = sqlCommand.ExecuteReader();
                    while (reader.Read())
                    {
                        Console.WriteLine("haha");
                        return true;
                    }
                    reader.Close();
                }
                catch (Exception ex)
                {                    
                    Console.WriteLine(ex.Message);
                    return false;
                }
            }
            return result;
        }

    }
}
