using System;
using System.Collections.Generic;
using System.Text;

namespace ConsoleApp
{
    public class HiredProgrammers
    {
        private List<Programmer> programmers;        
        public HiredProgrammers(int capacity)
        {            
            programmers = new List<Programmer>(capacity);
        }
        public void AddNew(Programmer programmer) {
            try {
                programmers.Add(programmer);
            } catch(Exception ex) when (ex is ArgumentOutOfRangeException || ex is IndexOutOfRangeException)
            {
                
            }
        }
        int ShowFilterInfo(int underage) {
            List<Programmer> foundProgrammers = this.programmers.FindAll(p => p.Age < underage);
            foreach (var programmer in foundProgrammers) {
                programmer.ShowInfo();
            }
            return foundProgrammers.Count;
        }
    }
}
