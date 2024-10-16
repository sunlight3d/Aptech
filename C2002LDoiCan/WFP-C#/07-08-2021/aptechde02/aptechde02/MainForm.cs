using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Data;
using System.Drawing;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Windows.Forms;

namespace aptechde02
{
    public partial class MainForm : Form
    {
        private EmployeeProfilesForm employeeProfilesForm;
        public MainForm()
        {
            InitializeComponent();
        }

        private void MainForm_Load(object sender, EventArgs e)
        {

        }

        private void exitToolStripMenuItem_Click(object sender, EventArgs e)
        {
            Application.Exit();
        }

        private void btnInsert_Click(object sender, EventArgs e)
        {
            
        }

        private void employeeProfilesToolStripMenuItem_Click(object sender, EventArgs e)
        {
            employeeProfilesForm = employeeProfilesForm == null ? new EmployeeProfilesForm():
                                    employeeProfilesForm;
            employeeProfilesForm.MdiParent = this;
            employeeProfilesForm.Show();
        }
    }
}
