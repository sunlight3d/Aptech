
namespace WindowsFormsApp1
{
    partial class SearchTravelForm
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
            this.groupBox1 = new System.Windows.Forms.GroupBox();
            this.radioButtonAllPackages = new System.Windows.Forms.RadioButton();
            this.radioButtonByContinents = new System.Windows.Forms.RadioButton();
            this.radioButtonByType = new System.Windows.Forms.RadioButton();
            this.panel1 = new System.Windows.Forms.Panel();
            this.groupBox2 = new System.Windows.Forms.GroupBox();
            this.checkBoxText = new System.Windows.Forms.CheckBox();
            this.checkBoxPictures = new System.Windows.Forms.CheckBox();
            this.label3 = new System.Windows.Forms.Label();
            this.comboBoxContinents = new System.Windows.Forms.ComboBox();
            this.label2 = new System.Windows.Forms.Label();
            this.comboBoxTravelType = new System.Windows.Forms.ComboBox();
            this.buttonView = new System.Windows.Forms.Button();
            this.groupBox1.SuspendLayout();
            this.panel1.SuspendLayout();
            this.groupBox2.SuspendLayout();
            this.SuspendLayout();
            // 
            // label1
            // 
            this.label1.AutoSize = true;
            this.label1.Font = new System.Drawing.Font("Microsoft Sans Serif", 12F, System.Drawing.FontStyle.Regular, System.Drawing.GraphicsUnit.Point, ((byte)(0)));
            this.label1.Location = new System.Drawing.Point(281, 53);
            this.label1.Margin = new System.Windows.Forms.Padding(2, 0, 2, 0);
            this.label1.Name = "label1";
            this.label1.Size = new System.Drawing.Size(471, 46);
            this.label1.TabIndex = 0;
            this.label1.Text = "Around the World Travels";
            // 
            // groupBox1
            // 
            this.groupBox1.Controls.Add(this.radioButtonAllPackages);
            this.groupBox1.Controls.Add(this.radioButtonByContinents);
            this.groupBox1.Controls.Add(this.radioButtonByType);
            this.groupBox1.Location = new System.Drawing.Point(40, 112);
            this.groupBox1.Margin = new System.Windows.Forms.Padding(2, 2, 2, 2);
            this.groupBox1.Name = "groupBox1";
            this.groupBox1.Padding = new System.Windows.Forms.Padding(2, 2, 2, 2);
            this.groupBox1.Size = new System.Drawing.Size(764, 80);
            this.groupBox1.TabIndex = 1;
            this.groupBox1.TabStop = false;
            this.groupBox1.Text = "Search Options";
            // 
            // radioButtonAllPackages
            // 
            this.radioButtonAllPackages.AutoSize = true;
            this.radioButtonAllPackages.Location = new System.Drawing.Point(555, 35);
            this.radioButtonAllPackages.Margin = new System.Windows.Forms.Padding(2, 2, 2, 2);
            this.radioButtonAllPackages.Name = "radioButtonAllPackages";
            this.radioButtonAllPackages.Size = new System.Drawing.Size(143, 32);
            this.radioButtonAllPackages.TabIndex = 2;
            this.radioButtonAllPackages.TabStop = true;
            this.radioButtonAllPackages.Text = "All Packages";
            this.radioButtonAllPackages.UseVisualStyleBackColor = true;
            // 
            // radioButtonByContinents
            // 
            this.radioButtonByContinents.AutoSize = true;
            this.radioButtonByContinents.Location = new System.Drawing.Point(313, 35);
            this.radioButtonByContinents.Margin = new System.Windows.Forms.Padding(2, 2, 2, 2);
            this.radioButtonByContinents.Name = "radioButtonByContinents";
            this.radioButtonByContinents.Size = new System.Drawing.Size(151, 32);
            this.radioButtonByContinents.TabIndex = 1;
            this.radioButtonByContinents.TabStop = true;
            this.radioButtonByContinents.Text = "By Continents";
            this.radioButtonByContinents.UseVisualStyleBackColor = true;
            // 
            // radioButtonByType
            // 
            this.radioButtonByType.AutoSize = true;
            this.radioButtonByType.Location = new System.Drawing.Point(60, 35);
            this.radioButtonByType.Margin = new System.Windows.Forms.Padding(2, 2, 2, 2);
            this.radioButtonByType.Name = "radioButtonByType";
            this.radioButtonByType.Size = new System.Drawing.Size(158, 32);
            this.radioButtonByType.TabIndex = 0;
            this.radioButtonByType.TabStop = true;
            this.radioButtonByType.Text = "By Travel Type";
            this.radioButtonByType.UseVisualStyleBackColor = true;
            // 
            // panel1
            // 
            this.panel1.Controls.Add(this.groupBox2);
            this.panel1.Controls.Add(this.label3);
            this.panel1.Controls.Add(this.comboBoxContinents);
            this.panel1.Controls.Add(this.label2);
            this.panel1.Controls.Add(this.comboBoxTravelType);
            this.panel1.Location = new System.Drawing.Point(40, 218);
            this.panel1.Margin = new System.Windows.Forms.Padding(2, 2, 2, 2);
            this.panel1.Name = "panel1";
            this.panel1.Size = new System.Drawing.Size(764, 318);
            this.panel1.TabIndex = 2;
            // 
            // groupBox2
            // 
            this.groupBox2.Controls.Add(this.checkBoxText);
            this.groupBox2.Controls.Add(this.checkBoxPictures);
            this.groupBox2.Location = new System.Drawing.Point(98, 182);
            this.groupBox2.Margin = new System.Windows.Forms.Padding(2, 2, 2, 2);
            this.groupBox2.Name = "groupBox2";
            this.groupBox2.Padding = new System.Windows.Forms.Padding(2, 2, 2, 2);
            this.groupBox2.Size = new System.Drawing.Size(549, 103);
            this.groupBox2.TabIndex = 6;
            this.groupBox2.TabStop = false;
            this.groupBox2.Text = "View Information Options";
            // 
            // checkBoxText
            // 
            this.checkBoxText.AutoSize = true;
            this.checkBoxText.Location = new System.Drawing.Point(321, 45);
            this.checkBoxText.Margin = new System.Windows.Forms.Padding(2, 2, 2, 2);
            this.checkBoxText.Name = "checkBoxText";
            this.checkBoxText.Size = new System.Drawing.Size(79, 33);
            this.checkBoxText.TabIndex = 1;
            this.checkBoxText.Text = "Text";
            this.checkBoxText.UseVisualStyleBackColor = true;
            // 
            // checkBoxPictures
            // 
            this.checkBoxPictures.AutoSize = true;
            this.checkBoxPictures.Location = new System.Drawing.Point(101, 45);
            this.checkBoxPictures.Margin = new System.Windows.Forms.Padding(2, 2, 2, 2);
            this.checkBoxPictures.Name = "checkBoxPictures";
            this.checkBoxPictures.Size = new System.Drawing.Size(109, 33);
            this.checkBoxPictures.TabIndex = 0;
            this.checkBoxPictures.Text = "Pictures";
            this.checkBoxPictures.UseVisualStyleBackColor = true;
            // 
            // label3
            // 
            this.label3.AutoSize = true;
            this.label3.Font = new System.Drawing.Font("Microsoft Sans Serif", 10F, System.Drawing.FontStyle.Regular, System.Drawing.GraphicsUnit.Point, ((byte)(0)));
            this.label3.Location = new System.Drawing.Point(195, 108);
            this.label3.Margin = new System.Windows.Forms.Padding(2, 0, 2, 0);
            this.label3.Name = "label3";
            this.label3.Size = new System.Drawing.Size(180, 39);
            this.label3.TabIndex = 5;
            this.label3.Text = "Continents";
            // 
            // comboBoxContinents
            // 
            this.comboBoxContinents.FormattingEnabled = true;
            this.comboBoxContinents.Location = new System.Drawing.Point(328, 107);
            this.comboBoxContinents.Margin = new System.Windows.Forms.Padding(2, 2, 2, 2);
            this.comboBoxContinents.Name = "comboBoxContinents";
            this.comboBoxContinents.Size = new System.Drawing.Size(177, 28);
            this.comboBoxContinents.TabIndex = 4;
            // 
            // label2
            // 
            this.label2.AutoSize = true;
            this.label2.Font = new System.Drawing.Font("Microsoft Sans Serif", 10F, System.Drawing.FontStyle.Regular, System.Drawing.GraphicsUnit.Point, ((byte)(0)));
            this.label2.Location = new System.Drawing.Point(195, 48);
            this.label2.Margin = new System.Windows.Forms.Padding(2, 0, 2, 0);
            this.label2.Name = "label2";
            this.label2.Size = new System.Drawing.Size(185, 39);
            this.label2.TabIndex = 3;
            this.label2.Text = "Travel type";
            // 
            // comboBoxTravelType
            // 
            this.comboBoxTravelType.FormattingEnabled = true;
            this.comboBoxTravelType.Location = new System.Drawing.Point(328, 48);
            this.comboBoxTravelType.Margin = new System.Windows.Forms.Padding(2, 2, 2, 2);
            this.comboBoxTravelType.Name = "comboBoxTravelType";
            this.comboBoxTravelType.Size = new System.Drawing.Size(177, 28);
            this.comboBoxTravelType.TabIndex = 0;
            // 
            // buttonView
            // 
            this.buttonView.Font = new System.Drawing.Font("Microsoft Sans Serif", 12F, System.Drawing.FontStyle.Regular, System.Drawing.GraphicsUnit.Point, ((byte)(0)));
            this.buttonView.Location = new System.Drawing.Point(341, 578);
            this.buttonView.Margin = new System.Windows.Forms.Padding(2, 2, 2, 2);
            this.buttonView.Name = "buttonView";
            this.buttonView.Size = new System.Drawing.Size(165, 56);
            this.buttonView.TabIndex = 3;
            this.buttonView.Text = "View";
            this.buttonView.UseVisualStyleBackColor = true;
            this.buttonView.Click += new System.EventHandler(this.buttonView_Click);
            // 
            // SearchTravelForm
            // 
            this.AutoScaleDimensions = new System.Drawing.SizeF(9F, 20F);
            this.AutoScaleMode = System.Windows.Forms.AutoScaleMode.Font;
            this.ClientSize = new System.Drawing.Size(832, 677);
            this.Controls.Add(this.buttonView);
            this.Controls.Add(this.panel1);
            this.Controls.Add(this.groupBox1);
            this.Controls.Add(this.label1);
            this.Margin = new System.Windows.Forms.Padding(2, 2, 2, 2);
            this.Name = "SearchTravelForm";
            this.Text = "SearchTravelForm";
            this.groupBox1.ResumeLayout(false);
            this.groupBox1.PerformLayout();
            this.panel1.ResumeLayout(false);
            this.panel1.PerformLayout();
            this.groupBox2.ResumeLayout(false);
            this.groupBox2.PerformLayout();
            this.ResumeLayout(false);
            this.PerformLayout();

        }

        #endregion

        private System.Windows.Forms.Label label1;
        private System.Windows.Forms.GroupBox groupBox1;
        private System.Windows.Forms.RadioButton radioButtonAllPackages;
        private System.Windows.Forms.RadioButton radioButtonByContinents;
        private System.Windows.Forms.RadioButton radioButtonByType;
        private System.Windows.Forms.Panel panel1;
        private System.Windows.Forms.Label label3;
        private System.Windows.Forms.ComboBox comboBoxContinents;
        private System.Windows.Forms.Label label2;
        private System.Windows.Forms.ComboBox comboBoxTravelType;
        private System.Windows.Forms.GroupBox groupBox2;
        private System.Windows.Forms.CheckBox checkBoxText;
        private System.Windows.Forms.CheckBox checkBoxPictures;
        private System.Windows.Forms.Button buttonView;
    }
}