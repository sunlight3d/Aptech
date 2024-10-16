using Microsoft.EntityFrameworkCore;
using myapp.Models.SQLViews;

namespace myapp.Models
{
    public class ApplicationDbContext : DbContext
    {
        public ApplicationDbContext(DbContextOptions<ApplicationDbContext> options)
            : base(options)
        {
        }

        public DbSet<User> Users { get; set; }
        public DbSet<CoveredWarrant> CoveredWarrants { get; set; }
        public DbSet<Derivative> Derivatives { get; set; }
        public DbSet<EducationalResource> EducationalResources { get; set; }
        public DbSet<ETF> ETFs { get; set; }
        public DbSet<EtfHolding> EtfHoldings { get; set; }
        public DbSet<IndexConstituent> IndexConstituents { get; set; }
        public DbSet<LinkedBankAccount> LinkedBankAccounts { get; set; }
        public DbSet<MarketIndex> MarketIndexes { get; set; }
        public DbSet<Notification> Notifications { get; set; }
        public DbSet<Order> Orders { get; set; }
        public DbSet<Portfolio> Portfolios { get; set; }
        public DbSet<Stock> Stocks { get; set; }
        public DbSet<Transaction> Transactions { get; set; }
        public DbSet<UserDevice> UserDevices { get; set; }
        public DbSet<Watchlist> Watchlists { get; set; }


        public DbSet<Quote> Quotes { get; set; }
        public DbSet<TopStock> TopStocks { get; set; }
        public DbSet<ETFQuote> ETFQuotes { get; set; }
        //SQL Views
        public DbSet<QuotesRealtime> QuotesRealtimes { get; set; }
        protected override void OnModelCreating(ModelBuilder modelBuilder)
        {
            modelBuilder.Entity<EtfHolding>()
                .HasKey(e => new { e.EtfId, e.StockId });
            modelBuilder.Entity<EtfHolding>()
                        .Property(e => e.EtfId)
                        .HasColumnName("etf_id");
            modelBuilder.Entity<EtfHolding>()
                        .Property(e => e.StockId)
                        .HasColumnName("stock_id");

            modelBuilder.Entity<IndexConstituent>()
                .HasKey(e => new { e.IndexId, e.StockId });            
            modelBuilder.Entity<Watchlist>()
                .HasKey(e => new { e.StockId, e.UserId });
            modelBuilder.Entity<Portfolio>()
                .HasKey(e => new { e.StockId, e.UserId });
            base.OnModelCreating(modelBuilder);

            //SQL views
            modelBuilder.Entity<QuotesRealtime>()
                //QuotesRealtime là một view và không có khóa chính nào được xác định cho nó
                .HasNoKey().ToView("view_quotes_realtime");

        }
    }
}
