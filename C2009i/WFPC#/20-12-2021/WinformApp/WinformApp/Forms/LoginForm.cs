using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Data;
using System.Drawing;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Windows.Forms;
using WinformApp.Repositories;

namespace WinformApp.Forms
{
    public partial class LoginForm : Form
    {
        public LoginForm()
        {
            InitializeComponent();
        }

        private void buttonLogin_Click(object sender, EventArgs e)
        {
            //connect DB:
            //-Entity Framework
            StudentRepository studentRepository = new StudentRepository() ;
            Boolean loginResult = studentRepository.login(textBoxUsername.Text, textBoxPassword.Text);
            Console.WriteLine("haha");
        }
    }
}
