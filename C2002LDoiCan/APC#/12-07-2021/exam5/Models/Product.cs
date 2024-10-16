using System;
namespace exam5.Models {
    public abstract class Product {
        private int _id;
        private string _name;
        public Product(int id)
        {
            this._id = id;
            this._name = "No name";
        }
        public Product(int id, string name)
        {
            this._id = id;
            this._name = name;
        }
        public int ID { 
            get {
                return _id;
            } 
        }
        public string Name  { 
            get {
                return _name;
            } set {
                if(_name.Length < 3) {
                    throw new Exception("Length must be >= 3");
                }
            } 
        }
        public abstract void ShowInfo();
    }
}