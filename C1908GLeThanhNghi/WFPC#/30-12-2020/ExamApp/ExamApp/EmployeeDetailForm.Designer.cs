using System.Windows.Forms;
namespace ExamApp
{
    partial class EmployeeDetailForm
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
            this.label2 = new System.Windows.Forms.Label();
            this.groupBox1 = new System.Windows.Forms.GroupBox();
            this.textBoxAddress = new System.Windows.Forms.TextBox();
            this.label7 = new System.Windows.Forms.Label();
            this.textBoxTeplephone = new System.Windows.Forms.TextBox();
            this.label6 = new System.Windows.Forms.Label();
            this.label5 = new System.Windows.Forms.Label();
            this.radioButtonGenderFemale = new System.Windows.Forms.RadioButton();
            this.label4 = new System.Windows.Forms.Label();
            this.label3 = new System.Windows.Forms.Label();
            this.radioButtonGenderMale = new System.Windows.Forms.RadioButton();
            this.textBoxEmployeeName = new System.Windows.Forms.TextBox();
            this.comboBoxDepartment = new System.Windows.Forms.ComboBox();
            this.buttonAddNew = new System.Windows.Forms.Button();
            this.buttonCancel = new System.Windows.Forms.Button();
            dateTimePickerBirthDate = new System.Windows.Forms.DateTimePicker();
            this.groupBox1.SuspendLayout();
            this.SuspendLayout();
            // 
            // label1
            // 
            this.label1.AutoSize = true;
            this.label1.Font = new System.Drawing.Font("Microsoft Sans Serif", 14F, System.Drawing.FontStyle.Bold, System.Drawing.GraphicsUnit.Point, ((byte)(0)));
            this.label1.Location = new System.Drawing.Point(147, 110);
            this.label1.Name = "label1";
            this.label1.Size = new System.Drawing.Size(377, 54);
            this.label1.TabIndex = 0;
            this.label1.Text = "Employee Detail";
            // 
            // label2
            // 
            this.label2.AutoSize = true;
            this.label2.Location = new System.Drawing.Point(42, 60);
            this.label2.Name = "label2";
            this.label2.Size = new System.Drawing.Size(224, 32);
            this.label2.TabIndex = 1;
            this.label2.Text = "Employee Name";
            // 
            // groupBox1
            // 
            this.groupBox1.Controls.Add(this.textBoxAddress);
            this.groupBox1.Controls.Add(this.label7);
            this.groupBox1.Controls.Add(this.textBoxTeplephone);
            this.groupBox1.Controls.Add(this.label6);
            this.groupBox1.Controls.Add(this.label5);
            this.groupBox1.Controls.Add(dateTimePickerBirthDate);
            this.groupBox1.Controls.Add(this.radioButtonGenderFemale);
            this.groupBox1.Controls.Add(this.label4);
            this.groupBox1.Controls.Add(this.label3);
            this.groupBox1.Controls.Add(this.radioButtonGenderMale);
            this.groupBox1.Controls.Add(this.label2);
            this.groupBox1.Controls.Add(this.textBoxEmployeeName);
            this.groupBox1.Controls.Add(this.comboBoxDepartment);
            this.groupBox1.Location = new System.Drawing.Point(96, 198);
            this.groupBox1.Name = "groupBox1";
            this.groupBox1.Size = new System.Drawing.Size(1419, 678);
            this.groupBox1.TabIndex = 2;
            this.groupBox1.TabStop = false;
            this.groupBox1.Enter += new System.EventHandler(this.groupBox1_Enter);
            // 
            // textBoxAddress
            // 
            this.textBoxAddress.Location = new System.Drawing.Point(910, 293);
            this.textBoxAddress.Multiline = true;
            this.textBoxAddress.Name = "textBoxAddress";
            this.textBoxAddress.Size = new System.Drawing.Size(375, 346);
            this.textBoxAddress.TabIndex = 11;
            this.textBoxAddress.TextChanged += new System.EventHandler(this.textBoxAddress_TextChanged);
            // 
            // label7
            // 
            this.label7.AutoSize = true;
            this.label7.Location = new System.Drawing.Point(730, 296);
            this.label7.Name = "label7";
            this.label7.Size = new System.Drawing.Size(119, 32);
            this.label7.TabIndex = 10;
            this.label7.Text = "Address";
            // 
            // textBoxTeplephone
            // 
            this.textBoxTeplephone.Location = new System.Drawing.Point(911, 167);
            this.textBoxTeplephone.Name = "textBoxTeplephone";
            this.textBoxTeplephone.Size = new System.Drawing.Size(339, 38);
            this.textBoxTeplephone.TabIndex = 9;
            this.textBoxTeplephone.TextChanged += new System.EventHandler(this.textBoxTeplephone_TextChanged);
            // 
            // label6
            // 
            this.label6.AutoSize = true;
            this.label6.Location = new System.Drawing.Point(730, 174);
            this.label6.Name = "label6";
            this.label6.Size = new System.Drawing.Size(55, 32);
            this.label6.TabIndex = 8;
            this.label6.Text = "Tel";
            // 
            // label5
            // 
            this.label5.AutoSize = true;
            this.label5.Location = new System.Drawing.Point(730, 60);
            this.label5.Name = "label5";
            this.label5.Size = new System.Drawing.Size(137, 32);
            this.label5.TabIndex = 7;
            this.label5.Text = "Birth date";
            // 
            // dateTimePickerBirthDate
            // 
            dateTimePickerBirthDate.CustomFormat = "dd/MM/yyyy";
            dateTimePickerBirthDate.Format = System.Windows.Forms.DateTimePickerFormat.Custom;
            dateTimePickerBirthDate.Location = new System.Drawing.Point(911, 54);
            dateTimePickerBirthDate.Name = "dateTimePickerBirthDate";
            dateTimePickerBirthDate.Size = new System.Drawing.Size(362, 38);
            dateTimePickerBirthDate.TabIndex = 6;
            // 
            // radioButtonGenderFemale
            // 
            this.radioButtonGenderFemale.AutoSize = true;
            this.radioButtonGenderFemale.Location = new System.Drawing.Point(407, 296);
            this.radioButtonGenderFemale.Name = "radioButtonGenderFemale";
            this.radioButtonGenderFemale.Size = new System.Drawing.Size(147, 36);
            this.radioButtonGenderFemale.TabIndex = 6;
            this.radioButtonGenderFemale.TabStop = true;
            this.radioButtonGenderFemale.Text = "Female";
            this.radioButtonGenderFemale.UseVisualStyleBackColor = true;
            // 
            // label4
            // 
            this.label4.AutoSize = true;
            this.label4.Location = new System.Drawing.Point(44, 296);
            this.label4.Name = "label4";
            this.label4.Size = new System.Drawing.Size(110, 32);
            this.label4.TabIndex = 5;
            this.label4.Text = "Gender";
            // 
            // label3
            // 
            this.label3.AutoSize = true;
            this.label3.Location = new System.Drawing.Point(42, 174);
            this.label3.Name = "label3";
            this.label3.Size = new System.Drawing.Size(163, 32);
            this.label3.TabIndex = 4;
            this.label3.Text = "Department";
            // 
            // radioButtonGenderMale
            // 
            this.radioButtonGenderMale.AutoSize = true;
            this.radioButtonGenderMale.Location = new System.Drawing.Point(220, 296);
            this.radioButtonGenderMale.Name = "radioButtonGenderMale";
            this.radioButtonGenderMale.Size = new System.Drawing.Size(114, 36);
            this.radioButtonGenderMale.TabIndex = 5;
            this.radioButtonGenderMale.TabStop = true;
            this.radioButtonGenderMale.Text = "Male";
            this.radioButtonGenderMale.UseVisualStyleBackColor = true;
            // 
            // textBoxEmployeeName
            // 
            this.textBoxEmployeeName.Location = new System.Drawing.Point(306, 60);
            this.textBoxEmployeeName.Name = "textBoxEmployeeName";
            this.textBoxEmployeeName.Size = new System.Drawing.Size(339, 38);
            this.textBoxEmployeeName.TabIndex = 3;
            // 
            // comboBoxDepartment
            // 
            this.comboBoxDepartment.FormattingEnabled = true;
            this.comboBoxDepartment.Location = new System.Drawing.Point(306, 167);
            this.comboBoxDepartment.Name = "comboBoxDepartment";
            this.comboBoxDepartment.Size = new System.Drawing.Size(339, 39);
            this.comboBoxDepartment.TabIndex = 4;
            this.comboBoxDepartment.SelectedIndexChanged += new System.EventHandler(this.comboBoxDepartment_SelectedIndexChanged);
            // 
            // buttonAddNew
            // 
            this.buttonAddNew.Location = new System.Drawing.Point(402, 912);
            this.buttonAddNew.Name = "buttonAddNew";
            this.buttonAddNew.Size = new System.Drawing.Size(209, 86);
            this.buttonAddNew.TabIndex = 7;
            this.buttonAddNew.Text = "AddNew";
            this.buttonAddNew.UseVisualStyleBackColor = true;
            this.buttonAddNew.Click += new System.EventHandler(this.buttonAddNew_Click);
            // 
            // buttonCancel
            // 
            this.buttonCancel.Location = new System.Drawing.Point(925, 912);
            this.buttonCancel.Name = "buttonCancel";
            this.buttonCancel.Size = new System.Drawing.Size(209, 86);
            this.buttonCancel.TabIndex = 8;
            this.buttonCancel.Text = "Cancel";
            this.buttonCancel.UseVisualStyleBackColor = true;
            // 
            // EmployeeDetailForm
            // 
            this.AutoScaleDimensions = new System.Drawing.SizeF(16F, 31F);
            this.AutoScaleMode = System.Windows.Forms.AutoScaleMode.Font;
            this.AutoSize = true;
            this.ClientSize = new System.Drawing.Size(1592, 1027);
            this.Controls.Add(this.buttonCancel);
            this.Controls.Add(this.buttonAddNew);
            this.Controls.Add(this.groupBox1);
            this.Controls.Add(this.label1);
            this.Name = "EmployeeDetailForm";
            this.Text = "EmployeeDetailForm";
            this.groupBox1.ResumeLayout(false);
            this.groupBox1.PerformLayout();
            this.ResumeLayout(false);
            this.PerformLayout();

        }

        #endregion
        private System.Windows.Forms.Label label1;
        private System.Windows.Forms.Label label2;
        private System.Windows.Forms.GroupBox groupBox1;
        private System.Windows.Forms.TextBox textBoxEmployeeName;
        private System.Windows.Forms.ComboBox comboBoxDepartment;
        private System.Windows.Forms.RadioButton radioButtonGenderMale;
        private System.Windows.Forms.Button buttonAddNew;
        private System.Windows.Forms.Label label3;
        private System.Windows.Forms.Label label4;
        private System.Windows.Forms.RadioButton radioButtonGenderFemale;
        private System.Windows.Forms.Label label5;
        private System.Windows.Forms.TextBox textBoxAddress;
        private System.Windows.Forms.Label label7;
        private System.Windows.Forms.TextBox textBoxTeplephone;
        private System.Windows.Forms.Label label6;
        private System.Windows.Forms.Button buttonCancel;
        System.Windows.Forms.DateTimePicker dateTimePickerBirthDate;
    }
}

