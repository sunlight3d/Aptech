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
        private EmployeeRepository employeeRepository = new EmployeeRepository();
        private EmployeeDetail employeeDetail = new EmployeeDetail();
        private ListViewItem selectedListViewItem;
        public EmployeeList()
        {
            InitializeComponent();
            SetupTreeView();
            listView.MultiSelect = false;            
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
            ReloadListView();
        }
        private void ReloadListView() {
            if (selectedDepartment != null) {
                List<Dictionary<string, string>> dictionaries = departmentRepository
                    .getEmployees(selectedDepartment.DeparmentId);
                //fill data to ListView                
                //listView.Columns.Clear();
                listView.Items.Clear();
                listView.View = View.Details;
                listView.Columns.Add("EmployeeID", -2);
                listView.Columns.Add("EmployeeName", -2);
                listView.Columns.Add("Department", -2);
                listView.Columns.Add("Gender", -2);
                listView.Columns.Add("BirthDate", -2);
                listView.Columns.Add("Tel", -2);
                listView.Columns.Add("Address", -2);
                
                foreach (Dictionary<string, string> dictionary in dictionaries) {
                    ListViewItem listViewItem = new ListViewItem(new string[] {
                        dictionary["EmployeeID"],
                        dictionary["EmployeeName"],
                        dictionary["Department"],
                        dictionary["Gender"],
                        dictionary["BirthDate"],
                        dictionary["Tel"],
                        dictionary["Address"],
                    });
                    listViewItem.Tag = dictionary;
                    listView.Items.Add(listViewItem);                                        
                }
            }
        }

        private void buttonDelete_Click(object sender, EventArgs e)
        {
            if (listView.SelectedItems.Count > 0)
            {
                selectedListViewItem = listView.SelectedItems[0];
                Dictionary<string, string> dictionary 
                    = (Dictionary<string, string>)selectedListViewItem.Tag;
                int employeeId = Convert.ToInt32(dictionary["EmployeeID"]);
                DialogResult dialogResult = MessageBox.Show(
                    "Do you want to delete this ?", "Delete", MessageBoxButtons.YesNoCancel,
                        MessageBoxIcon.Information);
                if (dialogResult == DialogResult.Yes)
                {
                    employeeRepository.DeleteEmployeeById(employeeId);
                    ReloadListView();
                }
            }
            else {
                MessageBox.Show("You must select 1 item to delete");
            }
            
        }

        private void buttonInsert_Click(object sender, EventArgs e)
        {
            if (employeeDetail.IsDisposed == true || employeeDetail == null) {
                employeeDetail = new EmployeeDetail();
            }            
            //employeeDetail.IsMdiContainer = false;            
            employeeDetail.MdiParent = this.MdiParent;
            
            //this.Parent = null;
            employeeDetail.Show();
        }
    }
}
