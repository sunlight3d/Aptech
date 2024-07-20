namespace UserHub.Models
{
    public class Post
    {
        public int Id { get; set; }
        public string Title { get; set; }
        public string Content { get; set; }

        // Foreign key
        public int UserId { get; set; }

        // Navigation property
        public virtual User User { get; set; }
    }


}
