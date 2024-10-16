using bai01.Models;
using Microsoft.EntityFrameworkCore;

namespace bai01.Services.PostService
{
    public class PostService : IPostService
    {
        private readonly DataContext _context;

        public PostService(DataContext context)
        {
            _context = context;
        }

        public async Task<List<Post>> GetAllPostsAsync()
        {
            return await _context.Posts.Include(p => p.Category).ToListAsync();
        }
    }

}
