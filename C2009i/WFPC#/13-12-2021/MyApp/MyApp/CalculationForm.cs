using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Data;
using System.Drawing;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Windows.Forms;

namespace MyApp
{
    public partial class CalculationForm : Form
    {
        public CalculationForm()
        {
            InitializeComponent();
            comboBoxOperator.DataSource = new List<String>() { 
                "Add", "Minus", "Multiple", "Divide"
            };
            comboBoxOperator.SelectedIndexChanged += ComboBoxOperator_SelectedIndexChanged;
        }

        private void ComboBoxOperator_SelectedIndexChanged(object sender, EventArgs e)
        {
            //comboBoxOperator.SelectedItem
        }
        private void CalculateData()
        {
            int x = Convert.ToInt32(textBoxX.Text);
            int y = Convert.ToInt32(textBoxY.Text);
            String myOperator = (String)comboBoxOperator.SelectedItem;
            int result = 0;
            if (myOperator.ToLower().Equals("add")) {
                result = x + y;
            } else if (myOperator.ToLower().Equals("minus")) {
                result = x - y;
            } else if (myOperator.ToLower().Equals("multiple"))
            {
                result = x * y;
            }
            else if (myOperator.ToLower().Equals("divide"))
            {
                result = x / y;
            }
            textBoxResult.Text = $"{result}";
           
        }

        private void button1_Click(object sender, EventArgs e)
        {
            CalculateData();
        }

        private void buttonClear_Click(object sender, EventArgs e)
        {
            textBoxX.Text = "0";
            textBoxY.Text = "0";
            textBoxResult.Text = "0";
        }
    }
}
