using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Data;
using System.Drawing;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Windows.Forms;
using System.Collections;

namespace AptechWFC
{
    public partial class MainScreen : Form
    {
        private Dictionary<String, Object> someParams 
            = new Dictionary<String, Object>();
        private SecondScreen secondScreen;
        public MainScreen()
        {
            InitializeComponent();
            someParams.Add("name", "Hoang");
            someParams.Add("age", 18);            
            this.AutoScaleMode = AutoScaleMode.Dpi;
        }

        private void btnAddName_Click(object sender, EventArgs e)
        {            
            if (!string.IsNullOrWhiteSpace(txtSearch.Text)                
                && !listBoxNames.Items.Contains(txtSearch.Text)) {
                string searchString = txtSearch.Text;
                listBoxNames.Items.Add(searchString);
                //MessageBox.Show($"searchString : {searchString}");
                txtSearch.Text = "";
            }
                
        }

        private void btnShowSecondScreen_Click(object sender, EventArgs e)
        {
            secondScreen = new SecondScreen();
            secondScreen.SomeParams = this.someParams;
            secondScreen.MainScreen = this;
            this.Hide();
            secondScreen.Show();
        }
    }
}
