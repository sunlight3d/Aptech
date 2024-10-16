using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Data;
using System.Data.SqlClient;

namespace EmployeeManagementApp.Repositories
{
    public class Database
    {
        public const string CONNECTION_STRING = @"Data Source=localhost;Initial Catalog=ExamWinForm;Integrated Security=True";
        public SqlConnection GetConnection() {
            try
            {

            }
            catch (Exception error) {
                return null;
            }
        }
    }
}
