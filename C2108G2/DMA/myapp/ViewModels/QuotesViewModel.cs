using System;
using System.ComponentModel.DataAnnotations;

namespace myapp.ViewModels
{
    public class QuotesViewModel
    {
        [StringLength(50)]
        public string Sector { get; set; } = "";

        [StringLength(50)]
        public string Industry { get; set; } = "";

        [StringLength(50)]
        public string SearchText { get; set; } = "";

        [StringLength(50)]
        public string IndexSymbol { get; set; } = "";

        [Range(1, int.MaxValue)]
        public int Page { get; set; } = 1;

        [Range(1, 100)]
        public int PageSize { get; set; } = 20;
    }
}

