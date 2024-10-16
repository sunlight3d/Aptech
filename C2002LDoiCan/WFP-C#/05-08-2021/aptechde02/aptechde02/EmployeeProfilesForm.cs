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
    public partial class EmployeeProfilesForm : Form
    {
        private EmployeeDetailForm employeeDetailForm;
        public EmployeeProfilesForm()
        {
            InitializeComponent();
        }

        private void btnInsert_Click(object sender, EventArgs e)
        {
            if (employeeDetailForm is null) {
                employeeDetailForm = new EmployeeDetailForm();
                employeeDetailForm.MdiParent = this.MdiParent;
            }                        
            employeeDetailForm.Show();
        }
    }
}
