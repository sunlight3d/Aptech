using Microsoft.EntityFrameworkCore;
using UserHub.Models;

namespace UserHub.Services
{
    public class PostService : IPostService
    {
        private readonly DataContext _context;  // Your DbContext might be named differently

        public PostService(DataContext context)
        {
            _context = context;
        }

        public async Task<Post> GetPostById(int id)
        {
            return await _context.Posts.FindAsync(id);
        }
        public async Task<IEnumerable<Post>> GetAllPosts()
        {
            return await _context.Set<Post>().ToListAsync();
        }

        public async Task AddPost(Post post)
        {
            _context.Set<Post>().Add(post);
            await _context.SaveChangesAsync();
        }

        public async Task UpdatePost(Post post)
        {
            _context.Entry(post).State = EntityState.Modified;
            await _context.SaveChangesAsync();
        }

        public async Task DeletePost(Post post)
        {
            _context.Set<Post>().Remove(post);
            await _context.SaveChangesAsync();
        }
    }
}
