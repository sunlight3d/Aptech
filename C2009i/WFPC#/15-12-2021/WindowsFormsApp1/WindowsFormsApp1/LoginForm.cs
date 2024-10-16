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
    public partial class LoginForm : Form
    {
        
        public LoginForm()
        {
            InitializeComponent();
            textBoxPassword.PasswordChar = '*';
            textBoxEmail.TextChanged += TextBoxEmail_TextChanged;
            textBoxPassword.TextChanged += TextBoxPassword_TextChanged;
        }

        private void TextBoxPassword_TextChanged(object sender, EventArgs e)
        {
            passwordError.Text = Utilities.isValidPassword(textBoxPassword.Text) ? "" :
                                "Password must have at least 3 characters";
            buttonLogin.Enabled = Utilities.IsValidEmail(textBoxEmail.Text)
                                    && Utilities.isValidPassword(textBoxPassword.Text);
        }

        private void TextBoxEmail_TextChanged(object sender, EventArgs e)
        {
            textBoxEmailError.Text = Utilities.IsValidEmail(textBoxEmail.Text) ? "" :
                                "Email is not in correct format";
            buttonLogin.Enabled = Utilities.IsValidEmail(textBoxEmail.Text)
                                    && Utilities.isValidPassword(textBoxPassword.Text);
        }

        private void buttonLogin_Click(object sender, EventArgs e)
        {
            this.ValidateInput();
        }
        private void ValidateInput() {
            /*
            if (!Utilities.IsValidEmail(textBoxEmail.Text) ||
                !Utilities.isValidPassword(textBoxPassword.Text)) {
                MessageBox.Show("Email/password not in correct format");
                return;
            }
            MessageBox.Show($"Email : {textBoxEmail.Text}, Password: {textBoxPassword.Text}");
        */
        }
    }
}
