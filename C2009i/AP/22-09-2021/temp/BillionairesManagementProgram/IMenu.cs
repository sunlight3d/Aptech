using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace BillionairesManagementProgram
{
    public interface IMenu
    {
        public void Input();
        public void Sort();
        public void Analyze();
        public void Find();
        public void Save();
        public void Open();
    }
}
