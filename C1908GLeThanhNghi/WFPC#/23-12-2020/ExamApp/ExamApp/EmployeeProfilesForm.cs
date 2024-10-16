using ExamApp.models;
using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Data;
using System.Drawing;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Windows.Forms;

namespace ExamApp
{
    public partial class EmployeeProfilesForm : Form
    {
        public EmployeeProfilesForm()
        {
            InitializeComponent();
        }
        public void LoadData() {
            Database database = Database.GetInstance();
            
            Database database2 = Database.GetInstance();
            int x1 = database.GetHashCode();
            int x2 = database2.GetHashCode();
            List<Department> departments = database.getDepartments();
            Console.WriteLine("hah");
        }
        private void dataGridViewEmployees_CellContentClick(object sender, DataGridViewCellEventArgs e)
        {

        }
    }
}
