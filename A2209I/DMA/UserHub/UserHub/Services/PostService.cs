using Microsoft.EntityFrameworkCore;
using Microsoft.EntityFrameworkCore.Infrastructure.Internal;
using UserHub.DTOs.Requests.Post;
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

        public async Task<Post?> GetPostById(int id)
        {
            return await _context.Posts.FindAsync(id);
        }
        public async Task<IEnumerable<Post>> GetAllPosts(int pageNumber = 1, int pageSize = 10)
        {
            if (pageNumber <= 0)
            {
                throw new ArgumentException("Page number must be greater than zero.");
            }

            if (pageSize <= 0)
            {
                throw new ArgumentException("Page size must be greater than zero.");
            }

            int skip = (pageNumber - 1) * pageSize;

            return await _context.Set<Post>()
                                 .OrderBy(p => p.Id)
                                 .Skip(skip)
                                 .Take(pageSize)
                                 .ToListAsync();
        }


        public async Task<int> AddPost(InsertPostRequest request)
        {
            // Check if the User ID exists in the database
            var userExists = await _context.Users.AnyAsync(u => u.Id == request.UserId);
            if (!userExists)
            {
                throw new KeyNotFoundException("No user found with the provided User ID.");
            }
            //you must check if userId exist in _context.Set<Post>
            var post = new Post
            {
                Title = request.Title,
                Content = request.Content,
                UserId = request.UserId
            };
            _context.Set<Post>().Add(post);
            return await _context.SaveChangesAsync();
        }
        
        public async Task UpdatePost(UpdatePostRequest request)
        {
            var post = await _context.Posts.FirstOrDefaultAsync(p => p.Id == request.Id);
            if (post == null)
            {
                throw new KeyNotFoundException("Post not found.");
            }

            // Update properties if they are provided in the request (not null)
            if (!string.IsNullOrEmpty(request.Title))
            {
                post.Title = request.Title;
            }

            if (!string.IsNullOrEmpty(request.Content))
            {
                post.Content = request.Content;
            }

            // Mark the entity as modified
            _context.Entry(post).State = EntityState.Modified;

            // Save changes to the database
            await _context.SaveChangesAsync();
        }


        public async Task DeletePost(Post post)
        {
            _context.Set<Post>().Remove(post);
            await _context.SaveChangesAsync();
        }
    }
}
