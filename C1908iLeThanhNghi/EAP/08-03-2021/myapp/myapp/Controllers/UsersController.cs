using myapp.Models;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Web.Http;
using System.Web.Mvc;
using HttpGetAttribute = System.Web.Http.HttpGetAttribute;

namespace myapp.Controllers
{
    public class UsersController : ApiController
    {
        private DataContext context = new DataContext();
        [HttpGet]
        bool Get(string username, string password) {
            using (DataContext context = new DataContext()) {
                var selectedUser  = context.users.Where(user => user.Username.Equals(username) &&
                user.Password.Equals(password)).FirstOrDefault();
                return selectedUser != null;
            }          
        }
        [HttpGet]
        string Register(string username, string password)
        {
            var selectedUser = context.users
                .Where(user => user.Username.Equals(username)).FirstOrDefault();
            if (selectedUser != null) {
                return "E300";
            }
            return "C200";
        }            
    }
}