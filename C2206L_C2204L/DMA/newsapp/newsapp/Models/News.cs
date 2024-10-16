using System.ComponentModel.DataAnnotations;
using System.ComponentModel.DataAnnotations.Schema;

namespace newsapp.Models
{
    public class News
    {
        [Key]
        public int ID { get; set; }
        public string Title { get; set; }
        public string Summary { get; set; }
        public string Content { get; set; }

        public int UserID { get; set; }
        [ForeignKey("UserID")]
        public User User { get; set; }

        public DateTime CreatedAt { get; set; }
        public int NumberRead { get; set; }

        public int CategoryID { get; set; }
        
        [ForeignKey("CategoryID")]
        public Category Category { get; set; }

        public string Images { get; set; }

        
    }
}
