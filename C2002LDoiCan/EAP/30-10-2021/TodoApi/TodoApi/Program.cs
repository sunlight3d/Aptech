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
--version 1.1
docker network create todo-net-api-network
docker rm -f sql-server-2019

docker run \
--name sql-server-2019 \
-u 0:0 \
-e "ACCEPT_EULA=Y" \
-e "SA_PASSWORD=Abc123456789" \
-p 1436:1433 \
--network=todo-net-api-network \
--volume sql-server-2019-database:/var/opt/mssql/data \
-d mcr.microsoft.com/mssql/server:2019-CU13-ubuntu-20.04

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
