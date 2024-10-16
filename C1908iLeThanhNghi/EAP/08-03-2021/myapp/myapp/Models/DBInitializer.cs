using System;
using System.Collections.Generic;
using System.Data.Entity;
using System.Linq;
using System.Web;

namespace myapp.Models
{
    public class DBInitializer : CreateDatabaseIfNotExists<DataContext>
    {
        protected override void Seed(DataContext context)
        {
            base.Seed(context);
            context.chats.Add(new Chat()
            {
                Content = "aaaa",
                Username = "hoang",
                SentTime = new DateTime()
            });
        }
    }
}