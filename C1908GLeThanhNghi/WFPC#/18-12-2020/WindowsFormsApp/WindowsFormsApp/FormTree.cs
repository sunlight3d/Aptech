using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Data;
using System.Drawing;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Windows.Forms;

namespace WindowsFormsApp
{
    public partial class FormTree : Form
    {
       public FormTree()
        {
            InitializeComponent();
            treeView.BeginUpdate();
            treeView.Nodes.Add("Parent");
            treeView.Nodes[0].Nodes.Add("Child 1");
            treeView.Nodes[0].Nodes.Add("Child 2");
            treeView.Nodes[0].Nodes[1].Nodes.Add("Grandchild");
            treeView.Nodes[0].Nodes[1].Nodes[0].Nodes.Add("Great Grandchild");
            treeView.EndUpdate();
        }
    }
}
