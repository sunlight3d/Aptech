
namespace WindowsFormsApp1.Forms
{
    partial class TravelListForm
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
            this.label1 = new System.Windows.Forms.Label();
            this.listViewTravels = new System.Windows.Forms.ListView();
            this.treeViewCategory = new System.Windows.Forms.TreeView();
            this.SuspendLayout();
            // 
            // label1
            // 
            this.label1.AutoSize = true;
            this.label1.Font = new System.Drawing.Font("Microsoft Sans Serif", 12F, System.Drawing.FontStyle.Regular, System.Drawing.GraphicsUnit.Point, ((byte)(0)));
            this.label1.Location = new System.Drawing.Point(395, 69);
            this.label1.Name = "label1";
            this.label1.Size = new System.Drawing.Size(267, 46);
            this.label1.TabIndex = 0;
            this.label1.Text = "List of Travels";
            // 
            // listViewTravels
            // 
            this.listViewTravels.HideSelection = false;
            this.listViewTravels.Location = new System.Drawing.Point(337, 148);
            this.listViewTravels.Name = "listViewTravels";
            this.listViewTravels.Size = new System.Drawing.Size(732, 538);
            this.listViewTravels.TabIndex = 1;
            this.listViewTravels.UseCompatibleStateImageBehavior = false;
            this.listViewTravels.View = System.Windows.Forms.View.Details;
            // 
            // treeViewCategory
            // 
            this.treeViewCategory.Location = new System.Drawing.Point(12, 148);
            this.treeViewCategory.Name = "treeViewCategory";
            this.treeViewCategory.Size = new System.Drawing.Size(305, 538);
            this.treeViewCategory.TabIndex = 2;
            // 
            // TravelListForm
            // 
            this.AutoScaleDimensions = new System.Drawing.SizeF(9F, 20F);
            this.AutoScaleMode = System.Windows.Forms.AutoScaleMode.Font;
            this.ClientSize = new System.Drawing.Size(1123, 761);
            this.Controls.Add(this.treeViewCategory);
            this.Controls.Add(this.listViewTravels);
            this.Controls.Add(this.label1);
            this.Name = "TravelListForm";
            this.Text = "TravelListForm";
            this.ResumeLayout(false);
            this.PerformLayout();

        }

        #endregion

        private System.Windows.Forms.Label label1;
        private System.Windows.Forms.ListView listViewTravels;
        private System.Windows.Forms.TreeView treeViewCategory;
    }
}