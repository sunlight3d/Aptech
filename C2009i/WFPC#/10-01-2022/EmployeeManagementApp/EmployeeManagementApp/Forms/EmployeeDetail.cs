using EmployeeManagementApp.Models;
using EmployeeManagementApp.Repositories;
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
    public partial class EmployeeDetail : Form
    {
        private DepartmentRepository departmentRepository = new DepartmentRepository();
        private Department selectedDepartment;
        public EmployeeDetail()
        {
            InitializeComponent();
            comboBoxDepartment.SelectedIndexChanged += ComboBoxDepartment_SelectedIndexChanged;
            //load list of department
            comboBoxDepartment.DataSource = departmentRepository.GetAllDepartments();
            comboBoxDepartment.DisplayMember = "DeparmentName";
        }

        private void ComboBoxDepartment_SelectedIndexChanged(object sender, EventArgs e)
        {
            selectedDepartment = (Department)comboBoxDepartment.SelectedItem;
        }

        private void comboBox1_SelectedIndexChanged(object sender, EventArgs e)
        {

        }

        private void buttonAddNew_Click(object sender, EventArgs e)
        {

        }

        private void buttonCancel_Click(object sender, EventArgs e)
        {
            this.Close();
        }
    }
}
