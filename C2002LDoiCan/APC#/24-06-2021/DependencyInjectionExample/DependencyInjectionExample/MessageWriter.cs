using System;
namespace DependencyInjectionExample
{
    //MessageWriter, Database, Log,,,=> đối tượng nhiều màn hình dùng đến
    //1.Define IMessageWriter(chuc cac method, bat buoc MessageWriter phai thuc thi) and MessageWriter

    public class MessageWriter:IMessageWriter
    {
        public void methodA(String x) {
            Console.WriteLine("Do method a with x = " + x);
        }

        public void methodB(String y) {
            Console.WriteLine("Do method B with y = " + y);
        }
    }
}
