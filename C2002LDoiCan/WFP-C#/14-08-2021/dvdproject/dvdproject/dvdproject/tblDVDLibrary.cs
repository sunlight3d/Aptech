//------------------------------------------------------------------------------
// <auto-generated>
//     This code was generated from a template.
//
//     Manual changes to this file may cause unexpected behavior in your application.
//     Manual changes to this file will be overwritten if the code is regenerated.
// </auto-generated>
//------------------------------------------------------------------------------

namespace dvdproject
{
    using System;
    using System.Collections.Generic;
    
    public partial class tblDVDLibrary
    {
        public int DVDCodeNo { get; set; }
        public Nullable<int> DVDCategoryId { get; set; }
        public string DVDTitle { get; set; }
        public Nullable<bool> SubTitles { get; set; }
        public Nullable<decimal> Price { get; set; }
        public Nullable<System.DateTime> DateAdd { get; set; }
    
        public virtual tblDVDCategory tblDVDCategory { get; set; }
    }
}
