using UserHub.Models;
using System.ComponentModel.DataAnnotations;
using System.Text.Json.Serialization;
namespace UserHub.DTOs.Requests.Post
{
    public class InsertPostRequest
    {

        [Required(ErrorMessage = "Title is required.")]
        [StringLength(100, ErrorMessage = "Title must not exceed 100 characters.")]
        public string Title { get; set; }

        [Required(ErrorMessage = "Content is required.")]
        [StringLength(1000, ErrorMessage = "Content must not exceed 1000 characters.")]
        public string Content { get; set; }

        [Required(ErrorMessage = "User ID is required.")]
        
        [JsonPropertyName("user_id")]
        public int UserId { get; set; }
    }

}
