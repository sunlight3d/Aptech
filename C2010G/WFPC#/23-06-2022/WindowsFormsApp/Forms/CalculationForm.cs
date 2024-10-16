using System;
using System.Windows.Forms;

namespace WindowsFormsApp.Forms
{
    public partial class CalculationForm : Form
    {
        public CalculationForm()
        {
            InitializeComponent();
            comboBoxOperation.Items.AddRange(new object[] {"+","-","x","/"});
        }

        private void CalculationForm_Load(object sender, EventArgs e)
        {

        }

        private void btnCalculate_Click(object sender, EventArgs e)
        {
            int result = 0;
            try
            {
                int number1 = Int32.Parse(txtNumber1.Text ?? "0");
                int number2 = Int32.Parse(txtNumber2.Text ?? "0");                
                String operation = comboBoxOperation.SelectedItem.ToString().Trim();
                
                switch (operation)
                {
                    case "+":
                        result = number1 + number2;
                        break;
                    case "-":
                        result = number1 - number2;
                        break;
                    case "x":
                        result = number1 * number2;
                        break;
                    case "/":
                        result = number1 + number2;
                        break;
                }
                MessageBox.Show($"result = {result}");
            }
            catch(Exception error)
            {
                MessageBox.Show($"result = 0, error = {error.ToString()}");
            }
            
        }
    }
}
