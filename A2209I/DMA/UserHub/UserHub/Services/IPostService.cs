using UserHub.DTOs.Requests.Post;
using UserHub.Models;

namespace UserHub.Services
{
    public interface IPostService
    {
        Task<Post?> GetPostById(int id);
        Task<IEnumerable<Post>> GetAllPosts(PostQueryRequest request);
        Task<int> AddPost(InsertPostRequest request);
        Task UpdatePost(int id, UpdatePostRequest request);
        Task DeletePost(Post post);
    }

}
