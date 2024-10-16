using System;
using System.ComponentModel.DataAnnotations;
using System.ComponentModel.DataAnnotations.Schema;

namespace myapp.Models
{
    [Table("watchlists")]
    public class Watchlist
    {        
        [Column("user_id")]
        public int UserId { get; set; }

        [Column("stock_id")]
        public int StockId { get; set; }
        
        [ForeignKey("UserId")]
        public User? User { get; set; }
        
        [ForeignKey("StockId")]
        public Stock? Stock { get; set; }
    }

}
/**
từ thực thể watchlist, viết controller có chứa hàm thêm vào danh sách  watch list một cổ phiếu nào đó
*/

