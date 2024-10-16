using System.ComponentModel.DataAnnotations;
using System.Runtime.Serialization;

namespace newsapp.Models
{
    public class Category
    {
        [Key]
        public int ID { get; set; }
        public string CategoryName { get; set; }
        public string CategoryType { get; set; }
        
        public int Order { get; set; }

        [IgnoreDataMember]
        public virtual ICollection<News> NewsList { get; set; } = new List<News>();
    }
}
