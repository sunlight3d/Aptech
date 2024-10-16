using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Data;
using System.Drawing;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Windows.Forms;
using WindowsFormsApp1.models;

namespace WindowsFormsApp1
{
    public partial class LoginForm : Form
    {
        private StudentsForm studentsForm = null;
        public LoginForm()
        {
            InitializeComponent();
            SetupUI();
        }
        private void SetupUI() {
            txtUserName.AutoSize = false;
            txtPassword.AutoSize = false;
        }

        private void btnLogin_Click(object sender, EventArgs e)
        {
            Login();            

        }

        private void LoginForm_Load(object sender, EventArgs e)
        {

        }

        private void btnExit_Click(object sender, EventArgs e)
        {
            Application.Exit();
        }

        private void txtPassword_Enter(object sender, EventArgs e)
        {
            
        }
        private void Login()
        {
            string userName = txtUserName.Text.Trim() ?? "";
            string password = txtPassword.Text.Trim() ?? "";
            if (userName == "" || password == "")
            {
                MessageBox.Show("Username or password is invalid", "Error");
                return;
            }
            Student student = Database.GetInstance().Login(userName, password);
            if (student == null)
            {
                MessageBox.Show("Cannot login to the system", "Error");
                return;
            }
            studentsForm = studentsForm == null ? new StudentsForm(this) : studentsForm;

            studentsForm.Show();
        }
        private void txtPassword_KeyDown(object sender, KeyEventArgs e)
        {
            if (e.KeyCode == Keys.Enter)
            {
                Login();
            }
        }
    }
}
