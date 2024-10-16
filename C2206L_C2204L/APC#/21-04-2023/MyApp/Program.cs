using MyApp.Models;
using System.Text;
using System.Text.RegularExpressions;

namespace MyApp
{
    internal class Program
    {
        static void Main(string[] args)
        {
            int x = 10;
            float y = (float)10;
            Console.WriteLine($"x is : {x},, y = {y}");
            Console.OutputEncoding = Encoding.UTF8;
            /*
            MyClass obj1 = new MyClass("Object 1");
            MyClass obj2 = new MyClass("Object 2");
            MyClass obj3 = new MyClass("Object 3");

            MyClass obj5 = obj1;
            MyClass obj6 = obj1;

            obj1 = null;
            obj5 = null;
            obj6 = null;

            obj2 = null;
            */
            //GC.Collect();

            //Console.ReadKey();
            /*
            Point p1 = new Point(10, 90);
            Point p3 = p1;//assign
            p1.X = 100;
            Point p2 = new Point(10, 90);
            Console.WriteLine($"p2.x = {p2.X}");            
            
            Console.WriteLine($"p3.x = {p3.X}");
            Console.WriteLine("haha");

            MyClass myClass11 = new MyClass("xx");
            MyClass myClass22 = myClass11;
            myClass11.Name = "yyyyy";
            Console.WriteLine($"myClass22.Name = {myClass22.Name}");
            */
            Console.WriteLine("Nhập tên của bạn: ");
            string playerName = Console.ReadLine();
            Console.WriteLine("Nhập số tiền bị mất: ");
            int stolenGold = Convert.ToInt32(Console.ReadLine());
            int goldAmount = 5;

            // Tạo mảnh đất 5x5 với 5 đơn vị vàng
            Grid grid = new Grid(5, 5, goldAmount);

            int collectedGold = 0;
            while (goldAmount > 0)
            {
                Console.WriteLine("Nhập tọa độ ô trống để kiểm tra vàng (dạng: hàng cột): ");
                string[] input = Regex.Split(Console.ReadLine() ?? "", @"[\s,]+");
                int row = Convert.ToInt32(input[0]);
                int col = Convert.ToInt32(input[1]);

                Cell cell = grid.GetCell(row, col);

                if (cell.HasGold)
                {
                    collectedGold++;
                    goldAmount--;
                    cell.HasGold = false;
                    Console.WriteLine("Tìm thấy vàng! Tiền thưởng hiện tại: " + collectedGold);
                }
                else
                {
                    Console.WriteLine("Không có vàng ở ô trống này.");
                }
            }

            Console.WriteLine("Kết thúc trò chơi. " + playerName + 
                " đã tìm thấy " + collectedGold + " đơn vị vàng.");

            double performance = (double)collectedGold / stolenGold;
            if (performance >= 0.9)
            {
                Console.WriteLine("Xuất sắc! Bạn đã tìm thấy hầu hết số vàng bị mất.");
            }
            else if (performance >= 0.5)
            {
                Console.WriteLine("Tốt! Bạn đã tìm thấy một nửa số vàng bị mất.");
            }
            else
            {
                Console.WriteLine("Cần cố gắng hơn! Bạn chỉ tìm thấy một ít số vàng bị mất.");
            }
        }
    }    
}