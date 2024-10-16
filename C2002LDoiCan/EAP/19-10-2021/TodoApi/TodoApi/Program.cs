using Microsoft.AspNetCore.Hosting;
using Microsoft.Extensions.Configuration;
using Microsoft.Extensions.Hosting;
using Microsoft.Extensions.Logging;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Threading.Tasks;
/*
Add-Migration
Update-Database
-Build image
docker build -t todo-net-api .
- 
docker tag todo-net-api sunlight4d/todo-net-api:1.0
docker push sunlight4d/todo-net-api:1.0

docker run -d \
--name todo-net-api-container \
-p 5002:5001 \
sunlight4d/todo-net-api:1.0

-- copy code to VPS
scp -pr TodoApi root@45.15.24.65:/path/to/remote/dir
 */
namespace TodoApi
{
    public class Program
    {
        public static void Main(string[] args)
        {
            CreateHostBuilder(args).Build().Run();
        }

        public static IHostBuilder CreateHostBuilder(string[] args) =>
            Host.CreateDefaultBuilder(args)
                .ConfigureWebHostDefaults(webBuilder =>
                {
                    webBuilder.UseStartup<Startup>();
                });
    }
}
