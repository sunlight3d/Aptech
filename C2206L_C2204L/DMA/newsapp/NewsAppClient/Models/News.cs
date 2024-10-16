using System.ComponentModel.DataAnnotations;
using System.ComponentModel.DataAnnotations.Schema;

namespace NewsAppClient.Models
{
    public class News
    {
        [Key]
        public int ID { get; set; }
        public string Title { get; set; }
        public string Summary { get; set; }
        public string Content { get; set; }

        public int UserID { get; set; }        
        public User User { get; set; }

        public DateTime CreatedAt { get; set; }
        public int NumberRead { get; set; }

        public int CategoryID { get; set; }                

        public string Images { get; set; }

        
    }
}
