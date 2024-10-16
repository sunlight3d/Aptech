using Microsoft.AspNetCore.Http;
using System;
using System.Collections.Generic;
using System.ComponentModel.DataAnnotations;
using System.Linq;
using System.Threading.Tasks;

namespace ButterfliesShop.Models
{
    public class Butterfly
    {
        public int Id { get; set; }

        [Display(Name = "Common Name aa:")]
        [Required(ErrorMessage = "Please enter the butterfly name")]
        
        public string CommonName { get; set; }
        [Display(Name = "Butterfly Family:")]

        [Required(ErrorMessage = "Please select the butterfly family")]
        public Family? ButterflyFamily { get; set; }
        [Display(Name = "Butterflies Quantity:")]
        public int? Quantity { get; set; }
        [Display(Name = "Characteristics:")]

        [Required(ErrorMessage = "Please type the characteristics")]
        [StringLength(150, MinimumLength =30)]        
        public string Characteristics { get; set; }

        
        [Display(Name = "Updated on:")]
        [DataType(DataType.DateTime)]
        [DisplayFormat(DataFormatString = "{0:dd/MM/yy}",NullDisplayText ="Please fill..")]
        public DateTime CreatedDate { get; set; }


        [Display(Name = "Butterflies Picture:")]
        [Required(ErrorMessage = "Please select the butterflies picture")]
        public IFormFile PhotoAvatar { get; set; }

        public string ImageName { get; set; }
        public byte[] PhotoFile { get; set; }
        public string ImageMimeType { get; set; }
    }
}
