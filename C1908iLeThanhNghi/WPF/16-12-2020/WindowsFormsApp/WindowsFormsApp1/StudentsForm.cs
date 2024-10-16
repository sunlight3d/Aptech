using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Data;
using System.Drawing;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Windows.Forms;
using WindowsFormsApp1.models;

namespace WindowsFormsApp1
{
    public partial class StudentsForm : Form
    {
        private LoginForm loginForm;
        private List<Student> students;
        private Student selectedStudent;
        public StudentsForm(LoginForm loginForm):base()
        {
            InitializeComponent();
            this.loginForm = loginForm;
            this.loginForm.Hide();
          
            configureDataGridView();
            
        }
        private void configureDataGridView()
        {
            
            dataGridView.ColumnHeadersDefaultCellStyle.BackColor = Color.Navy;
            dataGridView.ColumnHeadersDefaultCellStyle.ForeColor = Color.White;
            dataGridView.ColumnHeadersDefaultCellStyle.Font =
            new Font(dataGridView.Font, FontStyle.Bold);
            dataGridView.ColumnCount = 4;
            dataGridView.Columns[0].Name = "Ten lop";
            dataGridView.Columns[1].Name = "Ten sinh vien";
            dataGridView.Columns[2].Name = "Username";
            dataGridView.Columns[3].Name = "Dia chi";
            dataGridView.SelectionMode =
            DataGridViewSelectionMode.FullRowSelect;
            dataGridView.MultiSelect = false;
            dataGridView.AllowUserToAddRows = false;
            dataGridView.RowHeadersVisible = false;
            //dataGridView.Dock = DockStyle.Fill;
            dataGridView.SelectionChanged += DataGridView_SelectionChanged;
        }

        private void DataGridView_SelectionChanged(object sender, EventArgs e)
        {
            if (dataGridView.SelectedRows.Count == 0) {
                return;
            }
            var selectedIndex = dataGridView.SelectedRows[0].Index;
            selectedStudent = this.students[selectedIndex];
            txtClassName.Text = Database.GetInstance()
                                .getClassFromId(selectedStudent.ClassId)
                                .ClassName;
            txtStudentName.Text = selectedStudent.StudentName;
            txtUserName.Text = selectedStudent.UserName;
            txtAddress.Text = selectedStudent.Address;
            Console.WriteLine("haha");
        }

        private void PopulateDataGridView() {
            this.students = Database.GetInstance().GetStudents();
            foreach(Student student in students)
            {
                MyClass myClass = Database.GetInstance().getClassFromId(student.ClassId);
                string[] eachRow = {
                    myClass == null ? "" : myClass.ClassName,
                    student.StudentName,
                    student.UserName,
                    student.Address,
                };
                dataGridView.Rows.Add(eachRow);
            }
            
        }
        protected override void OnClosing(System.ComponentModel.CancelEventArgs e) {
            this.loginForm?.Show();
        }

        private void label1_Click(object sender, EventArgs e)
        {

        }

        private void btnQuery_Click(object sender, EventArgs e)
        {
            PopulateDataGridView();
        }

        private void btnExportXML_Click(object sender, EventArgs e)
        {
            try
            {
                System.Xml.Serialization.XmlSerializer writer =
                new System.Xml.Serialization.XmlSerializer(typeof(Student));

                var path = Environment.GetFolderPath(Environment.SpecialFolder.MyDocuments) + "//selectedStudent.xml";
                System.IO.FileStream file = System.IO.File.Create(path);

                writer.Serialize(file, selectedStudent);
                file.Close();
                MessageBox.Show("Export successful");
            }
            catch (Exception ex) {
                MessageBox.Show($"Cannot export XML, error: {ex.ToString()}");
            }
            
        }
    }
}
