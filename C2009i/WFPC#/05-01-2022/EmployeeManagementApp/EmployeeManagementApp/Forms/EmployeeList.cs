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
        public EmployeeList()
        {
            InitializeComponent();
            SetupTreeView();
        }
        private void SetupTreeView() {
            //treeview with fake data
            treeView.Nodes.Clear();
            treeView.Nodes.Add(new TreeNode("IT"));
            treeView.Nodes.Add(new TreeNode("Sales"));
            treeView.Nodes.Add(new TreeNode("Marketing"));
            treeView.Nodes.Add(new TreeNode("Training"));
        }
        private void buttonClose_Click(object sender, EventArgs e)
        {
            this.Close();
        }

        private void treeView_AfterSelect(object sender, TreeViewEventArgs e)
        {
            MessageBox.Show(treeView.SelectedNode.Text);
        }
    }
}
