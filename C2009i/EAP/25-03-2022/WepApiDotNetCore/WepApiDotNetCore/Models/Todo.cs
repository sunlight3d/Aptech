using System.ComponentModel.DataAnnotations;
using WepApiDotNetCore.Models.DTOs;

namespace WepApiDotNetCore.Models
{    
    public class Todo
    {
        [Key]
        public long Id { get; set; }
        public string? Name { get; set; }
        [Required]
        public bool IsComplete { get; set; }
        public string? Secret { get; set; }
        //Factory method
        public static TodoDTO ToDTO(Todo todo) => new TodoDTO
        {
            Id = todo.Id,
            Name = todo.Name,
            IsComplete = todo.IsComplete,
        };
    }
}
