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
    public partial class FormTravel : Form
    {
        public FormTravel()
        {
            InitializeComponent();
            comboBoxTravelType.DataSource = new List<string>
            {
                "By air", "By walking", "By Bus"
            };
            comboBoxContinents.DataSource = new List<string>
            {
                "Africa", "Asia", "Europe"
            };
        }
        private string getCheckedOption()
        {
            if (radioByTravelType.Checked == true)
            {
                return "TravelType";
            }
            else if (radioByContinents.Checked == true)
            {
                return "Continents";
            }
            else if (radioAllPackages.Checked == true)
            {
                return "AllPackages";
            }
            return "";
        }

        private void button1_Click(object sender, EventArgs e)
        {
            MessageBox.Show(
                $"Travel type = {comboBoxTravelType.SelectedItem}, " +
                $"Continents = {comboBoxContinents.SelectedItem}" +
                $"Search oprion = {this.getCheckedOption()}");
        }
    }
}