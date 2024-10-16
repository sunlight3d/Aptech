using System;
using Microsoft.Extensions.DependencyInjection;
using Microsoft.Extensions.Hosting;

namespace DependencyInjectionExample
{
    class Program
    {
        static void Main(string[] args)
        {
            Console.WriteLine("Hello World!");

            static Task Main(string[] args) =>
            CreateHostBuilder(args).Build().RunAsync();

            static IHostBuilder CreateHostBuilder(string[] args) =>
                Host.CreateDefaultBuilder(args)
                    .ConfigureServices((_, services) =>
                        services.AddHostedService<Worker>()
                                .AddScoped<IMessageWriter, MessageWriter>());
        }
    }
}
