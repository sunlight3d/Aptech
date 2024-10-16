using ExamApp.models;
using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Data;
using System.Drawing;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Windows;
using System.Windows.Forms;
using MessageBox = System.Windows.Forms.MessageBox;

namespace ExamApp
{
    public partial class EmployeeProfilesForm : Form
    {
        private Department department = null;
        public EmployeeProfilesForm()
        {
            InitializeComponent();
            dataGridViewEmployees.SelectionChanged += DataGridViewEmployees_SelectionChanged;
            dataGridViewEmployees.SelectionMode = DataGridViewSelectionMode.FullRowSelect;
        }

        private void DataGridViewEmployees_SelectionChanged(object sender, EventArgs e)
        {
            var rowsCount = dataGridViewEmployees.SelectedRows.Count;
            if (rowsCount == 0 || rowsCount > 1) return;
            selectedEmployee = (Employee)(dataGridViewEmployees.SelectedRows[0].DataBoundItem);
            Console.WriteLine("haha");
        }

        private EmployeeDetailForm employeeDetailForm = null;
        private Employee selectedEmployee = null;
        public void LoadData() {                        
            List<Department> departments = Database.GetInstance().getDepartments();
            treeViewDepartment.BeginUpdate();
            treeViewDepartment.NodeMouseClick += TreeViewDepartment_NodeMouseClick;
            treeViewDepartment.Nodes.Clear();
            treeViewDepartment.Nodes.Add("Department");
            for(int i = 0; i < departments.Count; i++)
            {
                Department department = departments[i];
                treeViewDepartment.Nodes[0].Nodes.Add(department.DepartmentName);
                treeViewDepartment.Nodes[0].Nodes[i].Tag = department;
            }            
            treeViewDepartment.EndUpdate();
            
        }

        private void TreeViewDepartment_NodeMouseClick(object sender, TreeNodeMouseClickEventArgs e)
        {
            department = (Department)e.Node.Tag;            
            RefreshDataGridView();
            Console.WriteLine("haha");
        }
        private void RefreshDataGridView()
        {
            if (department == null) return;
            List<Employee> employees = Database.GetInstance().getEmployees(department.DepartmentId);
            //fill data to DataGridView ?
            dataGridViewEmployees.DataSource = employees;
        }
        private void dataGridViewEmployees_CellContentClick(object sender, DataGridViewCellEventArgs e)
        {

        }

        private void treeViewDepartment_AfterSelect(object sender, TreeViewEventArgs e)
        {

        }

        private void buttonInsert_Click(object sender, EventArgs e)
        {
            employeeDetailForm = employeeDetailForm == null ?
                                    new EmployeeDetailForm() :
                                    employeeDetailForm;
            employeeDetailForm.Department = department;
            employeeDetailForm.Employee = new Employee() { 
                EmployeeName = "",
                Address = "",
                BirthDate = new DateTime(),                
                DepartmentID = this.department.DepartmentId,
            };
            
            employeeDetailForm.Show();
        }

        private void buttonDelete_Click(object sender, EventArgs e)
        {
            /*
            employeeDetailForm = employeeDetailForm == null ?
                                    new EmployeeDetailForm() :
                                    employeeDetailForm;
            employeeDetailForm.Employee = selectedEmployee;
            employeeDetailForm.Show();
            */
            if(selectedEmployee == null)
            {
                MessageBox.Show("You must select an employee first");
                return;
            }
            var confirmResult = MessageBox.Show("Are you sure to delete this item ??",
                                     "Confirm Delete!!",
                                     MessageBoxButtons.YesNo);

            if (confirmResult == DialogResult.Yes)
            {
                Database.GetInstance().DeleteEmployee(selectedEmployee.EmployeeID);
                RefreshDataGridView();
            }
            
        }

        private void buttonClose_Click(object sender, EventArgs e)
        {
            this.Close();
        }
    }
}
