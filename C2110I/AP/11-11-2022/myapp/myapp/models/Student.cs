using System;
using System.Xml.Linq;

namespace myapp.models {
	public class Student {
		public string?	Name  { get; set; }
		public string?	Province { get; set; }
		public int		BirthYear { get; set; }
		public Result?	Mark { get; set; }

		public void Input()
		{
			//validate here!
			Console.WriteLine("Enter student's name: ");
			Name = Console.ReadLine() ?? "";

            Console.WriteLine("Enter student's province: ");
            Province = Console.ReadLine() ?? "";

			while (true) {
                Console.WriteLine("Enter student's birthYear: ");
                BirthYear = Convert.ToInt16(Console.ReadLine());
				int age = DateTime.Now.Year - BirthYear;
				bool isValidAge = age > 18 && age < 45;
				if (isValidAge) {
					break;
				}
            }			

			Mark = new Result();
			Mark.Input();
        }
	}
}
