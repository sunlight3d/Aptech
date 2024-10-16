using Microsoft.AspNetCore.Identity;
using System.ComponentModel.DataAnnotations;
using System.Data.Common;

namespace WebApiApp.Models
{
    public class User:IdentityUser
    {
        public int Id { get; set; }        
        public string FullName { get; set; }
        
        [Required]
        [EmailAddress]
        public string Email { get; set; }
        //public string PasswordHash { get; set; }
    }
}
