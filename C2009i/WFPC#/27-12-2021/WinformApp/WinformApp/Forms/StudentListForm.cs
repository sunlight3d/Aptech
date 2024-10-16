using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Data;
using System.Drawing;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Windows.Forms;

namespace WinformApp.Forms
{
    public partial class StudentListForm : Form
    {
        public StudentListForm()
        {
            InitializeComponent();
            dataGridView1.SelectionChanged += DataGridView1_SelectionChanged;
            buttonSave.Enabled = false;
        }

        private void DataGridView1_SelectionChanged(object sender, EventArgs e)
        {
            
            if (dataGridView1.SelectedRows.Count > 0) {
                var selectedRow = dataGridView1.SelectedRows[0];
                textBoxClassName.Text = selectedRow.Cells[0].Value.ToString();
                textBoxStudentName.Text = selectedRow.Cells[1].Value.ToString();
                textBoxUsername.Text = selectedRow.Cells[2].Value.ToString();
                textBoxAddress.Text = selectedRow.Cells[3].Value.ToString();
                Console.WriteLine("haha");
            }
        }

        private void StudentListForm_Load(object sender, EventArgs e)
        {
            // TODO: This line of code loads data into the 'myDatabaseDataSet1.view_StudentClass' table. You can move, or remove it, as needed.
            this.view_StudentClassTableAdapter1.Fill(this.myDatabaseDataSet1.view_StudentClass);
            //this.view_StudentClassTableAdapter.Fill(this.myDatabaseDataSet.view_StudentClass);            
        }

        private void textBox1_TextChanged(object sender, EventArgs e)
        {

        }

        private void buttonExportXML_Click(object sender, EventArgs e)
        {
            
            if (dataGridView1.Rows.Count > 0)
            {
                MessageBox.Show("Export successfully");
            }
            else {
                MessageBox.Show("No data to export");
            }
            
        }

        private void buttonDelete_Click(object sender, EventArgs e)
        {
            DialogResult dialogResult = MessageBox.Show("Delete", "Do you really need to delete this ?", 
                MessageBoxButtons.YesNoCancel, MessageBoxIcon.Information);

            if (dialogResult == DialogResult.Yes)
            {
                foreach (DataGridViewRow item in this.dataGridView1.SelectedRows)
                {
                    dataGridView1.Rows.RemoveAt(item.Index);
                }
            }            
        }

        private void buttonInsert_Click(object sender, EventArgs e)
        {
            buttonSave.Enabled = true;
        }

        private void buttonSave_Click(object sender, EventArgs e)
        {
            //...
            if (buttonSave.Enabled == true) {
                //https://stackoverflow.com/questions/9867550/insert-row-in-middle-of-datagridview-c
            }
            buttonSave.Enabled = false;
        }
    }
}
