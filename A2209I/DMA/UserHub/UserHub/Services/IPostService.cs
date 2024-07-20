using UserHub.Models;

namespace UserHub.Services
{
    public interface IPostService
    {
        Task<Post> GetPostById(int id);
        Task<IEnumerable<Post>> GetAllPosts();
        Task AddPost(Post post);
        Task UpdatePost(Post post);
        Task DeletePost(Post post);
    }

}
