using System.Collections;

namespace DictionaryApp
{
    internal class Program
    {
        static ArrayList data = new ArrayList();
        static object locker = new object();
        static void Main(string[] args)
        {

            
            MyDictionary myDictionary = new MyDictionary();
            myDictionary.ShowMenu();
            
            //Console.WriteLine($"max thread is: {GetMaxThreads()}");
            /*
            Console.Write("Nhập số lượng thread: ");
            int threadCount;
            while (!int.TryParse(Console.ReadLine(), out threadCount) || threadCount <= 0)
            {
                Console.Write("Vui lòng nhập một số nguyên dương: ");
            }

            var threads = new Thread[threadCount];
            try {
                for (int i = 0; i < threadCount; i++)
                {
                    int index = i + 1;
                    threads[i] = new Thread(() =>
                    {
                        while (true)
                        {
                            lock (locker)
                            {
                                data.Add($"t{index}");
                                Console.WriteLine(string.Join(", ", data.ToArray()));
                                Thread.Sleep(10);
                            }
                        }
                    });

                    threads[i].Start();
                }

                foreach (var thread in threads)
                {
                    thread.Join();
                }
            }
            catch(Exception e)
            {
                Console.WriteLine(e.Message);
            }
            */
            
        }
        /*
        private static int GetMaxThreads() {
            int threadCount = 0;
            try
            {
                while (true)
                {
                    new Thread(() =>
                    {
                        double xx = 10000f * 12121212f;
                        Thread.Sleep(Timeout.Infinite);//
                    }).Start();

                    threadCount++;
                    Console.WriteLine(threadCount);
                }
            }
            catch (Exception ex)
            {                
                Console.WriteLine($"Đã tạo tối đa {threadCount} threads. Lỗi gặp phải: {ex.Message}");
                return threadCount;
            }
        }
        */
    }
}