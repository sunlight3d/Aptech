﻿using System;
using System.Collections.Generic;
using System.Linq;
using System.Threading.Tasks;
using IdentityExample.Data;
using IdentityExample.Middleware;
using IdentityExample.Models;
using Microsoft.AspNetCore.Builder;
using Microsoft.AspNetCore.Hosting;
using Microsoft.AspNetCore.Identity;
using Microsoft.EntityFrameworkCore;
using Microsoft.Extensions.DependencyInjection;

namespace IdentityExample
{
    public class Startup
    {
        public void ConfigureServices(IServiceCollection services)
        {
            services.AddIdentity<Student, IdentityRole>(options =>
           {
               options.Password.RequireDigit = true;
               options.Password.RequiredLength = 7;
               options.Password.RequireUppercase = true;

               options.User.RequireUniqueEmail = true;
           })
            .AddEntityFrameworkStores<StudentContext>();

            services.AddDbContext<StudentContext>(options =>
                  options.UseSqlite("Data Source=student.db"));

            services.AddMvc();
        }

        public void Configure(IApplicationBuilder app, 
            IWebHostEnvironment env, 
            StudentContext studentContext)
        {
            studentContext.Database.EnsureDeleted();
            studentContext.Database.EnsureCreated();
            app.UseStaticFiles();
            app.UseNodeModules(env.ContentRootPath);            
            app.UseRouting();
            app.UseAuthentication();
            app.UseAuthorization();
            app.UseEndpoints(endpoints =>
            {
                //endpoints.MapDefaultControllerRoute();
                endpoints.MapControllerRoute(
                    name: "StudentRoute",
                    pattern: "{controller}/{action}/{id?}",
                    defaults: new { controller = "Student", action = "Index" },
                    constraints: new { id = "[0-9]+" });                

            });

        }
    }
}
