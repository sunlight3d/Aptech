using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Data;
using System.Drawing;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Windows.Forms;

namespace MyApp
{
    public partial class MainForm : Form
    {
        //Business
        public MainForm()
        {
            InitializeComponent();
        }

        private void buttonSave_Click(object sender, EventArgs e)
        {
            labelInfo.Text = "you press Save";
        }

        private void buttonExit_Click(object sender, EventArgs e)
        {
            labelInfo.Text = "you press Exit";
        }
    }
}
