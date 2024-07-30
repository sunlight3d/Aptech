using Microsoft.AspNetCore.Mvc;
using System.ComponentModel.DataAnnotations;
using System.Text.Json.Serialization;
namespace UserHub.DTOs.Requests.Post

{
    public class PostQueryRequest
    {        
        [FromQuery(Name = "user_id")]
        public int? UserId { get; set; }

        [Range(1, 1000, ErrorMessage = "Page number must be greater than zero.")]
        [FromQuery(Name = "page_number")]        
        public int PageNumber { get; set; }

        [Range(1, 100, ErrorMessage = "Page size must be between 1 and 100.")]
        [FromQuery(Name = "page_size")]
        public int PageSize { get; set; }
    }


}
