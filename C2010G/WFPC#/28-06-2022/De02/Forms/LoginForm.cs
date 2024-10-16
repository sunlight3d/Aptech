using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Data;
using System.Drawing;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Windows.Forms;
using De02.Database;
namespace De02.Forms
{
    public partial class LoginForm : Form
    {
        
        private StudentListForm StudentListForm { get; set; }                
        public LoginForm()
        {
            InitializeComponent();
            this.btnLogin.Click += BtnLogin_Click;
            this.StudentListForm = new StudentListForm();
            txtUsername.Text = "hungnv";
            txtPassword.Text = "123456";
        }
        protected override void Dispose(bool disposing)
        {
            //MessageBox.Show("Dissssppoooo");
            base.Dispose(disposing);

        }
        private void BtnLogin_Click(object sender, EventArgs e)
        {
            String message = $"username: {this.txtUsername.Text}," +
                $" pass: {this.txtPassword.Text}";
            //MessageBox.Show(message);
            String username = txtUsername.Text ?? "";
            String password = txtPassword.Text ?? ""; //nil coelescing / Elvis operator
            bool isValidUsername = username.Trim().Length > 0;
            bool isValidPassword = password.Length > 0;
            if (!isValidUsername)
            {
                MessageBox.Show("You must enter username");
                return;
            }
            if (!isValidPassword)
            {
                MessageBox.Show("You must enter password");
                return;
            }
            if (Database.Database
                    .Instance
                    .Login(txtUsername.Text, txtPassword.Text))
            {
                StudentListForm.LoginForm = this;
                StudentListForm.Show();
                this.Enabled = false;
            }
            else {
                MessageBox.Show("Wrong username, password");
            }
        }

        private void LoginForm_Load(object sender, EventArgs e)
        {

        }

        private void btnExit_Click(object sender, EventArgs e)
        {
            this.Dispose();
        }

        private void btnLogin_Click_1(object sender, EventArgs e)
        {

        }

        private void txtUsername_TextChanged(object sender, EventArgs e)
        {

        }
    }
}
