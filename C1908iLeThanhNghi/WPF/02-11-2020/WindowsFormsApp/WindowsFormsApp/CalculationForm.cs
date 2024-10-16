using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Data;
using System.Drawing;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Windows.Forms;

namespace WindowsFormsApp
{
    public partial class CalculationForm : Form
    {
        private Random random = new Random();
        private int x;
        private int y;
        private int timeLeft;
        private const int MAX_TIMER = 10;
        private void StartTheQuiz() {
            x = random.Next(51);
            y = random.Next(51);
            txtX.Text = $"{x}";
            txtY.Text = $"{y}";
            numericUpDownSum.Value = 0;
            timeLeft = MAX_TIMER;
            timer.Start();
        }
        public CalculationForm()
        {
            InitializeComponent();
        }

        private void btnStart_Click(object sender, EventArgs e)
        {
            StartTheQuiz();
            btnStart.Enabled = false;
        }

        private void timer_Tick(object sender, EventArgs e)
        {            
            timeLeft = timeLeft <= 0 ? timeLeft : timeLeft - 1;
            labelTimer.Text = $"{timeLeft} seconds";
            if (this.CheckTheAnswer()) {
                timer.Stop();
                btnStart.Enabled = true;
                MessageBox.Show("Yessssss");
                return;
            }
            if(timeLeft <= 0)
            {
                timer.Stop();
                labelTimer.Text = "End...";
                numericUpDownSum.Value = x + y;
                btnStart.Enabled = true;
            }
        }
        private bool CheckTheAnswer() 
            => x + y == numericUpDownSum.Value;
        
    }
}
