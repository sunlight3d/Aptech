using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Data;
using System.Drawing;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Windows.Forms;

namespace myapp
{
    public partial class LoginForm : Form
    {
        public MainForm MainForm { get; set; }
        public LoginForm()
        {
            InitializeComponent();//nam o partial class khac
            txtUserName.Text = "nguyenvana";
            txtPassword.Text = "123456";
            txtPassword.PasswordChar = '*';

        }

        private void label2_Click(object sender, EventArgs e)
        {

        }

        private void btnLogin_Click(object sender, EventArgs e)
        {
            String userName = txtUserName.Text ?? "";
            String password = txtPassword.Text;
            if (userName.Trim().Length == 0) {
                MessageBox.Show("Username must not be blank!");
                return;                    
            }
            if (password.Length < 3)
            {
                MessageBox.Show("Password's length must be less than 3 characters");
                return;
            }            
            if (Database.GetInstance().login(userName, password) == true)
            {
                MainForm = MainForm == null ? new MainForm()
                {
                    LoginForm = this
                } : MainForm;

                MainForm.Show();
            }
            else {
                MessageBox.Show(@"Cannot login to your account");
            }

            
            //this.Hide();
        }

        private void btnExit_Click(object sender, EventArgs e)
        {
            Application.Exit();
        }
    }
}
