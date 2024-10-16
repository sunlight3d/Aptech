using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Data;
using System.Drawing;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Windows.Forms;

namespace De02.Forms
{
    public partial class StudentListForm : Form
    {
        //public LoginForm loginForm; //field        
        //property
        public LoginForm LoginForm { get; set; }
        private int studentId;
        public StudentListForm()
        {
            InitializeComponent();
            reloadDataGridView();
        }
        private void reloadDataGridView()
        {
            dataGridView.AutoGenerateColumns = false;
            dataGridView.RowHeadersVisible = false;
            //dataGridView.ColumnHeadersVisible = false;
            dataGridView.ReadOnly = false;
            //dataGridView.MultiSelect = false;
            dataGridView.SelectionMode = DataGridViewSelectionMode.FullRowSelect;            
            //className, studentName,userName,address             
            //Set Columns Count
            dataGridView.ColumnCount = 4;
            //Add Columns
            dataGridView.Columns[0].Name = "TenLop";
            dataGridView.Columns[0].HeaderText = "Ten lop";
            dataGridView.Columns[0].DataPropertyName = "ClassName";

            dataGridView.Columns[1].Name = "TenSV";
            dataGridView.Columns[1].HeaderText = "Ten SV";
            dataGridView.Columns[1].DataPropertyName = "StudentName";

            dataGridView.Columns[2].Name = "UserNm";
            dataGridView.Columns[2].HeaderText = "UserNm";
            dataGridView.Columns[2].DataPropertyName = "UserName";

            dataGridView.Columns[3].Name = "DiaChi";
            dataGridView.Columns[3].HeaderText = "Dia chi";
            dataGridView.Columns[3].DataPropertyName = "Address";            

            dataGridView.DataSource = Database.Database
                                        .Instance
                                        .GetStudents()
                                        .Tables[0];
            dataGridView.SelectionChanged += DataGridView_SelectionChanged;
            comboBoxClassName.DataSource = Database.Database
                    .Instance.GetClasses().Tables[0];
            comboBoxClassName.DisplayMember = "ClassName";
        }
        private void DataGridView_SelectionChanged(object sender, EventArgs e)
        {
            var rowsCount = dataGridView.SelectedRows.Count;
            if (rowsCount == 0) return;
            DataRowView dataRowView = (DataRowView)dataGridView.SelectedRows[0].DataBoundItem;
            //dataRowView.Row.ItemArray[0];
            this.studentId = (int)dataRowView.Row.ItemArray[0];
            String className = (String)dataRowView.Row.ItemArray[1];
            String studentName = (String)dataRowView.Row.ItemArray[2];
            String userName = (String)dataRowView.Row.ItemArray[3];
            String address = (String)dataRowView.Row.ItemArray[4];
            
            //fill in Form
            txtStudentName.Text = studentName;
            txtUsername.Text = userName;
            txtAddress.Text = address;
            comboBoxClassName.Text = className;


            Console.WriteLine("haha");            
        }
        protected override void Dispose(bool disposing)
        {
            LoginForm.Enabled = true;
            if (disposing && (components != null))
            {
                components.Dispose();
            }
            base.Dispose(disposing);
            
        }

        private void dataGridView_CellContentClick(object sender, DataGridViewCellEventArgs e)
        {

        }

        private void btnSave_Click(object sender, EventArgs e)
        {
            DataRowView dataRowView = (DataRowView)comboBoxClassName.SelectedItem;
            //dataRowView.Row.ItemArray
            Console.WriteLine("haha");
            Database.Database.Instance.UpdateStudent(
                studentName: txtStudentName.Text,
                userName: txtUsername.Text,
                address: txtAddress.Text,
                classCode: (int)dataRowView.Row.ItemArray[0],
                studentId: studentId
                //classCode:comboBoxClassName.SelectedItem               
                );            
        }
    }
}
