using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Data;
using System.Drawing;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Windows.Forms;

namespace de03
{
    public partial class MainForm : Form
    {
        private EmployeeProfile employeeProfile;
        public MainForm()
        {
            InitializeComponent();
        }

        private void exitToolStripMenuItem_Click(object sender, EventArgs e)
        {
            Application.Exit();
        }

        private void employeeProfileToolStripMenuItem_Click(object sender, EventArgs e)
        {
            employeeProfile = employeeProfile ?? new EmployeeProfile();  
            employeeProfile.MdiParent = this;            
            employeeProfile.Show();
        }
    }
}
