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
    public partial class FormDetailsOfEmployee : Form
    {
        private Employee detailEmployee;
        public Employee DetailEmployee {
            get => detailEmployee;
            set
            {
                detailEmployee = value;
                txtEmployeeName.Text = detailEmployee.EmployeeName;
                txtAddress.Text = detailEmployee.Address;
                comboBoxPosition.SelectedItem = detailEmployee.Position;
                comboBoxCurrentDepartmentName.SelectedItem = detailEmployee.CurrentDepartmentName;
                //checkedListBoxDepartmentWorked.CheckedItems = detailEmployee.DepartmentsWorked;
                for (int count = 0; count < checkedListBoxDepartmentWorked.Items.Count; count++)
                {
                    if (detailEmployee.DepartmentsWorked.Contains(checkedListBoxDepartmentWorked.Items[count].ToString()))
                    {
                        checkedListBoxDepartmentWorked.SetItemChecked(count, true);
                    }
                }
       
            } 
        }
        private List<string> departmentNames = new List<string> {
                "IT", "Account", "HR"
            };
        private List<string> positions = new List<string> {
                "Manager", "Developer", "CEO", "Sales"
            };
        public FormDetailsOfEmployee()
        {
            InitializeComponent();
            /*
             * mployeeName { get; set; }
        public string Address { get; set; }
        public string Position { get; set; }
        public string CurrentDepartmentName { get; set; }
        public List<string> DepartmentsWorked { get; set; }
             */
            comboBoxPosition.DataSource = positions;
            comboBoxCurrentDepartmentName.DataSource = departmentNames;
            foreach (string departmentName in departmentNames) {
                checkedListBoxDepartmentWorked.Items.Add(departmentName, CheckState.Unchecked);
            }
            DetailEmployee = new Employee()
            {
                EmployeeName = "Hoang",
                Address = "Street A, prvvin B",
                Position = "Developer",
                CurrentDepartmentName = "IT",
                DepartmentsWorked = new List<string> {
                    "Account"
                }
            };
            

        }

        private void label5_Click(object sender, EventArgs e)
        {

        }
    }
}
