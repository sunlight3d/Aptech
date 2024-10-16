using System;
using System.ComponentModel.DataAnnotations;
using System.ComponentModel.DataAnnotations.Schema;

namespace myapp.Models
{
    //Từ thực thể sau đây, viết cho tôi controller(asp .net core api) tương ứng,
    //trong đó chứa 1 action lấy thông tin chi tiết bảng Quote, tuy nhiên phải query sang bảng Stock để lấy tên của stock
    //Yêu cầu request này hỗ trợ Websocket, nghĩa là mỗi lần dữ liệu thay đổi thì phía client cũng phải cập nhật theo
    public class Quote
    {
        [Key]
        [Column("quote_id")]
        public int QuoteId { get; set; }

        [ForeignKey("Stock")]
        [Column("stock_id")]
        [Required(ErrorMessage = "Stock ID is required.")]
        public int StockId { get; set; }

        [Column("price")]
        [Required(ErrorMessage = "Price is required.")]
        public decimal Price { get; set; }

        [Column("change")]
        [Required(ErrorMessage = "Change is required.")]
        public decimal Change { get; set; }

        [Column("percent_change")]
        [Required(ErrorMessage = "Percent Change is required.")]
        public decimal PercentChange { get; set; }

        [Column("volume")]
        [Required(ErrorMessage = "Volume is required.")]
        public int Volume { get; set; }

        [Column("time_stamp")]
        [Required(ErrorMessage = "Time stamp is required.")]
        public DateTime TimeStamp { get; set; }

        public Stock? Stock { get; set; }

    }
}

