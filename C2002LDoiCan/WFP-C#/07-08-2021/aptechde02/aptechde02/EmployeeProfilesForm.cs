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
            listViewEmployees.Columns.Add("EmployeeID", 10);
            listViewEmployees.Columns.Add("EmployeeName", 10);
            listViewEmployees.Columns.Add("Department", 10);
            listViewEmployees.Columns.Add("Gender", 10);
            listViewEmployees.Columns.Add("BirthDate", 10);
            listViewEmployees.Columns.Add("Telephone", 10);
            listViewEmployees.Columns.Add("Address", 10);
        }
        private void treeView1_NodeMouseClick(object sender, EventArgs e)
        {
            TreeNode treeNode = treeViewDepartment.SelectedNode;
            int departmentId = (int)treeNode.Tag;
            listViewEmployees.Items.Clear();
            //query employees by departmentId
            using (MyDBContextEntities myDBContext = new MyDBContextEntities())
            {
                List<tblEmployee> employees = myDBContext.tblEmployees
                    .Where(employee => employee.DepartmentId == departmentId).ToList();
                foreach (var employee in employees) {
                    ListViewItem item = new ListViewItem();
                    item.Text = $"{employee.DepartmentId}";                                      
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
                    listViewEmployees.Items.Add(item);
                }
                
            }
                            
        }
        private void btnInsert_Click(object sender, EventArgs e)
        {
            employeeDetailForm = employeeDetailForm is null ? new EmployeeDetailForm() :
                                     employeeDetailForm;
            employeeDetailForm.MdiParent = this.MdiParent;
            employeeDetailForm.Show();
        }
    }
}
