using System.Collections.ObjectModel;
using System.ComponentModel.DataAnnotations;

namespace BookStore.Models
{
    public class Category
    {
        [Required]
        public Guid Id { get; set; }
        [Required]
        public string Name { get; set; }
        public Collection<BookCategory> BookCategories { get; set; }
    }
}
