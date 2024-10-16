using System;
namespace myapp.Services
{
    public interface IWatchlistService
    {
        Task AddStockToWatchlistAsync(int userId, int stockId);
        Task RemoveStockFromWatchlistAsync(int userId, int stockId);
    }
}

