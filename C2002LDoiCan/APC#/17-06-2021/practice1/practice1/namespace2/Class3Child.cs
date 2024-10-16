using System;
namespace practice1.namespace2
{
    public class Class3Child:Class3
    {
        //Da ke thua thi "bat buoc" thuc thi phuong thuc abstract cua lop cha!
        public override void Function33()
        {
            Console.WriteLine("this is function33");
        }
        protected override void Function3() //khac Java
        {
            //Lop con co the thuc thi phuong thuc virtual cua lop cha(ko bat buoc)
            //level cua "child" <= level Parent
            //VD: level cua Parent la protected => cua child la protected hoac private
        }
        //ko the override phuong thuc khac(ngoai abstract va virtual), khac Java
        //public override void Function333() {

        //}
        public Class3Child() : base() {

        }
    }
}
