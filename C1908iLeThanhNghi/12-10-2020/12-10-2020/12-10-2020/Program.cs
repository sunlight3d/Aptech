using System;

namespace _12_10_2020
{
    class Program
    {
        static void Main(string[] args)
        {
            //Test Stack
            Stack<int> someNumbers = new Stack<int>();
            someNumbers.Push(5);
            someNumbers.Push(6);
            someNumbers.Push(9);
            Console.WriteLine("haha");
            int x1 = someNumbers.Pop();
            int x2 = someNumbers.Pop();
            Console.WriteLine($"Is empty : {someNumbers.IsEmpty()}");
            int x3 = someNumbers.Pop();
            int x4 = someNumbers.Pop();            
            int x5 = someNumbers.Pop();
            Console.WriteLine($"Is empty : {someNumbers.IsEmpty()}");
            Point p1 = new Point(1, 1);
            Point p2 = p1;//assignment ,or "value" = clone
            p1.x = 2;
            p1.y = 2;
            Console.WriteLine("haha");
            Coordinator c1 = new Coordinator() {
                X = 1, Y = 2
            };
            Coordinator c2 = c1; //reference, not "value"
            c1.X = 2;
            c1.Y = 2;
            Console.WriteLine("hehe");
            //muon clone c3 = clone of c2
            Coordinator c3 = (Coordinator)c2.Clone();
            c2.X = 3;
            c2.Y = 3;
            Console.WriteLine("hehe");
        }
    }
}
