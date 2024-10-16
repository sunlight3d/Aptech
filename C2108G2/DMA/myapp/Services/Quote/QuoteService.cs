using System;
using Microsoft.EntityFrameworkCore;
using myapp.Models;
using myapp.Models.SQLViews;

namespace myapp.Services
{
	public class QuoteService: IQuoteService
    {
        private readonly ApplicationDbContext _context;

        public QuoteService(ApplicationDbContext context)
        {
            _context = context;
        }

        //Sửa đoạn code sau, Thêm phần searchText vào câu lệnh query, tìm kiếm không phân biệt hoa/thường
        public async Task<IEnumerable<QuotesRealtime>> GetQuotes(
            int page,
            int pageSize,
            string sector,
            string searchText,
            string industry,
            string indexSymbol)
        {
            sector = string.IsNullOrEmpty(sector) ? "" : sector.Trim().ToLower();
            industry = string.IsNullOrEmpty(industry) ? "" : industry.Trim().ToLower();
            indexSymbol = string.IsNullOrEmpty(indexSymbol) ? "" : indexSymbol.Trim().ToLower();

            var query = _context.QuotesRealtimes
                .Where(q => string.IsNullOrEmpty(sector) || q.SectorEn.Trim().ToLower() == sector)
                .Where(q => string.IsNullOrEmpty(industry) || q.IndustryEn.Trim().ToLower() == industry)
                .Where(q => string.IsNullOrEmpty(indexSymbol) || q.IndexSymbol.Trim().ToLower() == indexSymbol)
                .OrderBy(q => q.TimeStamp);

            var totalItems = await query.CountAsync();
            var quotesRealtimes = await query.Skip((page - 1) * pageSize)
                                    .Take(pageSize).ToListAsync();
            return quotesRealtimes;
        }

    }
}

