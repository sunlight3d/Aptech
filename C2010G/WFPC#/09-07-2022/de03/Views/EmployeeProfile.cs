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
    public partial class EmployeeProfile : Form
    {
        private ExamWinFormEntities db = new ExamWinFormEntities();
        private Department selectedDepartment;//backing store
        private Employee selectedEmployee;
        private EmployeeDetail employeeDetail;
        public Department SelectedDeparment {
            get => selectedDepartment ?? db.Departments.FirstOrDefault();
            set {
                selectedDepartment = value;
            }
        }
        public EmployeeProfile()
        {
            InitializeComponent();
            listView.FullRowSelect = true;
            listView.AllowColumnReorder = true;
            listView.GridLines = true;
            listView.Sorting = SortOrder.Ascending;
            InitializeTreeView();
            FetchDataToListView();
        }
        private void FetchDataToListView() {
            listView.Items.Clear();
            listView.View = View.Details;
            listView.Columns.Add("EmployeeID", -2);//-2 = auto size
            listView.Columns.Add("EmployeeName", -2);
            listView.Columns.Add("Department", -2);
            listView.Columns.Add("Gender", -2);
            listView.Columns.Add("BirthDate", -2);
            listView.Columns.Add("Tel", -2);
            listView.Columns.Add("Address", -2);            
            List<Employee> employees = this.db.Employees
                .Where(employee => employee.DeptID == SelectedDeparment.DeptID)
                .ToList();
            foreach (Employee employee in employees) 
            {
                ListViewItem listViewItem = new ListViewItem(new string[] {
                        $"{employee.EmployeeID}",
                        employee.EmployeeName,
                        SelectedDeparment.DeptName,
                        $"{employee.Gender}",
                        $"{employee.BirthDate}",
                        $"{employee.Tel}",
                        employee.Address
                    });
                listViewItem.Tag = employee;
                listView.Items.Add(listViewItem);
            }
            listView.MouseClick += ListView_MouseClick;
        }

        private void ListView_MouseClick(object sender, MouseEventArgs e)
        {
            if (listView.SelectedItems.Count == 0)
            {
                return;
            }
            ListViewItem listViewItem = listView.SelectedItems[0];
            selectedEmployee = (Employee)listViewItem.Tag;
                                                
        }

        private void InitializeTreeView()
        {            
            treeView.BeginUpdate();
            int i = 0;
            treeView.NodeMouseClick += TreeView_NodeMouseClick;

            foreach(Department department in db.Departments.ToList()){
                String departmentName = department.DeptName;
                treeView.Nodes.Add(departmentName);
                treeView.Nodes[i].Tag = department;
                i++;
            }
            
            treeView.EndUpdate();            
        }

        private void TreeView_NodeMouseClick(object sender, TreeNodeMouseClickEventArgs e)
        {
            SelectedDeparment = (Department)e.Node.Tag;
            FetchDataToListView();
        }

        private void btnClose_Click(object sender, EventArgs e)
        {
            this.Close();
        }

        private void listView_SelectedIndexChanged(object sender, EventArgs e)
        {

        }

        private void treeView_AfterSelect(object sender, TreeViewEventArgs e)
        {

        }

        private void btnDelete_Click(object sender, EventArgs e)
        {
            var confirmResult = MessageBox.Show("Are you sure to delete this item ??",
                                     "Confirm Delete!!",
                                     MessageBoxButtons.YesNo);
            if (confirmResult == DialogResult.Yes && selectedEmployee != null)
            {
                this.db.Employees.Remove(selectedEmployee);
                this.db.SaveChanges();
                FetchDataToListView();
            }
        }

        private void btnInsert_Click(object sender, EventArgs e)
        {
            employeeDetail = employeeDetail ?? new EmployeeDetail();//nil-coalescing
            employeeDetail.EmployeeProfile = this;
            employeeDetail.Show();
        }
    }
}
