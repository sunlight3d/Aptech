using Microsoft.AspNetCore.Authorization;
using Microsoft.AspNetCore.Http;
using Microsoft.AspNetCore.Mvc;
using System.Security.Claims;
using UserHub.DTOs.Requests.Post;
using UserHub.DTOs.Responses;
using UserHub.Models;
using UserHub.Services;

namespace UserHub.Controllers
{
    [ApiController]
    [Route("api/[controller]s")]
    public class PostController : ControllerBase
    {
        private readonly IPostService _postService; // Assume dependency injection is set up
        private readonly ITokenService _tokenService;

        public PostController(IPostService postService, ITokenService tokenService)
        {
            _postService = postService ?? throw new ArgumentNullException(nameof(postService));
            _tokenService = tokenService ?? throw new ArgumentNullException(nameof(tokenService));
        }

        [HttpGet]
        [AllowAnonymous]
        public async Task<IActionResult> GetAllPosts([FromQuery] PostQueryRequest request)
        {
            if (!ModelState.IsValid)
            {
                return BadRequest(ModelState);  // Returns detailed validation errors
            }

            var posts = await _postService.GetAllPosts(request);
            return Ok(posts);
        }


        [HttpPost()]        
        [Authorize(Policy = "LoginRequire")]
        public async Task<IActionResult> Create(InsertPostRequest request)
        {
            // Retrieve user information from the token in the HTTP context.
            UserResponse userResponse = (UserResponse)HttpContext.Items["user"];

            // Check if user information is properly retrieved and matches the request's UserId.
            if (userResponse == null || userResponse.Id != request.UserId)
            {
                // If there is no userResponse or the IDs don't match, return an unauthorized access error.
                return Unauthorized("Only the owner can create your post.");
            }

            // Proceed to add the post if the user is verified.
            int postId = await _postService.AddPost(request);

            // Return a created response with a route to the newly created post.
            return CreatedAtAction(nameof(Get), new { id = postId }, request);
        }

        [HttpPut("{id}")]
        //[Authorize(Policy = "EditAnyPost")] // Admins can edit any post
        [Authorize(Policy = "LoginRequire")]
        public async Task<IActionResult> Update(int id, UpdatePostRequest request)
        {
            UserResponse userResponse = (UserResponse)HttpContext.Items["user"];
            Post post = await _postService.GetPostById(id);
            if (post == null)
            {
                return NotFound();
            }
            bool isAdminOrOwner = userResponse.Role.ToLower().Trim().Equals("admin") || post.UserId == userResponse.Id;
            if (isAdminOrOwner)
            {               
                await _postService.UpdatePost(id, request);
                
                return NoContent();
            }
            else
            {
                return Forbid();
            }
        }

        [HttpDelete("{id}")]
        //[Authorize(Policy = "AdminRequire")]
        [Authorize(Policy = "AdminRequire")]
        public async Task<IActionResult> Delete(int id)
        {
            var post = await _postService.GetPostById(id);            
            if (post == null)
            {
                return NotFound();
            }
            await _postService.DeletePost(post);
            return NoContent();            
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
