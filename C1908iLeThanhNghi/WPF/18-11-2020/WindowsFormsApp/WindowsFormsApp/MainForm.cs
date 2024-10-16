using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Data;
using System.Drawing;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Windows.Forms;
using WindowsFormsApp.Models;

namespace WindowsFormsApp
{
    public partial class MainForm : Form
    {
        public MainForm()
        {
            this.AutoSize = true;
            InitializeComponent();
            
        }
        
        private void exitToolStripMenuItem_Click(object sender, EventArgs e)
        {
            Application.Exit();
        }

        private void textBox1_TextChanged(object sender, EventArgs e)
        {

        }
        private void PopulateDataToTreeView() {
            List<Department> departments = Database.GetInstance().GetAllDepartments();
            foreach (var department in departments) {
                treeViewDepartments.Nodes.Add(department.DepartmentName);
            }
            treeViewDepartments.NodeMouseClick += new TreeNodeMouseClickEventHandler(treeView_NodeMouseClick);
            
        }
        void treeView_NodeMouseClick(object sender, TreeNodeMouseClickEventArgs e)
        {
            Console.WriteLine("Clicked: " + e.Node.Text);
        }
        private void MainForm_Load(object sender, EventArgs e)
        {
            
            PopulateDataToTreeView();
                       
        }
    }
}
