using Microsoft.AspNetCore.Authorization;
using Microsoft.AspNetCore.Http;
using Microsoft.AspNetCore.Mvc;
using System.Security.Claims;
using UserHub.DTOs.Requests.Post;
using UserHub.Models;
using UserHub.Services;

namespace UserHub.Controllers
{
    [ApiController]
    [Route("[controller]s")]
    public class PostController : ControllerBase
    {
        private readonly IPostService _postService; // Assume dependency injection is set up


        public PostController(IPostService postService)
        {
            _postService = postService ?? throw new ArgumentNullException(nameof(postService));
        }

        [HttpGet]
        public async Task<IActionResult> GetAllPosts(int pageNumber = 1, int pageSize = 10)
            
        {
            var posts = await _postService.GetAllPosts(pageNumber, pageSize);
            if (posts == null || !posts.Any())
            {
                return NotFound("No posts found.");
            }
            return Ok(posts);
        }

        [HttpPost]
        [Authorize] // Ensure the user is logged in
        public async Task<IActionResult> Create(InsertPostRequest request)
        {
            var userId = int.Parse(User.FindFirst(ClaimTypes.NameIdentifier)?.Value);
           
            int postId = await _postService.AddPost(request);
            return CreatedAtAction(nameof(Get), new { id = postId });
        }

        [HttpPut("{id}")]
        [Authorize(Policy = "EditAnyPost")] // Admins can edit any post
        public async Task<IActionResult> Update(UpdatePostRequest request)
        {
            Post post = await _postService.GetPostById(request.Id);
            if (post == null)
            {
                return NotFound();
            }

            if (User.IsInRole("Admin") || 
                post.UserId == int.Parse(User?.FindFirst(ClaimTypes.NameIdentifier)?.Value))
            {
               
                await _postService.UpdatePost(request);
                return NoContent();
            }
            else
            {
                return Forbid();
            }
        }

        [HttpDelete("{id}")]
        [Authorize(Policy = "EditAnyPost")] // Admins can edit any post
        public async Task<IActionResult> Delete(int id)
        {
            var post = await _postService.GetPostById(id);
            var userId = int.Parse(User.FindFirst(ClaimTypes.NameIdentifier)?.Value);
            if (post == null)
            {
                return NotFound();
            }

            if (User.IsInRole("Admin") || post.UserId == userId)
            {
                await _postService.DeletePost(post);
                return NoContent();
            }
            else
            {
                return Forbid();
            }
        }

        [HttpGet("{id}")]
        public async Task<IActionResult> Get(int id)
        {
            var post = await _postService.GetPostById(id);
            if (post != null)
            {
                return Ok(post);
            }
            return NotFound();
        }
    }

}
