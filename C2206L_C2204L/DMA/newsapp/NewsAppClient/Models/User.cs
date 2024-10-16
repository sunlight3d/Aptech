using System.ComponentModel.DataAnnotations;
using System.Runtime.Serialization;

namespace NewsAppClient.Models
{
    public class User
    {        
        public int UserID { get; set; }
        public string UserName { get; set; }
        public string Password { get; set; }
        public string Description { get; set; }
                
        public virtual ICollection<News> NewsList { get; set; } = new List<News>();
    }
}
