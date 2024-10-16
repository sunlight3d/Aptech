using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Data;
using System.Drawing;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Windows.Forms;

namespace MDIExample
{
    public partial class Admin : Form
    {
        private MenuStrip menuStrip = new MenuStrip();
        private GeneralTestForm generalTestForm = new GeneralTestForm();
        private List<List<MenuData>> menus
                = new List<List<MenuData>>()
                {
                    new List<MenuData>() { 
                        new MenuData() { 
                            Id = 1, 
                            Name = "File"
                        },
                        new MenuData() {
                            Id = 11,
                            Name = "Open"
                        },
                        new MenuData() {
                            Id = 12,
                            Name = "Save As"
                        },
                    },
                    new List<MenuData>() {
                        new MenuData() {
                            Id = 2,
                            Name = "Question Bank"
                        },
                        new MenuData() {
                            Id = 21,
                            Name = "Do A"
                        },
                        new MenuData() {
                            Id = 22,
                            Name = "Do B"
                        },
                    },
                    new List<MenuData>() {
                        new MenuData() {
                            Id = 3,
                            Name = "Help"
                        },
                        new MenuData() {
                            Id = 31,
                            Name = "About"
                        },                        
                    }
                };
        /*
         tai khoan Admin=> vao duoc mot so menu Abc,...
         tai khoan user khac => vao dc menu cde....   
         */
        public Admin()
        {
            InitializeComponent();
            this.IsMdiContainer = true;                                    
            SetupMenuStrip();
            generalTestForm.MdiParent = this;
            generalTestForm.Show();
        }
        private void SetupMenuStrip() {
            menuStrip.Dock = DockStyle.Top;
            this.Controls.Add(menuStrip);
            if (!this.Controls.Contains(menuStrip)) {
                this.Controls.Add(menuStrip);
            }
            foreach(List<MenuData> eachList in menus) {
                ToolStripMenuItem menuItem = new ToolStripMenuItem(eachList[0].Name);
                menuStrip.Items.Add(menuItem);
                menuItem.Click += MenuItem_Click;
                menuItem.Tag = eachList[0];
                foreach (MenuData eachMenuData in eachList) { 
                    if(eachMenuData.Id > 10)
                    {
                        ToolStripMenuItem menuSubItem = new ToolStripMenuItem(eachMenuData.Name);
                        menuItem.DropDownItems.Add(menuSubItem);
                        menuSubItem.Click += MenuItem_Click;
                        menuSubItem.Tag = eachMenuData;
                    }
                }
            }            
        }

        private void MenuItem_Click(object sender, EventArgs e)
        {
            ToolStripMenuItem selectedMenuItem = (ToolStripMenuItem)sender;
            MenuData selectedMenuData = (MenuData)selectedMenuItem.Tag;
            MessageBox.Show($"You choose {selectedMenuData.Name}");
            //if (selectedMenuData.Name.ToLower().Equals("file")) { ...}
        }

        private void fileToolStripMenuItem_Click(object sender, EventArgs e)
        {

        }
    }
}
