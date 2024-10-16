using System;
namespace de06
{
	public abstract class Product
	{
		private int _id;
        private string? _name;
		public Product(int id) {
			this._id = id;
			_name = "No name";
		}
        public Product(int id, string name)
        {
            this._id = id;
            this._name = name;
        }
        public int ID { get => _id; }
        public string? Name { get => _name; set {
                if (value?.Length < 3) {
                    throw new Exception("Tên phải có độ dài >= 3");
                }
                _name = value;
            }
        }
        public abstract void ShowInfo();
    }
}

