namespace AptechWFC
{
    partial class MainScreen
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
            this.txtSearch = new System.Windows.Forms.TextBox();
            this.label1 = new System.Windows.Forms.Label();
            this.btnAddName = new System.Windows.Forms.Button();
            this.listBoxNames = new System.Windows.Forms.ListBox();
            this.btnShowSecondScreen = new System.Windows.Forms.Button();
            this.SuspendLayout();
            // 
            // txtSearch
            // 
            this.txtSearch.Location = new System.Drawing.Point(573, 139);
            this.txtSearch.Name = "txtSearch";
            this.txtSearch.Size = new System.Drawing.Size(310, 38);
            this.txtSearch.TabIndex = 0;
            // 
            // label1
            // 
            this.label1.AutoSize = true;
            this.label1.Location = new System.Drawing.Point(58, 61);
            this.label1.Name = "label1";
            this.label1.Size = new System.Drawing.Size(104, 32);
            this.label1.TabIndex = 1;
            this.label1.Text = "Names";
            // 
            // btnAddName
            // 
            this.btnAddName.Location = new System.Drawing.Point(574, 207);
            this.btnAddName.Name = "btnAddName";
            this.btnAddName.Size = new System.Drawing.Size(309, 71);
            this.btnAddName.TabIndex = 2;
            this.btnAddName.Text = "Add Name";
            this.btnAddName.UseVisualStyleBackColor = true;
            this.btnAddName.Click += new System.EventHandler(this.btnAddName_Click);
            // 
            // listBoxNames
            // 
            this.listBoxNames.FormattingEnabled = true;
            this.listBoxNames.ItemHeight = 31;
            this.listBoxNames.Location = new System.Drawing.Point(64, 139);
            this.listBoxNames.Name = "listBoxNames";
            this.listBoxNames.Size = new System.Drawing.Size(456, 345);
            this.listBoxNames.TabIndex = 3;
            // 
            // btnShowSecondScreen
            // 
            this.btnShowSecondScreen.Location = new System.Drawing.Point(603, 871);
            this.btnShowSecondScreen.Margin = new System.Windows.Forms.Padding(3, 3, 3, 20);
            this.btnShowSecondScreen.Name = "btnShowSecondScreen";
            this.btnShowSecondScreen.Size = new System.Drawing.Size(309, 71);
            this.btnShowSecondScreen.TabIndex = 4;
            this.btnShowSecondScreen.Text = "Show second screen";
            this.btnShowSecondScreen.UseVisualStyleBackColor = true;
            this.btnShowSecondScreen.Click += new System.EventHandler(this.btnShowSecondScreen_Click);
            // 
            // MainScreen
            // 
            this.AutoScaleDimensions = new System.Drawing.SizeF(16F, 31F);
            this.AutoScaleMode = System.Windows.Forms.AutoScaleMode.Font;
            this.AutoSize = true;
            this.BackColor = System.Drawing.Color.Azure;
            this.ClientSize = new System.Drawing.Size(1555, 992);
            this.Controls.Add(this.btnShowSecondScreen);
            this.Controls.Add(this.listBoxNames);
            this.Controls.Add(this.btnAddName);
            this.Controls.Add(this.label1);
            this.Controls.Add(this.txtSearch);
            this.Name = "MainScreen";
            this.Text = "Main Screen";
            this.ResumeLayout(false);
            this.PerformLayout();

        }

        #endregion

        private System.Windows.Forms.TextBox txtSearch;
        private System.Windows.Forms.Label label1;
        private System.Windows.Forms.Button btnAddName;
        private System.Windows.Forms.ListBox listBoxNames;
        private System.Windows.Forms.Button btnShowSecondScreen;
    }
}

