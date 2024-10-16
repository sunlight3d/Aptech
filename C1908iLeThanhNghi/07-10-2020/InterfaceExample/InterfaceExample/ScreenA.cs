using System;
using System.Collections.Generic;
using System.Text;
using System.Threading.Tasks;

namespace InterfaceExample
{
    public class ScreenA: IFilmManagement
    {
        public String Name { get; set; }
        private async Task DoSomething1() {
            Console.WriteLine("Do something 1");
            Worker worker = new Worker();
            await worker.GetFilmsFromApi(this);
        }
        public void responseFilms(List<Film> films, Exception exception)
        {
            Console.WriteLine("co ket qua");
        }
        private async Task DoSomething2()
        {
            Console.WriteLine("Do something 2");
            //Monng muong DoSomething1, DoSomething2 chay song song, ko ai doi ai
        }

        public async Task Do2Tasks()
        {
            DoSomething1();
            DoSomething2();
        }

        
    }
}
