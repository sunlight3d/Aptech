using DotNet.RestApi.Client;
using System;
using System.Net.Http;
using System.Threading.Tasks;

namespace InterfaceExample
{
    class Program
    {
        static async Task Main(string[] args)
        {
            ILearning studentA = new Student()
            {
                Name = "Hoang",
                YearOfBirth = 1979,
            };
            //studentA.playFootball();
            studentA.ReadBook("Java 1");
            studentA.gotoLibrary();
            
            ScreenA screenA = new ScreenA()
            {
                Name = "Man hinh A"
            };
            await screenA.Do2Tasks();
            Console.ReadLine();
        }
    }
}
