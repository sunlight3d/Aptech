using UserHub.Models;
using System.ComponentModel.DataAnnotations;
namespace UserHub.DTOs.Responses
{
    public class PostRequest
    {
        public int Id { get; set; }  // Assuming Id is provided during updates

        [Required(ErrorMessage = "Title is required.")]
        [StringLength(100, ErrorMessage = "Title must not exceed 100 characters.")]
        public string Title { get; set; }

        [Required(ErrorMessage = "Content is required.")]
        [StringLength(1000, ErrorMessage = "Content must not exceed 1000 characters.")]
        public string Content { get; set; }
    }

}
