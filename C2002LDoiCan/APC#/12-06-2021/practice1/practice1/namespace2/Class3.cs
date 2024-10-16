using System;
namespace practice1.namespace2
{
    public abstract class Class3: Object
    {
        public static int NumberOfObjects { get; set; }
        public Class3() {
            ++NumberOfObjects;
        }
        public static int aaa;
        private String name; //field
        //private var y; var field => NO !
        private int x; //field, variable
        
        private readonly int xx = 123; //field is readonly => OK
        private const int xxx = 135; //ok
        //public int X { get; set; } //property is "function"

        public String prop3;//ko the virtual !
        protected virtual void Function3() {
            //virtual method => phai public(hoặc protected) VA "phai co phan thuc thi"
            //virtual = "Thực hiện 1 ít rồi, con cái làm tiếp, nên phải public"
        }
        public abstract void Function33();//giong Java
        //public abstract void Function33() {
        //    //phuong thuc abstract ko chua phan thuc thi
        //}
        //instance method (90%)
        public void Function333() {
            var x = 100;
            //final xx = 1200; // ko co final
            const int xx = 1200;
            //readonly int yy = 234; //ko the khai bao bien(variable) kieu readonly
        }
        public override string ToString()
        {
            //this.name ?? "" => neu this.name == null thi lay gia tri ""
            return $"name = {this.name ?? ""}, x = {this.x}, xx = {this.xx}";
        }
        //phuong thuc static, => goi ko can khoi tao doi tuong
        public static void StaticFunction1() {
            //trong phuong thuc static ko truy cap duoc instance field/properties
            //nhung co the truy cap duoc vao static field/properties
            Console.WriteLine(Class3.aaa);
        }
    }
}
