using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Data.SqlClient;

namespace De07
{
    public class MyConnection
    {        
        public SqlConnection? Connection
        {
            get {
                try
                {
                    SqlConnection conn = new SqlConnection(Constants.CONNECTION_STRING);
                    conn.Open();
                    return conn;
                }
                catch (SqlException e) {
                    Console.WriteLine(e.Message);   
                    return null;
                }
            }
        }        
    }
}
