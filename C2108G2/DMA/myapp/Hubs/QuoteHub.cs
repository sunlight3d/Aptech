using System;
using Microsoft.AspNetCore.SignalR;
using System.Threading.Tasks;
using myapp.Models;
using myapp.Services;

namespace myapp.Hubs
{
    public class QuoteHub : Hub
    {
        private readonly IQuoteService _quoteService;

        public QuoteHub(IQuoteService quoteService)
        {
            _quoteService = quoteService;
        }
        //Từ client sẽ invoke đến SubscribeToStocksRealTime 1 lần
        public async Task SubscribeToStocksRealTime(
            int page, int pageSize,
            string sector = "",
            string industry = ""
            )
        {
            while (true)
            {
                var quotes = await _quoteService.GetQuotes(
                    page: page,
                    pageSize: pageSize,
                    sector: sector,
                    industry: industry,
                    searchText: "",
                    indexSymbol: ""                    
                );
                //Gửi danh sách cổ phiếu đến client đang kết nối
                //client sẽ "lắng nghe" ReceiveQuotesRealTime
                await Clients.Caller.SendAsync("ReceiveQuotesRealTime", quotes); 

                // Chờ 2 giây để tiếp tục kiểm tra lại dữ liệu
                await Task.Delay(2000);
            }
        }        
    }
}

