using ExamApp.models;
using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Data;
using System.Drawing;
using System.Linq;
using System.Text;
using System.Text.RegularExpressions;
using System.Threading.Tasks;
using System.Windows.Forms;

namespace ExamApp
{
    public partial class EmployeeDetailForm : Form
    {
        private Employee employee;
        private Department selectedDepartment;
        private List<Department> departments;
        public Employee Employee {
            set {
                employee = value;
                //Update UI
                this.textBoxEmployeeName.Text = employee.EmployeeName.Trim();
                if (employee.Gender == 0) {
                    this.radioButtonGenderMale.Checked = false;
                    this.radioButtonGenderFemale.Checked = true;
                } else if (employee.Gender == 1)
                {
                    this.radioButtonGenderMale.Checked = true;
                    this.radioButtonGenderFemale.Checked = false;
                }
                this.textBoxAddress.Text = employee.Address.Trim();
                departments = Database.GetInstance().getDepartments();
                this.comboBoxDepartment.DataSource = departments;
                selectedDepartment = departments
                    .Where(department => department.DepartmentId == selectedDepartment.DepartmentId)
                    .FirstOrDefault();
                comboBoxDepartment.SelectedItem = selectedDepartment;
                comboBoxDepartment.DisplayMember = "DepartmentName";
            }
        }
        public Department Department
         {
            set {
                selectedDepartment = value;
            }
        }
        public EmployeeDetailForm()
        {
            InitializeComponent();
            DateTime today = DateTime.Now;
            dateTimePickerBirthDate.MinDate = today.AddYears(-100);
            dateTimePickerBirthDate.MaxDate = today.AddYears(-18);
        }
        
        private bool ValidateInput()
        {
            if (textBoxEmployeeName.Text.Trim().Length == 0)
            {
                MessageBox.Show("Name must not be null");
                return false;
            }
            if (comboBoxDepartment.SelectedItem == null)
            {
                MessageBox.Show("You must select a department");
                return false;
            }
            if (radioButtonGenderFemale.Checked == false &&
                radioButtonGenderMale.Checked == false)
            {
                MessageBox.Show("You must select Male/Female");
                return false;
            }
            Regex regex = new Regex(@"^0[0-9]{6,}$", RegexOptions.IgnoreCase);
            MatchCollection matches = regex.Matches(textBoxTeplephone.Text.Trim());
            if (matches.Count == 0)
            {
                MessageBox.Show("Tel must >=6 in length, start with \"0\"");
                return false;
            }

            if (dateTimePickerBirthDate.Value == null)
            {
                MessageBox.Show("You must choose birth date");
                return false;
            }
            if(textBoxTeplephone.Text.Trim().Length == 0)
            {
                MessageBox.Show("You must enter telephone");
                return false;
            }
            
            
            return true;            

        }
    
        private void buttonAddNew_Click(object sender, EventArgs e)
        {
            if (!ValidateInput()) {
                return;
            }
            employee.EmployeeName = textBoxEmployeeName.Text.Trim();
            employee.DepartmentID = this.selectedDepartment.DepartmentId;
            employee.Gender = this.radioButtonGenderFemale.Checked == true ? 0 :
                                this.radioButtonGenderMale.Checked == true ? 1 : 0;
            employee.Address = this.textBoxAddress.Text.Trim();
            employee.Telephone = this.textBoxTeplephone.Text.Trim();
            employee.BirthDate = this.dateTimePickerBirthDate.Value;
            int employeeId = Database.GetInstance().InsertEmployee(this.employee);
            MessageBox.Show("Insert data successfully");
            if (employeeId > 0)
            {
                employee.EmployeeID = employeeId;
            }
        }

        private void groupBox1_Enter(object sender, EventArgs e)
        {

        }

        private void textBoxAddress_TextChanged(object sender, EventArgs e)
        {

        }

        private void comboBoxDepartment_SelectedIndexChanged(object sender, EventArgs e)
        {

        }

        private void textBoxTeplephone_TextChanged(object sender, EventArgs e)
        {

        }
    }
}
