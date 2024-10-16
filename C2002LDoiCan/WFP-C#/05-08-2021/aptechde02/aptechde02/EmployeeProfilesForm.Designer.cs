
namespace aptechde02
{
    partial class EmployeeProfilesForm
    {
        /// <summary>
        /// Required designer variable.
        /// </summary>
        private System.ComponentModel.IContainer components = null;

        /// <summary>
        /// Clean up any resources being used.
        /// </summary>
        /// <param name="disposing">true if managed resources should be disposed; otherwise, false.</param>
        protected override void Dispose(bool disposing)
        {
            if (disposing && (components != null))
            {
                components.Dispose();
            }
            base.Dispose(disposing);
        }

        #region Windows Form Designer generated code

        /// <summary>
        /// Required method for Designer support - do not modify
        /// the contents of this method with the code editor.
        /// </summary>
        private void InitializeComponent()
        {
            this.panel = new System.Windows.Forms.Panel();
            this.btnClose = new System.Windows.Forms.Button();
            this.btnDelete = new System.Windows.Forms.Button();
            this.btnInsert = new System.Windows.Forms.Button();
            this.listViewEmployees = new System.Windows.Forms.ListView();
            this.treeViewDepartment = new System.Windows.Forms.TreeView();
            this.label1 = new System.Windows.Forms.Label();
            this.panel.SuspendLayout();
            this.SuspendLayout();
            // 
            // panel
            // 
            this.panel.Controls.Add(this.btnClose);
            this.panel.Controls.Add(this.btnDelete);
            this.panel.Controls.Add(this.btnInsert);
            this.panel.Location = new System.Drawing.Point(207, 417);
            this.panel.Margin = new System.Windows.Forms.Padding(2, 1, 2, 1);
            this.panel.Name = "panel";
            this.panel.Size = new System.Drawing.Size(367, 52);
            this.panel.TabIndex = 8;
            // 
            // btnClose
            // 
            this.btnClose.Location = new System.Drawing.Point(220, 0);
            this.btnClose.Margin = new System.Windows.Forms.Padding(2, 1, 2, 1);
            this.btnClose.Name = "btnClose";
            this.btnClose.Size = new System.Drawing.Size(100, 28);
            this.btnClose.TabIndex = 2;
            this.btnClose.Text = "Close";
            this.btnClose.UseVisualStyleBackColor = true;
            // 
            // btnDelete
            // 
            this.btnDelete.Location = new System.Drawing.Point(109, 0);
            this.btnDelete.Margin = new System.Windows.Forms.Padding(2, 1, 2, 1);
            this.btnDelete.Name = "btnDelete";
            this.btnDelete.Size = new System.Drawing.Size(100, 28);
            this.btnDelete.TabIndex = 1;
            this.btnDelete.Text = "Delete";
            this.btnDelete.UseVisualStyleBackColor = true;
            // 
            // btnInsert
            // 
            this.btnInsert.Location = new System.Drawing.Point(0, 0);
            this.btnInsert.Margin = new System.Windows.Forms.Padding(2, 1, 2, 1);
            this.btnInsert.Name = "btnInsert";
            this.btnInsert.Size = new System.Drawing.Size(100, 28);
            this.btnInsert.TabIndex = 0;
            this.btnInsert.Text = "Insert";
            this.btnInsert.UseVisualStyleBackColor = true;
            this.btnInsert.Click += new System.EventHandler(this.btnInsert_Click);
            // 
            // listViewEmployees
            // 
            this.listViewEmployees.FullRowSelect = true;
            this.listViewEmployees.HideSelection = false;
            this.listViewEmployees.Location = new System.Drawing.Point(331, 58);
            this.listViewEmployees.Margin = new System.Windows.Forms.Padding(2, 1, 2, 1);
            this.listViewEmployees.MultiSelect = false;
            this.listViewEmployees.Name = "listViewEmployees";
            this.listViewEmployees.Size = new System.Drawing.Size(442, 340);
            this.listViewEmployees.TabIndex = 7;
            this.listViewEmployees.UseCompatibleStateImageBehavior = false;
            // 
            // treeViewDepartment
            // 
            this.treeViewDepartment.Location = new System.Drawing.Point(45, 58);
            this.treeViewDepartment.Margin = new System.Windows.Forms.Padding(2, 1, 2, 1);
            this.treeViewDepartment.Name = "treeViewDepartment";
            this.treeViewDepartment.Size = new System.Drawing.Size(228, 338);
            this.treeViewDepartment.TabIndex = 5;
            // 
            // label1
            // 
            this.label1.AutoSize = true;
            this.label1.Font = new System.Drawing.Font("Segoe UI", 12F, System.Drawing.FontStyle.Bold);
            this.label1.Location = new System.Drawing.Point(45, 11);
            this.label1.Margin = new System.Windows.Forms.Padding(2, 0, 2, 0);
            this.label1.Name = "label1";
            this.label1.Size = new System.Drawing.Size(251, 48);
            this.label1.TabIndex = 6;
            this.label1.Text = "Employee List";
            // 
            // EmployeeProfilesForm
            // 
            this.AutoScaleDimensions = new System.Drawing.SizeF(9F, 20F);
            this.AutoScaleMode = System.Windows.Forms.AutoScaleMode.Font;
            this.ClientSize = new System.Drawing.Size(854, 518);
            this.Controls.Add(this.panel);
            this.Controls.Add(this.listViewEmployees);
            this.Controls.Add(this.treeViewDepartment);
            this.Controls.Add(this.label1);
            this.Margin = new System.Windows.Forms.Padding(2, 1, 2, 1);
            this.Name = "EmployeeProfilesForm";
            this.Text = "EmployeeProfilesForm";
            this.panel.ResumeLayout(false);
            this.ResumeLayout(false);
            this.PerformLayout();

        }

        #endregion

        private System.Windows.Forms.Panel panel;
        private System.Windows.Forms.Button btnClose;
        private System.Windows.Forms.Button btnDelete;
        private System.Windows.Forms.Button btnInsert;
        private System.Windows.Forms.ListView listViewEmployees;
        private System.Windows.Forms.TreeView treeViewDepartment;
        private System.Windows.Forms.Label label1;
    }
}