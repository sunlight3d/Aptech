using System;
namespace practice1.models
{
    public class Result
    {
        //cach viet thong dung
        //public float Math { get; set; } //bao gom ca getter, setter roi
        //Math = property => "function"
        //cach viet day du
        //Ko nen xem tut C# tren w3school(viet kieu Java)
        private float math ;//field
        public float Math { //property
            get {
                //
                return math;
            }
            set {
                //giong nhu trigger
                math = value;
            }
        }
        public float Physics { get; set; }
        public float Chemistry { get; set; }
        //ko can thiet !
        //public Result(float math, float physics, float chemistry) {
        //    Math = math;
        //    Physics = physics;
        //    Chemistry = chemistry;
        //}

    }
}
