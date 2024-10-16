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
    public partial class EmployeeDetail : Form
    {
        private ExamWinFormEntities db = new ExamWinFormEntities();
        public EmployeeProfile EmployeeProfile { get; set; }

        public EmployeeDetail()
        {
            InitializeComponent();
            
            comboBoxDepartment.DataSource = db.Departments.ToList();
            comboBoxDepartment.DisplayMember = "DeptName";
        }
        
        private void btnCancel_Click(object sender, EventArgs e)
        {
            this.Close();
        }

        private void btnAddnew_Click(object sender, EventArgs e)
        {
            Console.WriteLine("haha");
            try
            {
                Department department = comboBoxDepartment.SelectedItem as Department;
                if (txtEmployeeName.Text.Trim().Length <= 5)
                {
                    MessageBox.Show("name must be > 5 characters");
                    return;
                }
                if (dateTimePickerBirthDate.Value.Year > 1999)
                {
                    MessageBox.Show("Birthyear must be <=1999");
                    return;
                }
                if (txtTelephone.Text.Trim().Length <= 6)
                {
                    MessageBox.Show("Length must be > 6");
                    return;
                }
                db.Employees.Add(new Employee
                {
                    EmployeeName = txtEmployeeName.Text.Trim(),
                    //Department = comboBoxDepartment.SelectedItem as Department,
                    Gender = radioButtonMale.Checked,
                    BirthDate = dateTimePickerBirthDate.Value,
                    Tel = txtTelephone.Text,
                    Address = txtAddress.Text,
                    DeptID = department.DeptID
                });
                db.SaveChanges();
                this.Close();
            }
            catch (Exception error)
            {
                Console.WriteLine($"Cannot insert employee. Error: {error.ToString()}");
            }
            
        }
    }
}
