using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Data;
using System.Data.SqlClient;

namespace WinformApp.Repositories
{
    public class Database
    {
        private SqlConnection sqlConnection;
        public static string CONNECTION_STRING = @"Data Source=(LocalDB)\MSSQLLocalDB;AttachDbFilename=|DataDirectory|\MyDatabase.mdf;Integrated Security=True";
        public SqlConnection GetConnection() {
            try
            {
                sqlConnection = new SqlConnection(CONNECTION_STRING);
                sqlConnection.Open();
                return sqlConnection;
            }
            catch (Exception e) {
                if (sqlConnection != null) {
                    sqlConnection.Close();
                }
                return null;
            }
        }
    }
}
