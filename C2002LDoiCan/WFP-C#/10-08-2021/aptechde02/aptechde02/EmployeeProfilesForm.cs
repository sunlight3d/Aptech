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
    public partial class EmployeeProfilesForm : Form
    {
        private EmployeeDetailForm employeeDetailForm;
        private List<tblDepartment> departments = new List<tblDepartment>();
        private int departmentId;
        public EmployeeProfilesForm()
        {
            InitializeComponent();
            SetUpListViewEmployees();                        
            using (MyDBContextEntities myDBContext = new MyDBContextEntities())
            {
                departments =  myDBContext.tblDepartments.ToList();               
                treeViewDepartment.Nodes.Clear();
                foreach (var department in departments) {
                    TreeNode treeNode = new TreeNode();
                    treeViewDepartment.AfterSelect += treeView1_NodeMouseClick;
                    
                    treeNode.Text = department.DepartmentName;
                    treeNode.Tag = department.DepartmentId;
                    treeViewDepartment.Nodes.Add(treeNode);                    
                }

            }
            
        }
        private void SetUpListViewEmployees() {
            listViewEmployees.View = View.Details;
            // Allow the user to edit item text.
            listViewEmployees.LabelEdit = true;
            // Allow the user to rearrange columns.
            listViewEmployees.AllowColumnReorder = true;
            // Display check boxes.
            listViewEmployees.CheckBoxes = false;
            // Select the item and subitems when selection is made.
            listViewEmployees.FullRowSelect = true;
            // Display grid lines.
            listViewEmployees.GridLines = true;
            // Sort the items in the list in ascending order.
            listViewEmployees.Sorting = SortOrder.Ascending;
            listViewEmployees.MultiSelect = false;

            listViewEmployees.Columns.Add("EmployeeID", -2, HorizontalAlignment.Left);
            listViewEmployees.Columns.Add("EmployeeName", -2, HorizontalAlignment.Left);
            listViewEmployees.Columns.Add("DepartmentName", -2, HorizontalAlignment.Left);
            listViewEmployees.Columns.Add("Gender", -2, HorizontalAlignment.Left);
            listViewEmployees.Columns.Add("BirthDate", -2, HorizontalAlignment.Left);
            listViewEmployees.Columns.Add("Telephone", -2, HorizontalAlignment.Left);
            listViewEmployees.Columns.Add("Address", -2, HorizontalAlignment.Left);            
        }
        private void treeView1_NodeMouseClick(object sender, EventArgs e)
        {
            TreeNode treeNode = treeViewDepartment.SelectedNode;
            departmentId = (int)treeNode.Tag;
            listViewEmployees.Items.Clear();
            //query employees by departmentId
            reloadListView();
                            
        }
        private void reloadListView() {
            using (MyDBContextEntities myDBContext = new MyDBContextEntities())
            {
                List<tblEmployee> employees = myDBContext.tblEmployees
                    .Where(employee => employee.DepartmentId == departmentId).ToList();
                List<ListViewItem> listViewItems = new List<ListViewItem>();
                foreach (var employee in employees)
                {
                    ListViewItem item = new ListViewItem($"{employee.EmployeeId}", 0);
                    item.Tag = employee;
                    item.SubItems.Add(new ListViewItem.ListViewSubItem(item,
                                        employee.EmployeeName));
                    item.SubItems.Add(new ListViewItem.ListViewSubItem(item,
                                        myDBContext.tblDepartments
                            .Where(department => department.DepartmentId == employee.DepartmentId)
                            .FirstOrDefault().DepartmentName));

                    item.SubItems.Add(new ListViewItem.ListViewSubItem(item,
                                       employee.Gender == true ? "true" : "false"));

                    item.SubItems.Add(new ListViewItem.ListViewSubItem(item,
                                       employee.BirthDate.ToString()));

                    item.SubItems.Add(new ListViewItem.ListViewSubItem(item,
                                       employee.Telephone));
                    item.SubItems.Add(new ListViewItem.ListViewSubItem(item,
                                       employee.Address));
                    listViewItems.Add(item);
                }
                //Add the items to the ListView.
                listViewEmployees.Items.Clear();
                listViewEmployees.Items.AddRange(listViewItems.ToArray());
            }
        }
        private void btnInsert_Click(object sender, EventArgs e)
        {
            employeeDetailForm = employeeDetailForm is null ? new EmployeeDetailForm() :
                                     employeeDetailForm;
            employeeDetailForm.MdiParent = this.MdiParent;
            employeeDetailForm.Show();
        }

        private void btnDelete_Click(object sender, EventArgs e)
        {
            if (listViewEmployees.SelectedItems.Count > 0)
            {
                ListViewItem selectedItem = listViewEmployees.SelectedItems[0];
                tblEmployee selectedEmployee = (tblEmployee)selectedItem.Tag;
                var confirmResult = MessageBox.Show($"Are you sure to delete employee: {selectedEmployee.EmployeeName}",
                                     "Confirm Delete!!",
                                     MessageBoxButtons.YesNo);
                if (confirmResult == DialogResult.Yes)
                {
                    using (MyDBContextEntities myDBContext = new MyDBContextEntities()) {
                        myDBContext.tblEmployees
                            .RemoveRange(myDBContext.tblEmployees
                            .Where(employee => employee.EmployeeId == selectedEmployee.EmployeeId));
                        myDBContext.SaveChanges();
                        reloadListView();
                    }                    
                }

            }
        }
    }
}
