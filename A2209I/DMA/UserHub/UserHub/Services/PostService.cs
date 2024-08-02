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
        public async Task<IEnumerable<Post>> GetAllPosts(PostQueryRequest request)
        {
         

            int skip = (request.PageNumber - 1) * request.PageSize;

            IQueryable<Post> query = _context.Set<Post>();

            if (request.UserId.HasValue)
            {
                query = query.Where(p => p.UserId == request.UserId.Value);
            }

            return await query
                         .OrderBy(p => p.Id)
                         .Skip(skip)
                         .Take(request.PageSize)
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

            // Check if a post with the same title already exists
            var titleExists = await _context.Posts.AnyAsync(p => p.Title == request.Title);
            if (titleExists)
            {
                throw new ArgumentException("Duplicate title, cannot insert");
            }

            // If all checks pass, create and add the new post
            var post = new Post
            {
                Title = request.Title,
                Content = request.Content,
                UserId = request.UserId
            };

            _context.Set<Post>().Add(post);

            // Save the changes and return the number of state entries written to the database
            return await _context.SaveChangesAsync();
        }


        public async Task UpdatePost(int id, UpdatePostRequest request)
        {
            var post = await _context.Posts.FirstOrDefaultAsync(p => p.Id == id);
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
            post.UpdatedAt = DateTime.Now;
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
