using System;
using System.Collections.Generic;
using System.Linq;
using System.Threading.Tasks;
using System.Windows.Forms;
//Link de thi:
//https://drive.google.com/drive/folders/1tB9Yby_9rkyiTUyR57jPN82r_4qN3SpS
namespace ExamApp
{
    static class Program
    {
        /// <summary>
        /// The main entry point for the application.
        /// </summary>
        [STAThread]
        static void Main()
        {
            Application.EnableVisualStyles();
            Application.SetCompatibleTextRenderingDefault(false);
            Application.Run(new HRManagementForm());
        }
    }
}
