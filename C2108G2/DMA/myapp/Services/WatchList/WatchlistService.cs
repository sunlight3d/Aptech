using System;
using Microsoft.EntityFrameworkCore;
using myapp.Models;

namespace myapp.Services
{
    public class WatchlistService : IWatchlistService
    {
        private readonly ApplicationDbContext _context;

        public WatchlistService(ApplicationDbContext context)
        {
            _context = context;
        }
        
        public async Task AddStockToWatchlistAsync(int userId, int stockId)
        {
            // Check if stock exists
            var stock = await _context.Stocks.FirstOrDefaultAsync(s => s.StockId == stockId);
            if (stock == null)
            {
                return;
            }

            // Check if the stock is already in the user's watchlist
            var existingWatchlist = await _context.Watchlists
                                    .FirstOrDefaultAsync(w => w.UserId == userId
                                        && w.StockId == stockId);
            if (existingWatchlist == null)
            {
                var watchlist = new Watchlist
                {
                    UserId = userId,
                    StockId = stockId
                };

                _context.Watchlists.Add(watchlist);
                await _context.SaveChangesAsync();
            }
            
        }
        public async Task RemoveStockFromWatchlistAsync(int userId, int stockId)
        {
            // Check if the stock is in the user's watchlist
            var watchlist = await _context.Watchlists
                .FirstOrDefaultAsync(w => w.UserId == userId && w.StockId == stockId);
            if (watchlist != null)
            {
                _context.Watchlists.Remove(watchlist);
                await _context.SaveChangesAsync();
            }
        }
    }
}

