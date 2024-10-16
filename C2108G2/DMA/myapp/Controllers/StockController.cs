using System;
using Microsoft.AspNetCore.Mvc;
using myapp.Models;
using myapp.Services;
using System.Linq;

namespace myapp.Controllers
{
    [ApiController]
    [Route("api/[controller]")]
    public class StockController : ControllerBase
    {
        private readonly IStockService _stockService;

        public StockController(IStockService stockService)
        {
            _stockService = stockService;
        }

        [HttpGet("distinct-industry-en")]
        public async Task<IActionResult> GetDistinctIndustryEn()
        {
            var result = await _stockService.GetDistinctIndustryEn();
            return Ok(result);
        }

        [HttpGet]        
        public async Task<IActionResult> GetStocks(
            string sector = "",
            string industry = "",
            string searchText = "",
            int page = 1, int pageSize = 20)
        {
            var stocks = await _stockService
                            .GetStocksBySectorAndIndustry(
                                sector, industry,
                                searchText,
                                page, pageSize);

            if (stocks == null || stocks.Count() == 0)
            {
                return NotFound();
            }

            return Ok(stocks);
        }

    }
}

