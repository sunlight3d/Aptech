using System.ComponentModel.DataAnnotations;

namespace UserHub.DTOs.Requests.Post
{
    public class UpdatePostRequest
    {
        [Required]
        public int Id { get; set; }
        public string? Title { get; set; }  // Nullable, will only update if provided
        public string? Content { get; set; }  // Nullable, will only update if provided
    }
}
