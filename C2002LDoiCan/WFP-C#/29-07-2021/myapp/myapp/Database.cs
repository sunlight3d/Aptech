using myapp.Models;
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
        private static Database _instance;
        private Database() { }
        public static Database GetInstance() {
            if (_instance == null) {
                _instance = new Database();
            }
            return _instance;
        }


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
        public List<ClassModel> GetAllClasses() { 

        }
        public List<Dictionary<String, String>> GetClassStudent() {
            List<Dictionary<String, String>> result = new List<Dictionary<string, string>>();
            using (SqlConnection sqlConnection = new SqlConnection(connectionString))
            {
                String sql = @"SELECT tblClass.TenLop, tblStudent.TenSv,tblStudent.UserNm, tblStudent.DiaChi "+ 
                                @"FROM tblStudent "+
                                @"INNER JOIN tblClass ON tblStudent.MaLop = tblClass.MaLop;";
                SqlCommand sqlCommand = new SqlCommand(sql, sqlConnection);                
                try
                {
                    sqlConnection.Open();
                    SqlDataReader reader = sqlCommand.ExecuteReader();
                    while (reader.Read())
                    {                
                        
                        Dictionary<String, String > dictionary = new Dictionary<String, String>();
                        dictionary.Add("TenLop", reader.GetString("TenLop"));
                        dictionary.Add("TenSv", reader.GetString("TenSv"));
                        dictionary.Add("UserNm", reader.GetString("UserNm"));
                        dictionary.Add("DiaChi", reader.GetString("DiaChi"));
                        result.Add(dictionary);
                        Console.WriteLine("haha");                        
                    }
                    reader.Close();
                }
                catch (Exception ex)
                {
                    Console.WriteLine(ex.Message);                    
                }
            }

            return result;
        }
    }
}
