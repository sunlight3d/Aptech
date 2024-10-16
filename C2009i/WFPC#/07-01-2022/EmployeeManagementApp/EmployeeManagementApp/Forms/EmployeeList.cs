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
    public partial class EmployeeList : Form
    {
        private Department selectedDepartment;
        private DepartmentRepository departmentRepository = new DepartmentRepository();
        public EmployeeList()
        {
            InitializeComponent();
            SetupTreeView();
            dataGridView.RowHeadersVisible = false;
        }
        private void SetupTreeView() {
            //treeview with fake data
            treeView.Nodes.Clear();
            List<Department> departments = departmentRepository.GetAllDepartments();             
            foreach (Department department in departments) {
                TreeNode treeNode = new TreeNode(department.DeparmentName);
                treeNode.Tag = department;
                treeView.Nodes.Add(treeNode);
            }            
        }
        private void buttonClose_Click(object sender, EventArgs e)
        {
            this.Close();
        }

        private void treeView_AfterSelect(object sender, TreeViewEventArgs e)
        {
            selectedDepartment = (Department)treeView.SelectedNode.Tag;
            //MessageBox.Show(selectedDepartment.DeparmentName);
            ReloadDataGridView();
        }
        private void ReloadDataGridView() {
            if (selectedDepartment != null) {
                dataGridView.AutoGenerateColumns = true;
                dataGridView.DataSource = departmentRepository
                    .getEmployees(selectedDepartment.DeparmentId).Tables[0];
            }
        }
    }
}
