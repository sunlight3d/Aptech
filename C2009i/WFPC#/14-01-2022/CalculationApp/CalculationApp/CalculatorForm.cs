using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Data;
using System.Drawing;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Windows.Forms;

namespace CalculationApp
{
    public partial class CalculatorForm : Form, IDesign
    {
        private const int SCREEN_WIDTH = 1024;
        private const int SCREEN_HEIGHT = 600;
        private TextBox textBoxExpression = new TextBox();
        private List<List<String>> buttonTexts = new List<List<String>>() { 
            new List<string>() { 
                "(", ")", "mc", "m+", "m-", "mr", "AC", "+/-", "%", ":"
            },
            new List<string>() {
                "2nd", "x2", "x3", "x^y", "e^x", "10^x", "7", "8", "9", "x"
            },
            new List<string>() {
                "1/x", "x1/2", "x1/3", "x1/y", "ln", "log10", "4", "5", "6", "-"
            },
            new List<string>() {
                "x!", "sin", "cos", "tan", "e", "EE", "1", "2", "3", "+"
            },
            new List<string>() {
                "Rad", "sinh", "cosh", "tanh", "pi", "Rand", "0", "0", ".", "="
            }
        };
        private List<List<UIButton>> uiButtons = new List<List<UIButton>>();
        public CalculatorForm()
        {
            InitializeComponent();
            SetupUI();
        }
        private bool IsOperand(String strOperand) =>
                    strOperand.Equals("+") ||
                    strOperand.Equals("-") ||
                    strOperand.Equals("x") ||
                    strOperand.Equals("=") ||
                    strOperand.Equals(":");
        private void BuildButtons() {
            for (int i = 0; i < buttonTexts.Count; i++) {
                List<String> row = buttonTexts[i];
                for (int j = 0; j < row.Count; j++)
                {
                    String item = row[j];
                    UIButton eachButton = new UIButton();
                    eachButton.Text = item;
                    eachButton.Width = SCREEN_WIDTH / row.Count;
                    eachButton.Height = (SCREEN_HEIGHT - 100 - 40) / buttonTexts.Count;
                    eachButton.Location = new Point(j* eachButton.Width, 100 + i*eachButton.Height);
                    eachButton.Font = new Font(
                           new FontFamily("Arial"),
                           20,
                           FontStyle.Regular,
                           GraphicsUnit.Pixel);
                    eachButton.ForeColor = IsOperand(item) ? Color.White : Color.Black;
                    eachButton.BackColor = IsOperand(item) ? Color.Orange : eachButton.BackColor;
                    this.Controls.Add(eachButton);
                    eachButton.Click += EachButton_Click;

                }
            }            
        }

        private void EachButton_Click(object sender, EventArgs e)
        {
            MessageBox.Show($"You clicked {((UIButton)sender).Text}");
        }

        public void SetupUI()
        {
            this.Width = SCREEN_WIDTH;
            this.Height = SCREEN_HEIGHT;
            this.Text = "This is Calculator App";
            GroupBox headerGroupbox = new GroupBox();
            headerGroupbox.FlatStyle = FlatStyle.Flat;
            headerGroupbox.Text = "";
            headerGroupbox.Height = 100;
            headerGroupbox.BackColor = Color.FromArgb(50, 149, 146, 148);
            headerGroupbox.Width = SCREEN_WIDTH;            
            this.Controls.Add(headerGroupbox);
            headerGroupbox.Controls.Add(textBoxExpression);            
            textBoxExpression.MinimumSize = new Size(SCREEN_WIDTH, 50);
            textBoxExpression.TextAlign = HorizontalAlignment.Right;
            textBoxExpression.Text = textBoxExpression.Text
                .PadRight(textBoxExpression.Text.Length + 10);
            textBoxExpression.Font = new Font(
                           new FontFamily("Arial"),
                           20,
                           FontStyle.Regular,
                           GraphicsUnit.Pixel);
            textBoxExpression.Margin = new Padding(10, 10, 10, 10);
            BuildButtons();
        }
    }
}
