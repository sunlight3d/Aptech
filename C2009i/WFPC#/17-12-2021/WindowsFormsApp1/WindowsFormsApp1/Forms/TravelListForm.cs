using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Data;
using System.Drawing;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Windows.Forms;
using WindowsFormsApp1.Models;
using WindowsFormsApp1.Repositories;
namespace WindowsFormsApp1.Forms
{
    public partial class TravelListForm : Form
    {
        private TravelRepository travelRepository = new TravelRepository();
        private CategoryRepository categoryRepository = new CategoryRepository();
        public TravelListForm()
        {

            InitializeComponent();
            SetupListView();
            FetchDataToListView();
            SetupTreeView();
            FetchDataToTreeView();
        }
        private void SetupTreeView() {
            treeViewCategory.Nodes.Clear();
            treeViewCategory.Nodes.Add(new TreeNode("Category"));
            treeViewCategory.AfterSelect += TreeViewCategory_AfterSelect;
        }

        private void TreeViewCategory_AfterSelect(object sender, TreeViewEventArgs e)
        {
            Console.WriteLine($"selected node = {treeViewCategory.SelectedNode}");
        }

        private void FetchDataToTreeView()
        {
            treeViewCategory.Nodes[0].Nodes.Clear();
            foreach (Category category in categoryRepository.GetCategories()) {
                TreeNode treeNode = new TreeNode(category.CategoryName);                
                treeViewCategory.Nodes[0].Nodes.Add(treeNode);
            }
        }
        private void SetupListView() {
            //setup ListView
            listViewTravels.Columns.Add("No", 30);
            listViewTravels.Columns.Add("Name", 100);
            listViewTravels.Columns.Add("From", 100);
            listViewTravels.Columns.Add("To", 100);
            listViewTravels.Columns.Add("Price", 80);
            listViewTravels.Columns.Add("Start Date", 200);
        }
        private void FetchDataToListView() {
            List<Travel> travels = travelRepository.GetTravels();
            //iterate a list and fetch data
            int index = 0;
            foreach (Travel travel in travels)
            {
                index++;
                string[] eachRow = {
                    $"{index}",
                    travel.Name,
                    travel.From,
                    travel.To,
                    $"{Math.Round(travel.Price, 2)} VND",
                    $"{Utilities.convertDateTimeToString(travel.StartDate)}"
                };
                listViewTravels.Items.Add(new ListViewItem(eachRow));
            }
        }
    }
}
