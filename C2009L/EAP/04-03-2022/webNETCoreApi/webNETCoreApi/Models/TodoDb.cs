using Microsoft.EntityFrameworkCore;

namespace webNETCoreApi.Models
{
    public class TodoDb:DbContext
    {
        //inject options
        public TodoDb(DbContextOptions<TodoDb> options) : base(options) { 
        }
    }
}
