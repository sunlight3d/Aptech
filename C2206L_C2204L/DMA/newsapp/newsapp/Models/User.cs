using System.ComponentModel.DataAnnotations;
using System.Runtime.Serialization;

namespace newsapp.Models
{
    public class User
    {
        [Key]
        public int UserID { get; set; }
        public string UserName { get; set; }
        public string Password { get; set; }
        public string Description { get; set; }
        
        [IgnoreDataMember]
        public virtual ICollection<News> NewsList { get; set; } = new List<News>();
    }
}
