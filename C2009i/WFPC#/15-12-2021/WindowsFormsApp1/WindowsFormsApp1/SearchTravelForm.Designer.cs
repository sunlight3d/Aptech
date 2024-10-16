
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
            this.radioButtonByType = new System.Windows.Forms.RadioButton();
            this.radioButtonByContinents = new System.Windows.Forms.RadioButton();
            this.radioButtonAllPackages = new System.Windows.Forms.RadioButton();
            this.panel1 = new System.Windows.Forms.Panel();
            this.comboBoxTravelType = new System.Windows.Forms.ComboBox();
            this.label2 = new System.Windows.Forms.Label();
            this.label3 = new System.Windows.Forms.Label();
            this.comboBoxContinents = new System.Windows.Forms.ComboBox();
            this.groupBox2 = new System.Windows.Forms.GroupBox();
            this.checkBoxPictures = new System.Windows.Forms.CheckBox();
            this.checkBoxText = new System.Windows.Forms.CheckBox();
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
            this.label1.Location = new System.Drawing.Point(437, 77);
            this.label1.Name = "label1";
            this.label1.Size = new System.Drawing.Size(425, 40);
            this.label1.TabIndex = 0;
            this.label1.Text = "Around the World Travels";
            // 
            // groupBox1
            // 
            this.groupBox1.Controls.Add(this.radioButtonAllPackages);
            this.groupBox1.Controls.Add(this.radioButtonByContinents);
            this.groupBox1.Controls.Add(this.radioButtonByType);
            this.groupBox1.Location = new System.Drawing.Point(63, 162);
            this.groupBox1.Name = "groupBox1";
            this.groupBox1.Size = new System.Drawing.Size(1189, 116);
            this.groupBox1.TabIndex = 1;
            this.groupBox1.TabStop = false;
            this.groupBox1.Text = "Search Options";
            // 
            // radioButtonByType
            // 
            this.radioButtonByType.AutoSize = true;
            this.radioButtonByType.Location = new System.Drawing.Point(93, 51);
            this.radioButtonByType.Name = "radioButtonByType";
            this.radioButtonByType.Size = new System.Drawing.Size(206, 33);
            this.radioButtonByType.TabIndex = 0;
            this.radioButtonByType.TabStop = true;
            this.radioButtonByType.Text = "By Travel Type";
            this.radioButtonByType.UseVisualStyleBackColor = true;
            // 
            // radioButtonByContinents
            // 
            this.radioButtonByContinents.AutoSize = true;
            this.radioButtonByContinents.Location = new System.Drawing.Point(487, 51);
            this.radioButtonByContinents.Name = "radioButtonByContinents";
            this.radioButtonByContinents.Size = new System.Drawing.Size(191, 33);
            this.radioButtonByContinents.TabIndex = 1;
            this.radioButtonByContinents.TabStop = true;
            this.radioButtonByContinents.Text = "By Continents";
            this.radioButtonByContinents.UseVisualStyleBackColor = true;
            // 
            // radioButtonAllPackages
            // 
            this.radioButtonAllPackages.AutoSize = true;
            this.radioButtonAllPackages.Location = new System.Drawing.Point(863, 51);
            this.radioButtonAllPackages.Name = "radioButtonAllPackages";
            this.radioButtonAllPackages.Size = new System.Drawing.Size(183, 33);
            this.radioButtonAllPackages.TabIndex = 2;
            this.radioButtonAllPackages.TabStop = true;
            this.radioButtonAllPackages.Text = "All Packages";
            this.radioButtonAllPackages.UseVisualStyleBackColor = true;
            // 
            // panel1
            // 
            this.panel1.Controls.Add(this.groupBox2);
            this.panel1.Controls.Add(this.label3);
            this.panel1.Controls.Add(this.comboBoxContinents);
            this.panel1.Controls.Add(this.label2);
            this.panel1.Controls.Add(this.comboBoxTravelType);
            this.panel1.Location = new System.Drawing.Point(63, 316);
            this.panel1.Name = "panel1";
            this.panel1.Size = new System.Drawing.Size(1189, 461);
            this.panel1.TabIndex = 2;
            // 
            // comboBoxTravelType
            // 
            this.comboBoxTravelType.FormattingEnabled = true;
            this.comboBoxTravelType.Location = new System.Drawing.Point(511, 69);
            this.comboBoxTravelType.Name = "comboBoxTravelType";
            this.comboBoxTravelType.Size = new System.Drawing.Size(273, 37);
            this.comboBoxTravelType.TabIndex = 0;
            // 
            // label2
            // 
            this.label2.AutoSize = true;
            this.label2.Font = new System.Drawing.Font("Microsoft Sans Serif", 10F, System.Drawing.FontStyle.Regular, System.Drawing.GraphicsUnit.Point, ((byte)(0)));
            this.label2.Location = new System.Drawing.Point(303, 70);
            this.label2.Name = "label2";
            this.label2.Size = new System.Drawing.Size(161, 36);
            this.label2.TabIndex = 3;
            this.label2.Text = "Travel type";
            // 
            // label3
            // 
            this.label3.AutoSize = true;
            this.label3.Font = new System.Drawing.Font("Microsoft Sans Serif", 10F, System.Drawing.FontStyle.Regular, System.Drawing.GraphicsUnit.Point, ((byte)(0)));
            this.label3.Location = new System.Drawing.Point(303, 156);
            this.label3.Name = "label3";
            this.label3.Size = new System.Drawing.Size(158, 36);
            this.label3.TabIndex = 5;
            this.label3.Text = "Continents";
            // 
            // comboBoxContinents
            // 
            this.comboBoxContinents.FormattingEnabled = true;
            this.comboBoxContinents.Location = new System.Drawing.Point(511, 155);
            this.comboBoxContinents.Name = "comboBoxContinents";
            this.comboBoxContinents.Size = new System.Drawing.Size(273, 37);
            this.comboBoxContinents.TabIndex = 4;
            // 
            // groupBox2
            // 
            this.groupBox2.Controls.Add(this.checkBoxText);
            this.groupBox2.Controls.Add(this.checkBoxPictures);
            this.groupBox2.Location = new System.Drawing.Point(152, 264);
            this.groupBox2.Name = "groupBox2";
            this.groupBox2.Size = new System.Drawing.Size(854, 150);
            this.groupBox2.TabIndex = 6;
            this.groupBox2.TabStop = false;
            this.groupBox2.Text = "View Information Options";
            // 
            // checkBoxPictures
            // 
            this.checkBoxPictures.AutoSize = true;
            this.checkBoxPictures.Location = new System.Drawing.Point(157, 65);
            this.checkBoxPictures.Name = "checkBoxPictures";
            this.checkBoxPictures.Size = new System.Drawing.Size(132, 33);
            this.checkBoxPictures.TabIndex = 0;
            this.checkBoxPictures.Text = "Pictures";
            this.checkBoxPictures.UseVisualStyleBackColor = true;
            // 
            // checkBoxText
            // 
            this.checkBoxText.AutoSize = true;
            this.checkBoxText.Location = new System.Drawing.Point(500, 65);
            this.checkBoxText.Name = "checkBoxText";
            this.checkBoxText.Size = new System.Drawing.Size(92, 33);
            this.checkBoxText.TabIndex = 1;
            this.checkBoxText.Text = "Text";
            this.checkBoxText.UseVisualStyleBackColor = true;
            // 
            // buttonView
            // 
            this.buttonView.Font = new System.Drawing.Font("Microsoft Sans Serif", 12F, System.Drawing.FontStyle.Regular, System.Drawing.GraphicsUnit.Point, ((byte)(0)));
            this.buttonView.Location = new System.Drawing.Point(530, 838);
            this.buttonView.Name = "buttonView";
            this.buttonView.Size = new System.Drawing.Size(257, 81);
            this.buttonView.TabIndex = 3;
            this.buttonView.Text = "View";
            this.buttonView.UseVisualStyleBackColor = true;
            // 
            // SearchTravelForm
            // 
            this.AutoScaleDimensions = new System.Drawing.SizeF(14F, 29F);
            this.AutoScaleMode = System.Windows.Forms.AutoScaleMode.Font;
            this.ClientSize = new System.Drawing.Size(1295, 982);
            this.Controls.Add(this.buttonView);
            this.Controls.Add(this.panel1);
            this.Controls.Add(this.groupBox1);
            this.Controls.Add(this.label1);
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