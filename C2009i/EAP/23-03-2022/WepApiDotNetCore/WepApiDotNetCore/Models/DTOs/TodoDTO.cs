using System.ComponentModel.DataAnnotations;

namespace WepApiDotNetCore.Models.DTOs
{
    public class TodoDTO
    {
        public long Id { get; set; }
        public string? Name { get; set; }        
        public bool IsComplete { get; set; }
    }
}
