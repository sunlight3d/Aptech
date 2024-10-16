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
    public partial class EmployeeDetailForm : Form
    {
        private List<tblDepartment> departments = new List<tblDepartment>();
        public EmployeeDetailForm()
        {
            InitializeComponent();
            using (MyDBContextEntities myDBContext = new MyDBContextEntities())
            {
                departments = myDBContext.tblDepartments.ToList();
                List<String> departmentNames = new List<string>();
                comboBoxDepartment.Items.Clear();
                /*
                foreach (var department in departments)
                {
                    departmentNames.Add(department.DepartmentName);
                }                
                comboBoxDepartment.Items.AddRange(departmentNames.ToArray());
                comboBoxDepartment.SelectedItem = departmentNames.Count > 0 ? departmentNames[0] : null;
                */
                comboBoxDepartment.DataSource = departments;
                comboBoxDepartment.DisplayMember = "DepartmentName";
                comboBoxDepartment.SelectedItem = departments.Count > 0 ? departments[0] : null;
            }

        }

        private void btnAddNew_Click(object sender, EventArgs e)
        {
            //validations
            if (comboBoxDepartment.SelectedItem == null)
            {
                MessageBox.Show("You must choose department");
                return;
            }
            if (txtEmpployeeName.Text.Trim().Length <= 5) {
                MessageBox.Show("Employee's name must have length >5");
                return;
            }
            if (dateTimePickerBirthDate.Value.Year > 1999 || dateTimePickerBirthDate.Value.Year <= 0)
            {
                MessageBox.Show("Birthdate must be <= 1999");
                return;
            }
            if (txtTelephone.Text.Trim().Length <= 6 || !txtTelephone.Text.Trim()[0].Equals('0'))
            {
                MessageBox.Show("Phone must start with 0 and lenght >= 6");
                return;
            }
            if (!radioButtonMale.Checked && !radioButtonFemale.Checked)
            {
                MessageBox.Show("You must select Gender");
                return;
            }
            int departmentId = ((tblDepartment)comboBoxDepartment.SelectedItem).DepartmentId;
            String employeeName = txtEmpployeeName.Text.Trim();
            DateTime birtDate = dateTimePickerBirthDate.Value;
            String telephone = txtTelephone.Text.Trim();
            bool gender = radioButtonMale.Checked;
            String address = txtAddress.Text;            
            using (MyDBContextEntities myDBContext = new MyDBContextEntities())
            {
                tblEmployee newEmployee = new tblEmployee()
                {
                    DepartmentId = departmentId,
                    EmployeeName = employeeName,
                    BirthDate = birtDate,
                    Telephone = telephone,
                    Gender = gender,
                    Address = address
                };
                myDBContext.tblEmployees.Add(newEmployee);
                myDBContext.SaveChanges();
            }

        }

        private void btnCancel_Click(object sender, EventArgs e)
        {
            this.Close();
        }
    }
}
