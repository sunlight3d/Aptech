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
            dataGridView.ColumnCount = 4;
            dataGridView.Columns[0].Name = "TenLop";
            dataGridView.Columns[1].Name = "TenSv";
            dataGridView.Columns[2].Name = "UserNm";
            dataGridView.Columns[3].Name = "DiaChi";
            dataGridView.SelectionMode =
            DataGridViewSelectionMode.FullRowSelect;
            dataGridView.AllowUserToAddRows = false;
            dataGridView.AllowUserToResizeRows = false;
            dataGridView.SelectionChanged += DataGridView_SelectionChanged;
            dataGridView.ReadOnly = true;

        }

        private void DataGridView_SelectionChanged(object sender, EventArgs e)
        {
            btnSave.Enabled = false;
            foreach (DataGridViewRow row in dataGridView.SelectedRows)
            {
                Console.WriteLine("haha");
                this.comboBoxClass.SelectedItem = row.Cells[0].Value.ToString();
                txtStudentName.Text = row.Cells[1].Value.ToString();
                txtUserName.Text = row.Cells[2].Value.ToString();
                txtAddress.Text = row.Cells[3].Value.ToString();
            }
        }
        public void fetchClassesToCombobox() {
            List<ClassModel> classes = Database.GetInstance().GetAllClasses();
            this.comboBoxClass.Items.Clear();
            foreach (ClassModel classModel in classes) {
                this.comboBoxClass.Items.Add(classModel.TenLop);
            }        
            
        }

        public void fetchDataToGridView(List<Dictionary<String, String>> data) { 
            dataGridView.Rows.Clear(); 
            foreach (Dictionary<String, String> dictionary in data) {
                string[] eachRowData = { 
                    dictionary["TenLop"],                     
                    dictionary["TenSv"], 
                    dictionary["UserNm"],
                    dictionary["DiaChi"],

                };
                dataGridView.Rows.Add(eachRowData);
            }
        }
        public MainForm()
        {
            InitializeComponent();//nam o partial class khac            
            btnSave.Enabled = false;
            SetupDataGridView();
            List<Dictionary<String, String>> data = Database.GetInstance().GetClassStudent();
            fetchClassesToCombobox();
            fetchDataToGridView(data);

        }

        private void label2_Click(object sender, EventArgs e)
        {

        }

       

        private void btnExit_Click(object sender, EventArgs e)
        {
            List<Dictionary<String, String>> data = Database.GetInstance().GetClassStudent();
            fetchDataToGridView(data);
        }

        private void btnExportXML_Click(object sender, EventArgs e)
        {
            MessageBox.Show("Export successfully");
        }

        private void btnInsert_Click(object sender, EventArgs e)
        {
            btnSave.Enabled = true;
        }

        private void btnSave_Click(object sender, EventArgs e)
        {
            Database.GetInstance().InsertStudent(
                txtStudentName.Text, 
                txtUserName.Text,
                txtAddress.Text, 
                Database.GetInstance().GetClassByClassName(comboBoxClass.SelectedItem)
                )
        }
    }
}
