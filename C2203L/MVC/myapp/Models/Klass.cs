using Microsoft.AspNetCore.Authentication;

namespace myapp.Models
{
    public class Klass
    {
        public int ID { get; set; }
        public string Name { get; set; }
        public DateTime StartDate { get; set; }
        public ICollection<Student> Students { get; set; }

    }
}
