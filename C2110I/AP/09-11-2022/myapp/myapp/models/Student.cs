using System;
using System.Xml.Linq;

namespace myapp.models {
	public class Student {
		public string	Name { get; set; }
		public string	Province { get; set; }
		public int		BirthYear { get; set; }
		public Result	Mark { get; set; }
	}
}
