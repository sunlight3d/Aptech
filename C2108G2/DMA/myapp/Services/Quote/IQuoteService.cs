using System;
using myapp.Models;
using myapp.Models.SQLViews;

namespace myapp.Services
{
	public interface IQuoteService
	{
        Task<IEnumerable<QuotesRealtime>> GetQuotes(
            int page,
            int pageSize,
            string sector,
            string searchText,
            string industry,
            string indexSymbol);

    }
}

