using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;

namespace myapp.Models
{
    public class Chat
    {
        public int Id { get; set; }
        public String Content { get; set; }
        public string Username { get; set; }
        public DateTime SentTime { get; set; }        
    }
}