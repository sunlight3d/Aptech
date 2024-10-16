using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Data;
using System.Drawing;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Windows.Forms;

namespace WindowsFormsApp1
{
    public partial class StudentsForm : Form
    {
        private LoginForm loginForm;
        public StudentsForm(LoginForm loginForm):base()
        {
            InitializeComponent();
            this.loginForm = loginForm;
            this.loginForm.Hide();
        }
        protected override void OnClosing(System.ComponentModel.CancelEventArgs e) {
            this.loginForm?.Show();
        }

        private void label1_Click(object sender, EventArgs e)
        {

        }
    }
}
