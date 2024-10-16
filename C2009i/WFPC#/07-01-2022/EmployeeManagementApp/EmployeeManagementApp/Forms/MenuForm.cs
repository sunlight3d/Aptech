using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Data;
using System.Drawing;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Windows.Forms;

namespace EmployeeManagementApp.Forms
{
    public partial class MenuForm : Form
    {
        private EmployeeList employeeList = new EmployeeList();
        public MenuForm()
        {
            InitializeComponent();
            this.IsMdiContainer = true;            
            employeeList.MdiParent = this;
            this.AutoSize = true;
            ShowEmployeeListForm();
        }
        private void ShowEmployeeListForm() {
            if (employeeList.IsDisposed || employeeList == null) {
                employeeList = new EmployeeList();
            }
            employeeList.MdiParent = this;
            employeeList.Show();
        }
        private void fileToolStripMenuItem_Click(object sender, EventArgs e)
        {

        }

        private void exitToolStripMenuItem_Click(object sender, EventArgs e)
        {
            Application.Exit();
        }

        private void MenuForm_Load(object sender, EventArgs e)
        {

        }

        private void emmployeeProfilesToolStripMenuItem_Click(object sender, EventArgs e)
        {
            ShowEmployeeListForm();
        }
    }
}
