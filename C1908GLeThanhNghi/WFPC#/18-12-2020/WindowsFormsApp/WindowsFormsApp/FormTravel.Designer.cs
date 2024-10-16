namespace WindowsFormsApp
{
    partial class FormTravel
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
            this.radioByTravelType = new System.Windows.Forms.RadioButton();
            this.radioByContinents = new System.Windows.Forms.RadioButton();
            this.radioAllPackages = new System.Windows.Forms.RadioButton();
            this.panel1 = new System.Windows.Forms.Panel();
            this.label2 = new System.Windows.Forms.Label();
            this.label3 = new System.Windows.Forms.Label();
            this.comboBoxTravelType = new System.Windows.Forms.ComboBox();
            this.comboBoxContinents = new System.Windows.Forms.ComboBox();
            this.groupBox2 = new System.Windows.Forms.GroupBox();
            this.checkBox1 = new System.Windows.Forms.CheckBox();
            this.checkBox2 = new System.Windows.Forms.CheckBox();
            this.button1 = new System.Windows.Forms.Button();
            this.groupBox1.SuspendLayout();
            this.panel1.SuspendLayout();
            this.groupBox2.SuspendLayout();
            this.SuspendLayout();
            // 
            // label1
            // 
            this.label1.AutoSize = true;
            this.label1.Font = new System.Drawing.Font("Microsoft New Tai Lue", 11F, System.Drawing.FontStyle.Regular, System.Drawing.GraphicsUnit.Point, ((byte)(0)));
            this.label1.Location = new System.Drawing.Point(385, 68);
            this.label1.Name = "label1";
            this.label1.Size = new System.Drawing.Size(432, 48);
            this.label1.TabIndex = 0;
            this.label1.Text = "Around the world Travels";
            // 
            // groupBox1
            // 
            this.groupBox1.Controls.Add(this.radioAllPackages);
            this.groupBox1.Controls.Add(this.radioByContinents);
            this.groupBox1.Controls.Add(this.radioByTravelType);
            this.groupBox1.Location = new System.Drawing.Point(96, 163);
            this.groupBox1.Name = "groupBox1";
            this.groupBox1.Size = new System.Drawing.Size(1117, 142);
            this.groupBox1.TabIndex = 1;
            this.groupBox1.TabStop = false;
            this.groupBox1.Text = "Search options";
            // 
            // radioByTravelType
            // 
            this.radioByTravelType.AutoSize = true;
            this.radioByTravelType.Location = new System.Drawing.Point(59, 50);
            this.radioByTravelType.Name = "radioByTravelType";
            this.radioByTravelType.Size = new System.Drawing.Size(241, 36);
            this.radioByTravelType.TabIndex = 2;
            this.radioByTravelType.TabStop = true;
            this.radioByTravelType.Text = "By Travel Type";
            this.radioByTravelType.UseVisualStyleBackColor = true;
            // 
            // radioByContinents
            // 
            this.radioByContinents.AutoSize = true;
            this.radioByContinents.Location = new System.Drawing.Point(467, 50);
            this.radioByContinents.Name = "radioByContinents";
            this.radioByContinents.Size = new System.Drawing.Size(229, 36);
            this.radioByContinents.TabIndex = 3;
            this.radioByContinents.TabStop = true;
            this.radioByContinents.Text = "By Continents";
            this.radioByContinents.UseVisualStyleBackColor = true;
            // 
            // radioAllPackages
            // 
            this.radioAllPackages.AutoSize = true;
            this.radioAllPackages.Location = new System.Drawing.Point(848, 50);
            this.radioAllPackages.Name = "radioAllPackages";
            this.radioAllPackages.Size = new System.Drawing.Size(214, 36);
            this.radioAllPackages.TabIndex = 4;
            this.radioAllPackages.TabStop = true;
            this.radioAllPackages.Text = "All packages";
            this.radioAllPackages.UseVisualStyleBackColor = true;
            // 
            // panel1
            // 
            this.panel1.Controls.Add(this.groupBox2);
            this.panel1.Controls.Add(this.comboBoxContinents);
            this.panel1.Controls.Add(this.comboBoxTravelType);
            this.panel1.Controls.Add(this.label3);
            this.panel1.Controls.Add(this.label2);
            this.panel1.Location = new System.Drawing.Point(96, 404);
            this.panel1.Name = "panel1";
            this.panel1.Size = new System.Drawing.Size(1286, 408);
            this.panel1.TabIndex = 2;
            // 
            // label2
            // 
            this.label2.AutoSize = true;
            this.label2.Font = new System.Drawing.Font("Microsoft New Tai Lue", 11F, System.Drawing.FontStyle.Regular, System.Drawing.GraphicsUnit.Point, ((byte)(0)));
            this.label2.Location = new System.Drawing.Point(51, 42);
            this.label2.Name = "label2";
            this.label2.Size = new System.Drawing.Size(205, 48);
            this.label2.TabIndex = 3;
            this.label2.Text = "Travel Type";
            // 
            // label3
            // 
            this.label3.AutoSize = true;
            this.label3.Font = new System.Drawing.Font("Microsoft New Tai Lue", 11F, System.Drawing.FontStyle.Regular, System.Drawing.GraphicsUnit.Point, ((byte)(0)));
            this.label3.Location = new System.Drawing.Point(51, 162);
            this.label3.Name = "label3";
            this.label3.Size = new System.Drawing.Size(198, 48);
            this.label3.TabIndex = 4;
            this.label3.Text = "Continents";
            // 
            // comboBoxTravelType
            // 
            this.comboBoxTravelType.FormattingEnabled = true;
            this.comboBoxTravelType.Location = new System.Drawing.Point(334, 42);
            this.comboBoxTravelType.Name = "comboBoxTravelType";
            this.comboBoxTravelType.Size = new System.Drawing.Size(333, 39);
            this.comboBoxTravelType.TabIndex = 5;
            // 
            // comboBoxContinents
            // 
            this.comboBoxContinents.FormattingEnabled = true;
            this.comboBoxContinents.Location = new System.Drawing.Point(334, 171);
            this.comboBoxContinents.Name = "comboBoxContinents";
            this.comboBoxContinents.Size = new System.Drawing.Size(333, 39);
            this.comboBoxContinents.TabIndex = 6;
            // 
            // groupBox2
            // 
            this.groupBox2.Controls.Add(this.checkBox2);
            this.groupBox2.Controls.Add(this.checkBox1);
            this.groupBox2.Location = new System.Drawing.Point(59, 262);
            this.groupBox2.Name = "groupBox2";
            this.groupBox2.Size = new System.Drawing.Size(1117, 142);
            this.groupBox2.TabIndex = 5;
            this.groupBox2.TabStop = false;
            this.groupBox2.Text = "View information options";
            // 
            // checkBox1
            // 
            this.checkBox1.AutoSize = true;
            this.checkBox1.Location = new System.Drawing.Point(58, 69);
            this.checkBox1.Name = "checkBox1";
            this.checkBox1.Size = new System.Drawing.Size(142, 36);
            this.checkBox1.TabIndex = 0;
            this.checkBox1.Text = "Picture";
            this.checkBox1.UseVisualStyleBackColor = true;
            // 
            // checkBox2
            // 
            this.checkBox2.AutoSize = true;
            this.checkBox2.Location = new System.Drawing.Point(536, 69);
            this.checkBox2.Name = "checkBox2";
            this.checkBox2.Size = new System.Drawing.Size(108, 36);
            this.checkBox2.TabIndex = 7;
            this.checkBox2.Text = "Text";
            this.checkBox2.UseVisualStyleBackColor = true;
            // 
            // button1
            // 
            this.button1.Location = new System.Drawing.Point(653, 861);
            this.button1.Name = "button1";
            this.button1.Size = new System.Drawing.Size(242, 93);
            this.button1.TabIndex = 8;
            this.button1.Text = "View";
            this.button1.UseVisualStyleBackColor = true;
            this.button1.Click += new System.EventHandler(this.button1_Click);
            // 
            // FormTravel
            // 
            this.AutoScaleDimensions = new System.Drawing.SizeF(16F, 31F);
            this.AutoScaleMode = System.Windows.Forms.AutoScaleMode.Font;
            this.AutoSize = true;
            this.ClientSize = new System.Drawing.Size(1514, 998);
            this.Controls.Add(this.button1);
            this.Controls.Add(this.panel1);
            this.Controls.Add(this.groupBox1);
            this.Controls.Add(this.label1);
            this.Name = "FormTravel";
            this.Text = "FormTravel";
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
        private System.Windows.Forms.RadioButton radioAllPackages;
        private System.Windows.Forms.RadioButton radioByContinents;
        private System.Windows.Forms.RadioButton radioByTravelType;
        private System.Windows.Forms.Panel panel1;
        private System.Windows.Forms.GroupBox groupBox2;
        private System.Windows.Forms.CheckBox checkBox2;
        private System.Windows.Forms.CheckBox checkBox1;
        private System.Windows.Forms.ComboBox comboBoxContinents;
        private System.Windows.Forms.ComboBox comboBoxTravelType;
        private System.Windows.Forms.Label label3;
        private System.Windows.Forms.Label label2;
        private System.Windows.Forms.Button button1;
    }
}

