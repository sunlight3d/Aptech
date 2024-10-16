using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Data;
using System.Drawing;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Windows.Forms;

namespace dvdproject
{
    public partial class MainForm : Form
    {
        private MyDBEntities dbContext = new MyDBEntities();
        public MainForm()
        {
            InitializeComponent();
            SetupDataGridView();
            PopulateDataGridView();
        }

        private void SetupDataGridView()
        {            

            dataGridView.ColumnCount = 6;
            dataGridView.ColumnHeadersDefaultCellStyle.BackColor = Color.Navy;
            dataGridView.ColumnHeadersDefaultCellStyle.ForeColor = Color.White;
            dataGridView.ColumnHeadersDefaultCellStyle.Font = new Font(dataGridView.Font, FontStyle.Bold);
            dataGridView.ReadOnly = true;

            dataGridView.Name = "DVD Library";            
            dataGridView.Size = new Size(800, 600);            
            dataGridView.ColumnHeadersBorderStyle =
                DataGridViewHeaderBorderStyle.Single;
            dataGridView.CellBorderStyle = DataGridViewCellBorderStyle.Single;
            dataGridView.GridColor = Color.Black;
            dataGridView.RowHeadersVisible = false;

            dataGridView.Columns[0].Name = "DVDCodeNo";
            dataGridView.Columns[1].Name = "DVDCategoryID";
            dataGridView.Columns[2].Name = "DVDTitle";
            dataGridView.Columns[3].Name = "Subtitles";
            dataGridView.Columns[3].ValueType = typeof(bool);
            dataGridView.Columns[4].Name = "Price";
            dataGridView.Columns[5].Name = "Date Add";            

            dataGridView.SelectionMode =
                DataGridViewSelectionMode.FullRowSelect;
            dataGridView.MultiSelect = false;
            dataGridView.Dock = DockStyle.Fill;            
        }
        private void PopulateDataGridView()
        {
            dbContext.tblDVDLibraries.ToList().ForEach(dvdLibrary => {
                string[] row = {
                    $"{dvdLibrary.DVDCodeNo}",
                    $"{dvdLibrary.DVDCategoryId}",
                    dvdLibrary.DVDTitle,
                    dvdLibrary.SubTitles == true ? "true": "false",
                    $"{dvdLibrary.Price}",
                    $"{dvdLibrary.DateAdd}",
                };
                dataGridView.Rows.Add(row);
            });

                        
        }
        private void MainForm_Load(object sender, EventArgs e)
        {
            // TODO: This line of code loads data into the 'testdbDataSet.tblDVDLibrary' table. You can move, or remove it, as needed.
            this.tblDVDLibraryTableAdapter.Fill(this.testdbDataSet.tblDVDLibrary);

        }

        private void btnExit_Click(object sender, EventArgs e)
        {
            Application.Exit();
        }
    }
}
