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
    public partial class SearchTravelForm : Form
    {
        private List<string> travelTypes = new List<string> {
                "Bicycle",
                "Air",
                "Car"
            };
        private List<string> continents = new List<string>
            {
                "Asia",
                "Africa",
                "Europe",
                "North America",
                "South America",
                "Australia/Oceania",
                "Antarctica",
            };
        public SearchTravelForm()
        {
            InitializeComponent();
            SetupUI();
        }
        public void SetupUI() {
            //Items is "getter"
            //radioButtonByType.Checked = true;
            radioButtonByContinents.Checked = true;
            checkBoxText.Checked = true;
            comboBoxTravelType.DataSource = this.travelTypes;           
            comboBoxContinents.DataSource = this.continents;
            buttonView.MouseClick += ButtonView_MouseClick;
        }

        private void ButtonView_MouseClick(object sender, MouseEventArgs e)
        {
            MessageBox.Show($"Travel type: {comboBoxTravelType.SelectedItem}\n" +
                $"Continents: {comboBoxContinents.SelectedItem}\n");
        }
    }
}
