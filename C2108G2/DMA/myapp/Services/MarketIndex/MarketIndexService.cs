using System;
using Microsoft.EntityFrameworkCore;
using myapp.Models;

namespace myapp.Services
{
    public class MarketIndexService : IMarketIndexService
    {
        private readonly ApplicationDbContext _context;

        public MarketIndexService(ApplicationDbContext context)
        {
            _context = context;
        }

        public async Task<List<MarketIndex>> GetAllMarketIndexesAsync()
        {
            return await _context.MarketIndexes.ToListAsync();
        }
        
    }

}

