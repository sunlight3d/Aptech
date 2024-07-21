using UserHub.DTOs.Requests.Post;
using UserHub.Models;

namespace UserHub.Services
{
    public interface IPostService
    {
        Task<Post?> GetPostById(int id);
        Task<IEnumerable<Post>> GetAllPosts(int pageNumber = 1, int pageSize = 10);
        Task<int> AddPost(InsertPostRequest request);
        Task UpdatePost(UpdatePostRequest request);
        Task DeletePost(Post post);
    }

}
