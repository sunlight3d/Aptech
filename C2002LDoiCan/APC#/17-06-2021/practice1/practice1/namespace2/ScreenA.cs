using System;
using System.Collections.Generic;
using System.Linq;
using System.Reactive.Disposables;
using System.Text;
using System.Threading.Tasks;

namespace practice1.namespace2
{
    public class ScreenA : IObservable<Person>
    {
        public void ListenEventFromB(object sender, EventArgs e) {
            Console.WriteLine($"Thang B thay doi day: {((ScreenB)sender).Name}");
        }

        public IDisposable Subscribe(IObserver<Person> person)
        {
            person.OnCompleted();
            return Disposable.Empty;
        }
    }
}
