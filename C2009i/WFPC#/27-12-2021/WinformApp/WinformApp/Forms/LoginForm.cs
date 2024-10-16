using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Data;
using System.Drawing;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Windows.Forms;
using WinformApp.Models;
using WinformApp.Repositories;

namespace WinformApp.Forms
{
    public partial class LoginForm : Form
    {
        private StudentListForm studentListForm;
        public LoginForm()
        {
            InitializeComponent();
            textBoxUsername.Text = "hungnv";
            textBoxPassword.Text = "123456";
        }

        private void buttonLogin_Click(object sender, EventArgs e)
        {
            //connect DB:
            //-Entity Framework
            StudentRepository studentRepository = new StudentRepository() ;
            Student loginStudent = studentRepository.login(textBoxUsername.Text, textBoxPassword.Text);
            if (loginStudent != null)
            {
                studentListForm = studentListForm == null ? new StudentListForm() : studentListForm;
                studentListForm.Show();
                this.Hide();
            }
            else {
                MessageBox.Show("Wrong username/password");
            }
            Console.WriteLine("haha");
        }

        private void buttonExit_Click(object sender, EventArgs e)
        {
            Application.Exit();
        }
    }
}
