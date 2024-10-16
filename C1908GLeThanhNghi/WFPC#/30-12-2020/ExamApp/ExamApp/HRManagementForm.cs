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
    public partial class HRManagementForm : Form
    {
        private EmployeeProfilesForm employeeProfilesForm = null;
        public HRManagementForm()
        {
            InitializeComponent();
        }

        private void exitToolStripMenuItem_Click(object sender, EventArgs e)
        {
            Application.Exit();
        }

        private void employeeProfileToolStripMenuItem_Click(object sender, EventArgs e)
        {
            employeeProfilesForm = employeeProfilesForm == null ? 
                                    new EmployeeProfilesForm():
                                    employeeProfilesForm;
            employeeProfilesForm.MdiParent = this;
            this.AutoScaleMode = AutoScaleMode.Inherit;
            employeeProfilesForm.LoadData();
            employeeProfilesForm.Show();
        }

        private void HRManagementForm_Load(object sender, EventArgs e)
        {

        }
    }
}
