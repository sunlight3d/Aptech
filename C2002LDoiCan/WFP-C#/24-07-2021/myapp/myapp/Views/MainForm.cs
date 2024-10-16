using myapp.Models;
using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Data;
using System.Drawing;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Windows.Forms;

namespace myapp
{
    public partial class MainForm : Form
    {
        public LoginForm LoginForm { get; set; }
        private void SetupDataGridView() {
            dataGridView.Columns[0].Name = "TenLop";
            dataGridView.Columns[1].Name = "TenSv";
            dataGridView.Columns[2].Name = "UserNm";
            dataGridView.Columns[3].Name = "DiaChi";
            dataGridView.SelectionMode =
            DataGridViewSelectionMode.FullRowSelect;
        }
        public void fetchDataToGridView(List<Student> students) {
            dataGridView.Rows.Clear();
            foreach (Student student in students) {
                dataGridView.Rows.Add({ student.TenSv});
            }
        }
        public MainForm()
        {
            InitializeComponent();//nam o partial class khac            
        }

        private void label2_Click(object sender, EventArgs e)
        {

        }

       

        private void btnExit_Click(object sender, EventArgs e)
        {
            Application.Exit();
        }

        private void btnExportXML_Click(object sender, EventArgs e)
        {
            MessageBox.Show("Export successfully");
        }
    }
}
