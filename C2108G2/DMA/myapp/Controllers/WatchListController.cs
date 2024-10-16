using System;
using System.Security.Claims;
using AutoMapper;
using Microsoft.AspNetCore.Identity;
using Microsoft.AspNetCore.Mvc;
using Microsoft.EntityFrameworkCore;
using myapp.Models;
using myapp.Controllers.Attributes;
using myapp.Services;
using myapp.Extensions;
using System.Runtime.InteropServices;

namespace myapp.Controllers
{
    [ApiController]
    [Route("api/[controller]")]    
    public class WatchListController : ControllerBase
    {
        private readonly ApplicationDbContext _context;        
        private readonly IWatchlistService _watchlistService;

        public WatchListController(ApplicationDbContext context,
            IWatchlistService watchlistService)
        {
            _context = context;
            _watchlistService = watchlistService;
        }

        [HttpPost]
        [AuthorizeToken]
        [Route("add")]
        public async Task<IActionResult> AddToWatchlist(int stockId)
        {
            // Kiểm tra token
            //context.HttpContext.Items["UserId"]            
            int userId = HttpContext.GetUserId();
            // Check if user exists
            var user = await _context.Users
                        .FirstOrDefaultAsync(u => u.UserId == userId);
            if (user == null)
            {
                return Unauthorized();
            }

            await _watchlistService.AddStockToWatchlistAsync(userId: user.UserId, stockId: stockId);

            return Ok(new
            {
                success = true,
                message = "Stock has been added to watchlist"
            });
        }
        [HttpDelete]
        [AuthorizeToken]
        [Route("remove")]
        public async Task<IActionResult> RemoveFromWatchlist(int stockId)
        {
            // Lấy user ID từ context
            int userId = HttpContext.GetUserId();

            // Kiểm tra xem user có tồn tại không
            var user = await _context.Users
                .FirstOrDefaultAsync(u => u.UserId == userId);
            if (user == null)
            {
                return Unauthorized();
            }

            // Xóa stock từ danh sách theo dõi của user
            await _watchlistService.RemoveStockFromWatchlistAsync(userId, stockId);

            // Trả về kết quả thành công
            return Ok(new
            {
                success = true,
                message = "Stock has been removed from watchlist"
            });
        }        
    }
}

