using System;
using System.Collections.Generic;
using System.Text;

namespace ConsoleApp
{
    public class HiredProgrammers
    {
        private int _capacity;
        private List<Programmer> HPGM;//Hired ProGraMmers
        public HiredProgrammers(int capacity)
        {
            _capacity = capacity;
            HPGM = new List<Programmer>();
        }
        public void AddNew(Programmer prog)
        {
            if (HPGM.Count >= _capacity)
            {
                throw new Exception("Cannot add Programmer, out of capacity");
            }
            HPGM.Add(prog);
        }
        public int ShowFilterInfo(int underAge)
        {
            int sum = 0;
            foreach (Programmer programmer in HPGM)
            {
                if (programmer.Age <= underAge)
                {
                    programmer.ShowInfo();
                    sum++;
                }
            }
            return sum;
        }
    }
}
