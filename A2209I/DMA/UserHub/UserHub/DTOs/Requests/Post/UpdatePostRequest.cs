using Microsoft.AspNetCore.Mvc;
using System.ComponentModel.DataAnnotations;
using System.Text.Json.Serialization;

namespace UserHub.DTOs.Requests.Post
{
    public class UpdatePostRequest
    {
        
        [JsonPropertyName("title")]
        public string? Title { get; set; }  // Nullable, will only update if provided

        //[FromQuery(Name = "content")]
        [JsonPropertyName("content")]
        public string? Content { get; set; }  // Nullable, will only update if provided
    }
}
