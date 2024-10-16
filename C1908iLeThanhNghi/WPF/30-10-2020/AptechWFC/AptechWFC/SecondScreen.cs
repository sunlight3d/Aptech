using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Data;
using System.Drawing;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Windows.Forms;

namespace AptechWFC
{
    public partial class SecondScreen : Form
    {
        private Dictionary<String, Object> someParams;
        public Dictionary<String, Object> SomeParams { get {
                return someParams;
            }
            set {
                someParams = value;
                this.labelTitle.Text =
                $"name = {someParams["name"]}, age = {someParams["age"]}";
                
            } 
        }
        public MainScreen MainScreen { get; set; }

        public SecondScreen()
        {
            InitializeComponent();
            this.AutoScaleMode = AutoScaleMode.Dpi;
            
            //Update data from MainScreen
            //Update UI in setter
        }
        
        private void SecondScreen_Load(object sender, EventArgs e)
        {

        }

        private void labelTitle_Click(object sender, EventArgs e)
        {

        }

        private void SecondScreen_FormClosing(object sender, FormClosingEventArgs e)
        {
            this.MainScreen.Show();
        }
    }
}
