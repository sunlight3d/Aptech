using System;
using Microsoft.AspNetCore.Mvc;
using myapp.Models;
using myapp.Services;

namespace myapp.Controllers
{
    [ApiController]
    [Route("api/[controller]")]
    public class MarketIndexController : ControllerBase
    {
        private readonly IMarketIndexService _marketIndexService;

        public MarketIndexController(IMarketIndexService marketIndexService)
        {
            _marketIndexService = marketIndexService;
        }

        [HttpGet]
        public async Task<ActionResult<List<MarketIndex>>> GetAllMarketIndexes()
        {
            var marketIndexes = await _marketIndexService.GetAllMarketIndexesAsync();
            return Ok(marketIndexes);
        }
        
    }

}

