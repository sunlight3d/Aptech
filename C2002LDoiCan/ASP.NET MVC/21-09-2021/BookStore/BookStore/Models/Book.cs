using System.Collections.ObjectModel;
using System.ComponentModel.DataAnnotations;

namespace BookStore.Models
{
    public class Book
    {
        [Required]
        public Guid Id {  get; set; }
        [Required]
        public string Name {  get; set; }
        [Required]
        public decimal Price {  get; set; }
        [Required]
        public string ISBN {  get; set; }
        public string? Description {  get; set; }

        public Guid StoreId { get; set; }
        public Store Store { get; set; }

        public Guid AuthorId { get; set; }
        public Author Author { get; set; }
        public Collection<BookCategory> BookCategories { get; set; }
    }
}
