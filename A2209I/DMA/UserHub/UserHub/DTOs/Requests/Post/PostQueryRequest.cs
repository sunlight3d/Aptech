using System.ComponentModel.DataAnnotations;
using System.Text.Json.Serialization;
namespace UserHub.DTOs.Requests.Post

{
    public class PostQueryRequest
    {
        [JsonPropertyName("user_id")]
        public int? UserId { get; set; }

        [Range(1, int.MaxValue, ErrorMessage = "Page number must be greater than zero.")]
        [JsonPropertyName("page_number")]
        public int PageNumber { get; set; } = 1;

        [Range(1, 100, ErrorMessage = "Page size must be between 1 and 100.")]
        [JsonPropertyName("page_size")]
        public int PageSize { get; set; } = 10;
    }


}
