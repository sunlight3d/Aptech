using System;
using myapp.Models;
namespace myapp.Services
{
    public interface IStockService
    {
        Task<List<Stock>> GetStocksBySectorAndIndustry(
            string sector, string industry,
            string searchText,
            int page = 1, int pageSize = 20);
        Task<IEnumerable<string>> GetDistinctIndustryEn();
    }

}

