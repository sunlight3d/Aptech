using System;
using System.Collections.Generic;
using OpenQA.Selenium;
using OpenQA.Selenium.Chrome;

class TourInfo
{
    public string Title { get; set; }
    public string Image { get; set; }
    public string Code { get; set; }
    public string Location { get; set; }
    public string Duration { get; set; }
    public string Transport { get; set; }
    public string Price { get; set; }
    public List<string> Dates { get; set; }
    public string Url { get; set; }
}

class Program
{
    static void Main(string[] args)
    {
        var options = new ChromeOptions();
        //options.AddArgument("--headless"); // Bỏ dòng này nếu muốn xem trình duyệt
        using var driver = new ChromeDriver(options);

        string url = "https://travel.com.vn/du-lich-trung-quoc.aspx?fromDate=2025-07-24&utm_source=DIGI_Google&utm_medium=cpa&utm_campaign=TrungQuoc_AllProduct&gad_source=1&gad_campaignid=20532862538&gbraid=0AAAAAoO64iJty_rtiNzExJN3rshHkdnl_&gclid=Cj0KCQjws4fEBhD-ARIsACC3d2-4EBF7Y-QsrBGZXbwotGsq-PFz_1hWocqhSEcyg0-jaBkfYkmyKycaAic1EALw_wcB"; // Thay URL nếu cần
        driver.Navigate().GoToUrl(url);
        driver.Manage().Timeouts().ImplicitWait = TimeSpan.FromSeconds(200);

        var tours = new List<TourInfo>();
        var tourCards = driver.FindElements(By.ClassName("card-filter-desktop"));

        foreach (var card in tourCards)
        {
            try
            {
                var title = card.FindElement(By.CssSelector(".card-filter-desktop__content--header-title")).Text;
                var image = card.FindElement(By.CssSelector(".card-filter-desktop__thumbnail img")).GetAttribute("src");
                var code = card.FindElement(By.CssSelector(".info-tour-tourCode .card-filter-desktop__content--info-tour--item-wrapper-content")).Text;
                var location = card.FindElement(By.CssSelector(".info-tour-departure .card-filter-desktop__content--info-tour--item-wrapper-content")).Text;
                var duration = card.FindElement(By.CssSelector(".info-tour-dayStayText--time .card-filter-desktop__content--info-tour--item-wrapper-content")).Text;
                var transport = card.FindElements(By.CssSelector(".info-tour-dayStayText .card-filter-desktop__content--info-tour--item-wrapper-content"))[^1].Text;
                var price = card.FindElement(By.CssSelector(".card-filter-desktop__content--price-newPrice p")).Text;
                var dateElems = card.FindElements(By.CssSelector(".info-tour-calendar .list-item a"));
                var dates = new List<string>();
                foreach (var d in dateElems)
                    dates.Add(d.Text.Trim());
                var href = card.FindElement(By.CssSelector(".card-filter-desktop__content--header-title")).GetAttribute("href");

                tours.Add(new TourInfo
                {
                    Title = title,
                    Image = image,
                    Code = code,
                    Location = location,
                    Duration = duration,
                    Transport = transport,
                    Price = price,
                    Dates = dates,
                    Url = href
                });
            }
            catch (Exception ex)
            {
                Console.WriteLine("Lỗi khi xử lý tour: " + ex.Message);
            }
        }

        // In ra kết quả
        foreach (var tour in tours)
        {
            Console.WriteLine($"🏷️ {tour.Title} | Mã: {tour.Code}");
            Console.WriteLine($"📍 {tour.Location} | 🕒 {tour.Duration} | 🚍 {tour.Transport}");
            Console.WriteLine($"💰 {tour.Price} | 📅 {string.Join(", ", tour.Dates)}");
            Console.WriteLine($"🔗 {tour.Url}");
            Console.WriteLine(new string('-', 80));
        }

        driver.Quit();
    }
}
