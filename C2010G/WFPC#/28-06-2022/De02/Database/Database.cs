using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Data.SqlClient;
using De02.Models;
using System.Data;

namespace De02.Database
{
    public class Database
    {
        private const String CONNECTION_STRING = 
                    "Data Source=(LocalDB)\\MSSQLLocalDB;" +
                    "AttachDbFilename=|DataDirectory|\\Database.mdf;" +
                    "Integrated Security=True";
        private static Database _database = null;
        //singleton pattern
        public static Database Instance {
            get => _database != null ? _database : new Database();
        }
        private SqlConnection? Connection { get {
                try
                {
                    SqlConnection connection = new SqlConnection(CONNECTION_STRING);
                    connection.Open();
                    return connection;
                }
                catch (Exception e) {
                    Console.WriteLine($"Cannot connect to DB: {e.ToString()}");
                    Connection.Close();
                    return null;
                }
            } 
        }
        public void UpdateStudent(String studentName, String userName, 
            int classCode,
            String address, int studentId) {            
            try
            {                
                String query = "UPDATE tblStudent SET " +
                                    "studentName=@studentName, " +
                                    "userName=@userName, " +
                                    "classCode=@classCode, " +
                                    "address=@address " +
                                    "WHERE studentId=@studentId";
                SqlCommand myCommand = new SqlCommand(query, this.Connection);
                myCommand.Parameters.AddWithValue("@studentName", studentName);
                myCommand.Parameters.AddWithValue("@userName", userName);
                myCommand.Parameters.AddWithValue("@classCode", classCode);
                myCommand.Parameters.AddWithValue("@address", address);
                myCommand.Parameters.AddWithValue("@studentId", studentId);

                myCommand.ExecuteNonQuery();                
            }
            catch (Exception e)
            {
                Console.WriteLine($"Cannot update student.Error: {e.ToString()}");                
            }
            finally
            {
                Connection.Close();
            }

        }
        public void DeleteStudent(int studentId)
        {
            try
            {
                String query = "DELETE FROM tblStudent WHERE studentId=@studentId";                                    
                SqlCommand myCommand = new SqlCommand(query, this.Connection);
                myCommand.Parameters.AddWithValue("@studentId", studentId);
                myCommand.ExecuteNonQuery();
            }
            catch (Exception e)
            {
                Console.WriteLine($"Cannot update student.Error: {e.ToString()}");
            }
            finally
            {
                Connection.Close();
            }

        }
        public bool Login(String userName, String password) {
            try
            {
                SqlDataReader myReader = null;
                String query = "SELECT * FROM tblStudent WHERE userName=@userName AND password=@password";
                SqlCommand myCommand = new SqlCommand(query, this.Connection);
                myCommand.Parameters.AddWithValue("@userName", userName);
                myCommand.Parameters.AddWithValue("@password", password);
                myReader = myCommand.ExecuteReader();
                while (myReader.Read())
                {                
                    return true;
                }                
                return false;
            }
            catch (Exception e)
            {
                Console.WriteLine($"Cannot query user.Error: {e.ToString()}");
                return false;
            }
            finally {
                Connection.Close();            
            }
        }
        public DataSet GetStudents() {
            try
            {
                SqlDataReader myReader = null;
                DataSet dataSet = new DataSet();
                String query = "SELECT studentId, className, studentName, userName, address"+
                  " FROM tblStudent"+
                  " INNER JOIN tblClass ON tblStudent.classCode = tblClass.classCode";
                SqlCommand myCommand = new SqlCommand(query, this.Connection);                
                myReader = myCommand.ExecuteReader();
                SqlDataAdapter dataAdapter = new SqlDataAdapter(query, this.Connection);
                dataAdapter.Fill(dataSet, "Student list");   
                
                return dataSet;
            }
            catch (Exception e)
            {
                Console.WriteLine($"Cannot query Student.Error: {e.ToString()}");
                return null;
            }
            finally
            {
                //Connection.Close();
            }
        }
        public DataSet GetClasses()
        {
            try
            {
                SqlDataReader myReader = null;
                DataSet dataSet = new DataSet();
                String query = "SELECT * FROM tblClass";
                SqlCommand myCommand = new SqlCommand(query, this.Connection);
                myReader = myCommand.ExecuteReader();
                SqlDataAdapter dataAdapter = new SqlDataAdapter(query, this.Connection);
                dataAdapter.Fill(dataSet, "class list");
                Connection.Close();
                return dataSet;
            }
            catch (Exception e)
            {
                Console.WriteLine($"Cannot query Class list.Error: {e.ToString()}");
                return null;
            }
            finally
            {
                Connection.Close();
            }
        }

    }
}
