using myapp.Models;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Net;
using System.Net.Http;
using System.Web.Http;

namespace myapp.Controllers
{
    public class ChatsController : ApiController
    {
        private DataContext dataContext = new DataContext();
        
        [HttpGet]
        public IEnumerable<Chat> Get()
        {
            Console.WriteLine("haha");
            var chats = dataContext.chats.AsQueryable().ToList();
            return chats;
        }
        public Chat Get(int id)
        {
            Console.WriteLine("haha");
            return dataContext.chats
                .Where(chat => chat.Id == id).FirstOrDefault();
        }      
        
        public void Post(string content, string username) {
            Console.WriteLine("post");
            dataContext.chats.Add(new Chat() { 
                Content= content,
                Username = username,
                SentTime = new DateTime(),

            });
        }


    }    
}