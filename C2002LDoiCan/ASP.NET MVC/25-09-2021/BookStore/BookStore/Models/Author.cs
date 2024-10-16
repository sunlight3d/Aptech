using System.Collections.ObjectModel;
using System.ComponentModel.DataAnnotations;
namespace BookStore.Models
{
    public class Author
    {
        [Required]
        public Guid Id {  get; set; }
        [Required]
        public string Name {  get; set; }
        public Collection<Book>? Books {  get; set; }
    }
}
