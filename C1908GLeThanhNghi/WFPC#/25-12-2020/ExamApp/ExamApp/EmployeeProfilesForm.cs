using ExamApp.models;
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
    public partial class EmployeeProfilesForm : Form
    {
        public EmployeeProfilesForm()
        {
            InitializeComponent();
        }
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
            Department department = (Department)e.Node.Tag;
            if(department == null)
            {
                return;
            }
            List<Employee> employees = Database.GetInstance().getEmployees(department.DepartmentId);
            //fill data to DataGridView ?
            dataGridViewEmployees.DataSource = employees;

            Console.WriteLine("haha");
        }

        private void dataGridViewEmployees_CellContentClick(object sender, DataGridViewCellEventArgs e)
        {

        }

        private void treeViewDepartment_AfterSelect(object sender, TreeViewEventArgs e)
        {

        }
    }
}
