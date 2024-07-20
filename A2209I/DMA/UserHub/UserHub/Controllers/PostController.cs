using Microsoft.AspNetCore.Authorization;
using Microsoft.AspNetCore.Http;
using Microsoft.AspNetCore.Mvc;
using System.Security.Claims;
using UserHub.DTOs.Responses;
using UserHub.Models;
using UserHub.Services;

namespace UserHub.Controllers
{
    [ApiController]
    [Route("[controller]")]
    public class PostController : ControllerBase
    {
        private readonly IPostService _postService; // Assume dependency injection is set up


        public PostController(IPostService postService)
        {
            _postService = postService;
        }

        [HttpPost]
        [Authorize] // Ensure the user is logged in
        public IActionResult Create(PostRequest request)
        {
            var userId = int.Parse(User.FindFirst(ClaimTypes.NameIdentifier)?.Value);
            var post = new Post
            {
                Title = request.Title,
                Content = request.Content,
                UserId = userId
            };
            _postService.AddPost(post);
            return CreatedAtAction(nameof(Get), new { id = post.Id }, post);
        }

        [HttpPut("{id}")]
        [Authorize(Policy = "EditAnyPost")] // Admins can edit any post
        public async Task<IActionResult> Update(int id, PostRequest postDto)
        {
            Post post = await _postService.GetPostById(id);
            if (post == null)
            {
                return NotFound();
            }

            if (User.IsInRole("Admin") || 
                post.UserId == int.Parse(User.FindFirst(ClaimTypes.NameIdentifier)?.Value))
            {
                post.Title = postDto.Title;
                post.Content = postDto.Content;
                _postService.UpdatePost(post);
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

            if (User.IsInRole("Admin") || post.UserId == userId
            {
                _postService.DeletePost(post);
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
