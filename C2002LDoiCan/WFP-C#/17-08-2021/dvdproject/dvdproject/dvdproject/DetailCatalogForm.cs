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
    public partial class DetailCatalogForm : Form
    {
        private tblDVDLibrary dvdLibrary;
        private MyDBEntities dbContext = new MyDBEntities();
        public InsertOrUpdate Status { get; set; }
        public MainForm MainForm { get; set; }
        public tblDVDLibrary DVDLibrary { 
            get {
                return dvdLibrary;
            }
            set 
            {                
                dvdLibrary = value;
                //update UI
                if (Status == InsertOrUpdate.Insert)
                {
                    dvdLibrary = new tblDVDLibrary();
                }
                else if (Status == InsertOrUpdate.Update) {
                    txtDVDTitle.Text = dvdLibrary.DVDTitle;
                    comboBoxDVDCategories.SelectedItem = dbContext
                        .tblDVDCategories.Where(item => item.DVDCategoryId == dvdLibrary.DVDCategoryId)
                        .FirstOrDefault();
                    dateTimePickerDateAdd.Value = dvdLibrary.DateAdd ?? new DateTime();
                    numericUpDownPrice.Text = $"{dvdLibrary.Price}";
                    if (dvdLibrary.SubTitles == true)
                    {
                        radioButtonYes.Checked = true;
                        radioButtonNo.Checked = false;
                    }
                    else {
                        radioButtonYes.Checked = false;
                        radioButtonNo.Checked = true;                    
                    }
                    
                }
            }
        }
        public DetailCatalogForm()
        {
            InitializeComponent();
            comboBoxDVDCategories.DataSource = dbContext.tblDVDCategories.ToList();
            comboBoxDVDCategories.DisplayMember = "CategoryName";
        }

        private void btnAccept_Click(object sender, EventArgs e)
        {
            if (Status == InsertOrUpdate.Insert)
            {
                try
                {
                    //add validate code here
                    dvdLibrary = new tblDVDLibrary()
                    {
                        DVDCategoryId = ((tblDVDCategory)comboBoxDVDCategories.SelectedItem)
                                                      .DVDCategoryId,
                        DVDTitle = txtDVDTitle.Text,
                        DateAdd = dateTimePickerDateAdd.Value,
                        Price = Convert.ToDecimal(numericUpDownPrice.Value),
                        SubTitles = radioButtonYes.Checked
                    };
                    dbContext.tblDVDLibraries.Add(dvdLibrary);
                    dbContext.SaveChanges();
                    this.Hide();
                    MainForm.PopulateDataGridView();
                }
                catch (Exception error) {
                    MessageBox.Show($"Error inserting data: {error.Message}");

                }
            }
            else {
                
                try
                {
                    //add validate code here
                    tblDVDLibrary selectedLibrary = dbContext.tblDVDLibraries
                    .Where(item => item.DVDCodeNo == dvdLibrary.DVDCodeNo).FirstOrDefault();
                    selectedLibrary.DVDTitle = txtDVDTitle.Text;
                    selectedLibrary.DateAdd = dateTimePickerDateAdd.Value;
                    selectedLibrary.DVDCategoryId = ((tblDVDCategory)comboBoxDVDCategories.SelectedItem)
                                                      .DVDCategoryId;
                    selectedLibrary.Price = Convert.ToDecimal(numericUpDownPrice.Value);
                    selectedLibrary.SubTitles = radioButtonYes.Checked;                                        
                    dbContext.SaveChanges();
                    this.Hide();
                    MainForm.PopulateDataGridView();
                }
                catch (Exception error)
                {
                    MessageBox.Show($"Error inserting data: {error.Message}");
                }
            }
        }

        private void btnCancel_Click(object sender, EventArgs e)
        {
            this.Hide();
        }

        private void numericUpDown1_ValueChanged(object sender, EventArgs e)
        {

        }
    }
}
