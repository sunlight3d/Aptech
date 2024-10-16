using System;
using bai01.Models;
namespace bai01.Services.PostService
{
    public interface IPostService
    {
        Task<List<Post>> GetAllPostsAsync();
    }
}
