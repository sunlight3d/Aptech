using Microsoft.AspNetCore.Authentication;

namespace ECommerceApp.Models
{
    public class Book
    {
        public int ID { get; set; }
        public string Title { get; set; }
        public float Price { get; set; }
        public string Description { get; set; }
        
    }   
}
