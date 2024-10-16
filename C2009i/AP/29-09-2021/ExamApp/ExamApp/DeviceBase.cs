using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace ExamApp
{
    public abstract class DeviceBase
    {
        private int _id;
        private string _name;
        public int ID { get => _id; }
        public string Name {              
            get => _name;
            set {
                if(_name.Length >= 5)
                {
                    _name = value;
                }
                else
                {
                    throw new Exception("name must be >= 5 characters in length");
                }                 
            }
        }
        public abstract void ShowInfo();
        public DeviceBase(int id)
        {
            this._id = id;
            this._name = "No Name";
        }
        public DeviceBase(int id, string name)
        {
            this._id = id;
            this._name = name;
        }
    }
}
