using System;
using System.Xml.Linq;
//namespace = "package in Java"
namespace myapp
{
	public class Result
	{

        public float Math { get; set; } //property, short-form
        public float Physics { get; set; }
        public float Chemistry { get; set; }

        public void Input()
        {
            //validate here!
            while (true) {
                Console.WriteLine("Enter  Math: ");
                Math = (float)Convert.ToDouble(Console.ReadLine()); //explicit casting
                bool isValidMath = Math >= 0 && Math <= 10;                
                if (isValidMath) {
                    break;
                }
            }


            //float x = 123f;
            //Double y = x; //ok, implicit casting

            while (true)
            {
                Console.WriteLine("Enter  Physics: ");
                Physics = (float)Convert.ToDouble(Console.ReadLine());
                bool isValidPhysics = Physics >= 0 && Physics <= 10;
                if (isValidPhysics)
                {
                    break;
                }
            }
            while (true)
            {
                Console.WriteLine("Enter  Chemistry: ");
                Chemistry = (float)Convert.ToDouble(Console.ReadLine());
                bool isValidChemistry = Chemistry >= 0 && Chemistry <= 10;
                if (isValidChemistry)
                {
                    break;
                }
            }            
        }
        public float getTotalMark() => Math + Physics + Chemistry;

        public override string ToString() =>
                    $"Math = {Math}, " +
                    $"Physics = {Physics}, " +
                    $"Chemistry = {Chemistry}, "+
                    $"Total = {getTotalMark()}";
    }
}

