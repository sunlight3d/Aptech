using System;
using myapp.Models;

namespace myapp.Services
{
    public interface IMarketIndexService
    {
        Task<List<MarketIndex>> GetAllMarketIndexesAsync();        
    }

}

