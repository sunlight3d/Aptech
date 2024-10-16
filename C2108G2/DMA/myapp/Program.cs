
using Microsoft.AspNetCore.Hosting;
using Microsoft.EntityFrameworkCore;
using myapp.Controllers.Filters;
using myapp.Hubs;
using myapp.Models;
using myapp.Services;

namespace myapp
{
    public class Program
    {
        public static void Main(string[] args)
        {
            var builder = WebApplication.CreateBuilder(args);

            // Add services to the container.
            builder.Services.AddAutoMapper(AppDomain.CurrentDomain.GetAssemblies());
            builder.Services.AddControllers();
            // Learn more about configuring Swagger/OpenAPI at https://aka.ms/aspnetcore/swashbuckle
            //builder.Services.AddEndpointsApiExplorer();
            builder.Services.AddSwaggerGen();                        
            

            builder.Services.AddSignalR();

            var settings = builder.Configuration
                .GetRequiredSection("ConnectionStrings"); //read data from appsettings.json
            builder.Services.AddDbContext<ApplicationDbContext>(options =>
                options.UseSqlServer(settings["DefaultConnection"]));

            builder.Services.AddScoped<IQuoteService, QuoteService>();
            builder.Services.AddScoped<IStockService, StockService>();
            builder.Services.AddScoped<IWatchlistService, WatchlistService>();
            builder.Services.AddScoped<IMarketIndexService, MarketIndexService>();            

            builder.Services.AddSignalR();

            builder.Services.AddScoped<TokenAuthorizationFilter>();

            var app = builder.Build();            

            // Configure the HTTP request pipeline.
            if (app.Environment.IsDevelopment())
            {
                app.UseSwagger();
                app.UseSwaggerUI();
            }

            app.UseHttpsRedirection();

            app.UseAuthorization();


            app.MapControllers();            
            app.MapHub<QuoteHub>("/quoteHub");

            app.Run();
        }
    }
}
/*
I need to write a mobile app for investing who need to buy securities/stock
Which functionalities show I have ?

Design SQL Database for a securities/stock app with these functionalities:
User Authentication:
Registration and login functionality for new and existing users.

User Profile:
Display user's personal information, portfolio, and account settings.
Allow users to link their bank accounts or other funding sources for deposits and withdrawals.

Market Overview:
Provide an overview of the stock market, including major indices, top gainers and losers, and news.
Optional: Offer customizable watchlists for users to track their favorite stocks.

Search and Discover:
Allow users to search for stocks or securities by company name, ticker symbol, or other criteria.
Offer personalized stock recommendations based on the user's interests and investment goals.

Stock Details:
Show detailed information about a stock, such as historical price charts, key financials, and recent news.
Include analyst ratings, earnings reports, and dividend information.

Buy/Sell/Trade Functionality:
Enable users to buy, sell, or trade stocks and other securities.
Offer market, limit, stop, and other order types.
Display real-time quotes and order execution status.

Portfolio Management:
Track users' portfolios, including holdings, performance, and asset allocation.
Offer tools for risk analysis, rebalancing, and diversification.

Notifications and Alerts:
Send push notifications for order executions, price alerts, and important news events.
Allow users to customize their notification preferences.

Educational Resources:
Provide educational content to help users understand investing, trading strategies, and risk management.

Customer Support:
Offer in-app support through chat, email, or phone to assist users with any issues.
Remember to design your app with a clean, user-friendly interface and consider following best practices for mobile app design. Additionally, you may need to comply with legal requirements and financial regulations depending on your region, so consult with legal and compliance experts as needed.

SQL Server DB must have:
1-convention: eg: number_of_person(field's name)
table name: eg: users,...
Write SQL commands only
give comment on each field(english-vietnamese)(what is it used for ?, ignore some simple fields, eg: email, phone)
give me some available field's values. Ed: quanlity: "good", "bad", "normal",...
 */
/*
Write sql commands to insert 20 faked users
*/
/*
Write useful procedures/functions/views that this database should have
*/