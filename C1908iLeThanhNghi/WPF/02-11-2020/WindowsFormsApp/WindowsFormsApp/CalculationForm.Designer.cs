namespace WindowsFormsApp
{
    partial class CalculationForm
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
            this.components = new System.ComponentModel.Container();
            this.labelTimer = new System.Windows.Forms.Label();
            this.label2 = new System.Windows.Forms.Label();
            this.numericUpDownSum = new System.Windows.Forms.NumericUpDown();
            this.txtX = new System.Windows.Forms.Label();
            this.txtY = new System.Windows.Forms.Label();
            this.label5 = new System.Windows.Forms.Label();
            this.label6 = new System.Windows.Forms.Label();
            this.btnStart = new System.Windows.Forms.Button();
            this.timer = new System.Windows.Forms.Timer(this.components);
            ((System.ComponentModel.ISupportInitialize)(this.numericUpDownSum)).BeginInit();
            this.SuspendLayout();
            // 
            // labelTimer
            // 
            this.labelTimer.BorderStyle = System.Windows.Forms.BorderStyle.FixedSingle;
            this.labelTimer.Location = new System.Drawing.Point(871, 225);
            this.labelTimer.Name = "labelTimer";
            this.labelTimer.Size = new System.Drawing.Size(200, 30);
            this.labelTimer.TabIndex = 0;
            // 
            // label2
            // 
            this.label2.BorderStyle = System.Windows.Forms.BorderStyle.FixedSingle;
            this.label2.Font = new System.Drawing.Font("Microsoft Sans Serif", 15.9F, System.Drawing.FontStyle.Regular, System.Drawing.GraphicsUnit.Point, ((byte)(0)));
            this.label2.Location = new System.Drawing.Point(488, 202);
            this.label2.Name = "label2";
            this.label2.Size = new System.Drawing.Size(316, 71);
            this.label2.TabIndex = 1;
            this.label2.Text = "Time Left";
            // 
            // numericUpDownSum
            // 
            this.numericUpDownSum.Location = new System.Drawing.Point(959, 349);
            this.numericUpDownSum.Name = "numericUpDownSum";
            this.numericUpDownSum.Size = new System.Drawing.Size(120, 38);
            this.numericUpDownSum.TabIndex = 2;
            // 
            // txtX
            // 
            this.txtX.BorderStyle = System.Windows.Forms.BorderStyle.FixedSingle;
            this.txtX.Location = new System.Drawing.Point(430, 350);
            this.txtX.Name = "txtX";
            this.txtX.Size = new System.Drawing.Size(80, 47);
            this.txtX.TabIndex = 3;
            this.txtX.Text = "?";
            // 
            // txtY
            // 
            this.txtY.BorderStyle = System.Windows.Forms.BorderStyle.FixedSingle;
            this.txtY.Location = new System.Drawing.Point(676, 350);
            this.txtY.Name = "txtY";
            this.txtY.Size = new System.Drawing.Size(80, 47);
            this.txtY.TabIndex = 4;
            this.txtY.Text = "?";
            // 
            // label5
            // 
            this.label5.BorderStyle = System.Windows.Forms.BorderStyle.FixedSingle;
            this.label5.Location = new System.Drawing.Point(561, 350);
            this.label5.Name = "label5";
            this.label5.Size = new System.Drawing.Size(80, 47);
            this.label5.TabIndex = 5;
            this.label5.Text = "+";
            // 
            // label6
            // 
            this.label6.BorderStyle = System.Windows.Forms.BorderStyle.FixedSingle;
            this.label6.Location = new System.Drawing.Point(817, 350);
            this.label6.Name = "label6";
            this.label6.Size = new System.Drawing.Size(80, 47);
            this.label6.TabIndex = 6;
            this.label6.Text = "=";
            // 
            // btnStart
            // 
            this.btnStart.Location = new System.Drawing.Point(632, 501);
            this.btnStart.Name = "btnStart";
            this.btnStart.Size = new System.Drawing.Size(253, 111);
            this.btnStart.TabIndex = 7;
            this.btnStart.Text = "Start the Quiz";
            this.btnStart.UseVisualStyleBackColor = true;
            this.btnStart.Click += new System.EventHandler(this.btnStart_Click);
            // 
            // timer
            // 
            this.timer.Interval = 1000;
            this.timer.Tick += new System.EventHandler(this.timer_Tick);
            // 
            // CalculationForm
            // 
            this.AutoScaleDimensions = new System.Drawing.SizeF(16F, 31F);
            this.AutoScaleMode = System.Windows.Forms.AutoScaleMode.Font;
            this.ClientSize = new System.Drawing.Size(1761, 1075);
            this.Controls.Add(this.btnStart);
            this.Controls.Add(this.label6);
            this.Controls.Add(this.label5);
            this.Controls.Add(this.txtY);
            this.Controls.Add(this.txtX);
            this.Controls.Add(this.numericUpDownSum);
            this.Controls.Add(this.label2);
            this.Controls.Add(this.labelTimer);
            this.Name = "CalculationForm";
            this.Text = "CalculationForm";
            ((System.ComponentModel.ISupportInitialize)(this.numericUpDownSum)).EndInit();
            this.ResumeLayout(false);

        }

        #endregion

        private System.Windows.Forms.Label labelTimer;
        private System.Windows.Forms.Label label2;
        private System.Windows.Forms.NumericUpDown numericUpDownSum;
        private System.Windows.Forms.Label txtX;
        private System.Windows.Forms.Label txtY;
        private System.Windows.Forms.Label label5;
        private System.Windows.Forms.Label label6;
        private System.Windows.Forms.Button btnStart;
        private System.Windows.Forms.Timer timer;
    }
}