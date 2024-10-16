using System;
using Microsoft.EntityFrameworkCore;
using myapp.Models;

namespace myapp.Services
{
    public class StockService : IStockService
    {
        private readonly ApplicationDbContext _context;

        public StockService(ApplicationDbContext context)
        {
            _context = context;
        }

        public async Task<IEnumerable<string>> GetDistinctIndustryEn()
        {
            var result = await _context
                                .Stocks.Select(s => s.IndustryEn)
                                .Distinct().ToListAsync();
            return result;
        }
        public async Task<List<Stock>> GetStocksBySectorAndIndustry(
            string sector,
            string industry,
            string searchText,
            int page = 1,
            int pageSize = 20)
        {
            IQueryable<Stock> query = _context.Stocks;

            query = query.Where(s => string.IsNullOrEmpty(sector) || s.Sector == sector);
            query = query.Where(s => string.IsNullOrEmpty(industry) || s.Industry == industry);
            query = query.Where(s => string.IsNullOrEmpty(searchText) ||
                s.CompanyName.Contains(searchText));
            // Phân trang
            int totalItems = await query.CountAsync();
            int totalPages = (int)Math.Ceiling((double)totalItems / pageSize);
            int skip = (page - 1) * pageSize;
            query = query.Skip(skip).Take(pageSize);

            return await query.ToListAsync();
        }

        
    }
}

