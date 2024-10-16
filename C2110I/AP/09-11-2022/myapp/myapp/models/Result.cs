using System;
//namespace = "package in Java"
namespace myapp
{
	public class Result
	{
        //private float math;//fields/atribute 
        //private float physics;
        //private float chemistry;
        //getter,

        public float Math { get; set; } //property, short-form
        public float Physics { get; set; }
        public float Chemistry { get; set; }

        //property is "Function"

        //full-form
        //private float math;//fields/atribute 
        //public float Math {
        //    get {
        //        Console.WriteLine("get get");
        //        return math;
        //    }
        //    set {
        //        Console.WriteLine("call SET");//validate data here !
        //        math = value;
        //    }
        //}
        //get detail object's information => override method ToString()
        public override string ToString()
        {
            return  $"Math = {Math}, " +
                    $"Physics = {Physics}, " +
                    $"Chemistry = {Chemistry}";
        }
    }
}

