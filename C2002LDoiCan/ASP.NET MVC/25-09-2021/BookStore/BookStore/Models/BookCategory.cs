namespace BookStore.Models
{
    public class BookCategory
    {
        public Guid Id {  get; set; }
        public string Description {  get; set; }

        public Guid BookId { get; set; }
        public Book Book {  get; set; }

        public Guid CategoryId { get; set; }
        public Category Category { get; set; }

    }
}
