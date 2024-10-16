using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace apDe6
{
    public abstract class Product
    {
        private int _id; //field is "variable", not "function"
        private string _name;
        public Product() { }
        public Product(int id) { 
            this._id = id;
            this._name = "No name";
        }
        public Product(int id, string name)
        {
            this._id = id;
            this._name = name;
        }
        //Properties(getter,setter) – public 
        public int ID {
            /*
            get { 
                return _id;
            } 
            */
            get => _id;//only getter = read-only
        }
        public string Name { 
            get => _name;
            set {
                if (value.Trim().Length < 3) {
                    throw new Exception("Name must be >= 3 characters");
                }
            }
        }
        public virtual void showInfo() {
            Console.WriteLine(
                $"id: {this._id}, " +
                $"name: {this._name}");            
        }
        public virtual void Input() {
            Console.WriteLine("Enter id");
            this._id = Convert.ToInt32(Console.ReadLine());

            Console.WriteLine("Enter name");
            this._name = Console.ReadLine() ?? "";
        }

    }
}
