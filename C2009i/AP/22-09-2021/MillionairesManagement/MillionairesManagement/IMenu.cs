using System;
namespace MillionairesManagement
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
