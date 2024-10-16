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
        private EmployeeRepository employeeRepository = new EmployeeRepository();
        private Department selectedDepartment;
        private Employee employee = new Employee();
        public EmployeeDetail()
        {
            InitializeComponent();
            comboBoxDepartment.SelectedIndexChanged += ComboBoxDepartment_SelectedIndexChanged;
            //load list of department
            comboBoxDepartment.DataSource = departmentRepository.GetAllDepartments();
            comboBoxDepartment.DisplayMember = "DeparmentName";
            textBoxEmployeeName.TextChanged += TextBoxEmployeeName_TextChanged;
            textBoxTelephone.TextChanged += TextBoxTelephone_TextChanged;
            labelEmployeeNameError.Text = "";
            labelTelError.Text = "";
            labelBirthdateError.Text = "";
            dateTimePicker1.ValueChanged += DateTimePicker1_ValueChanged;
            radioButtonMale.Checked = true;
        }

        private void DateTimePicker1_ValueChanged(object sender, EventArgs e)
        {
            DateTime birthDate = dateTimePicker1.Value;
            labelBirthdateError.Text = birthDate.Year > 1999 ? "Year must be <= 1999" : "";
            employee.BirthDate = dateTimePicker1.Value == null
                                    ? DateTime.Now : dateTimePicker1.Value;
        }

        private void TextBoxTelephone_TextChanged(object sender, EventArgs e)
        {
            Console.WriteLine(textBoxTelephone.Text);
            labelTelError.Text = textBoxTelephone.Text.Length <= 6 
                    || !textBoxTelephone.Text[0].ToString().Equals("0")?
                "Tel length must be > 6 characters, first char is 0" : "";
            employee.Telephone = textBoxTelephone.Text ?? "";
        }

        private void TextBoxEmployeeName_TextChanged(object sender, EventArgs e)
        {
            //text observe
            Console.WriteLine(textBoxEmployeeName.Text);
            labelEmployeeNameError.Text = textBoxEmployeeName.Text.Length <= 5 ?
                "Employee length must be > 5 characters" : "";
            employee.EmployeeName = textBoxEmployeeName.Text;

        }

        private void ComboBoxDepartment_SelectedIndexChanged(object sender, EventArgs e)
        {
            selectedDepartment = (Department)comboBoxDepartment.SelectedItem;
        }

        private void comboBox1_SelectedIndexChanged(object sender, EventArgs e)
        {

        }
        private bool isValidationSucess() =>
            employee.EmployeeName.Length > 5
                && employee.BirthDate.Year <= 1999
                && employee.Telephone.Length > 6
                && employee.Telephone.Trim()[0].ToString().Equals("0") 
                && employee.DeparmentId != null
            ;
        private void buttonAddNew_Click(object sender, EventArgs e)
        {                                    
            employee.DeparmentId = selectedDepartment.DeparmentId;
            employee.Gender = radioButtonMale.Checked == true;                        
            employee.Address = textBoxAddress.Text ?? "";
            if (isValidationSucess() == true) {
                employeeRepository.InsertEmployee(employee);
                this.Hide();
                this.Dispose();
            } else 
            {
                MessageBox.Show("validation error");
            }
            
        }

        private void buttonCancel_Click(object sender, EventArgs e)
        {
            this.Close();
        }

        private void label8_Click(object sender, EventArgs e)
        {

        }
    }
}
