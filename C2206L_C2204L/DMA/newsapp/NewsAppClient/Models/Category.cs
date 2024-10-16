using System.ComponentModel.DataAnnotations;
using System.Runtime.Serialization;

namespace NewsAppClient.Models
{
    public class Category
    {        
        public int ID { get; set; }
        public string CategoryName { get; set; }
        public string CategoryType { get; set; }
       
        public int Order { get; set; }     
        public virtual ICollection<News> NewsList { get; set; } = new List<News>();
    }
}
