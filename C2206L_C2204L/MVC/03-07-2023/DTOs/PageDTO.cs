using System.ComponentModel.DataAnnotations;

namespace _03_07_2023.DTOs
{
    public class PageDTO
    {
        [Range(0, 1000, ErrorMessage = "Page must be between 0 and 1000")]
        public int Page { get; set; } = 1;

        [Range(1, 100, ErrorMessage = "Limit must be between 1 and 100")]
        public int Limit { get; set; } = 10;
    }

}
