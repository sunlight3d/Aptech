using System.ComponentModel.DataAnnotations;
namespace UserHub.DTOs.Requests

{
    public class PostQueryRequest
    {
        public int? UserId { get; set; }

        [Range(1, int.MaxValue, ErrorMessage = "Page number must be greater than zero.")]
        public int PageNumber { get; set; } = 1;

        [Range(1, 100, ErrorMessage = "Page size must be between 1 and 100.")]
        public int PageSize { get; set; } = 10;
    }


}
