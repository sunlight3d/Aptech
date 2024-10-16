using BookStore.Data;
using System.Linq;
using Microsoft.AspNetCore.Identity;

namespace BookStore.Models
{
    public static class DbInitializer
    {
        public static async Task InitializeAsync(
            BookStoreContext context, 
            IServiceProvider serviceProvider,
            UserManager<IdentityUser> userManager
            )
        {
            var roleManager = serviceProvider.GetRequiredService<RoleManager<IdentityRole>>();
            string[] roleNames = new string[] { "Admin", "User" };
            IdentityResult identityResult;
            foreach(string roleName in roleNames)
            {
                bool roleExist = await roleManager.RoleExistsAsync(roleName);
                if (!roleExist)
                {
                    identityResult = await roleManager.CreateAsync(new IdentityRole(roleName));   
                }
            }
            string email = "admin@gmail.com";
            string password = "123456";
            if (userManager.FindByEmailAsync("admin@gmail.com").Result == null)
            {
                IdentityUser user = new IdentityUser();
                user.UserName = "admin";
                user.Email = email;
                var result = await userManager.CreateAsync(user);
                if(result.Succeeded)
                {
                    userManager.AddToRoleAsync(user, "admin").Wait();
                }

            }
            
        }
    }
}
