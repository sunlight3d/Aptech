using ExamApp.models;
using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Data;
using System.Drawing;
using System.Linq;
using System.Text;
using System.Text.RegularExpressions;
using System.Threading.Tasks;
using System.Windows.Forms;

namespace ExamApp
{
    public partial class EmployeeDetailForm : Form
    {
        private Employee employee;
        public Employee Employee { 
            set {
                employee = value;
                //Update UI
                this.textBoxEmployeeName.Text = employee.EmployeeName.Trim();
                if (employee.Gender == 0) {
                    this.radioButtonGenderMale.Checked = false;
                    this.radioButtonGenderFemale.Checked = true;
                }else if (employee.Gender == 1)
                {
                    this.radioButtonGenderMale.Checked = true;
                    this.radioButtonGenderFemale.Checked = false;
                }
                this.textBoxAddress.Text = employee.Address.Trim();
                
            } 
        }
        public EmployeeDetailForm()
        {
            InitializeComponent();
        }
        private Boolean validateInput()
        {
            if(textBoxEmployeeName.Text.Trim().Length < 5)
            {
                MessageBox.Show("Employee name length must < 5");
                return false;
            }
            if (this.dateTimePickerBirthDate.Value.Year > 1999)
            {
                MessageBox.Show("Year must <= 1999");
                return false;
            }

            Regex regex = new Regex(@"^0[0-9]{6}$", RegexOptions.IgnoreCase);
            MatchCollection matches = regex.Matches(textBoxTeplephone.Text.Trim());
            if(matches.Count == 0)
            {
                MessageBox.Show("Tel must >=6 in length, start with \"0\"");
                return false;
            }
            
            return true;
        }
        private void buttonAddNew_Click(object sender, EventArgs e)
        {

        }

        private void groupBox1_Enter(object sender, EventArgs e)
        {

        }

        private void textBoxAddress_TextChanged(object sender, EventArgs e)
        {

        }
    }
}
