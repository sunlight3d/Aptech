using System.ComponentModel.DataAnnotations.Schema;
using System.ComponentModel.DataAnnotations;

namespace perfumeapp.Models
{
    public class Wishlist
    {
        [Key]
        public int WishlistID { get; set; }

        [ForeignKey("User")]
        public int UserID { get; set; }

        [ForeignKey("Product")]
        public int ProductID
        {
            get; set;
        }
        public virtual User User { get; set; }
        public virtual Product Product { get; set; }
    }
}
