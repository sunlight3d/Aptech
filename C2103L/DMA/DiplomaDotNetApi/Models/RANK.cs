//------------------------------------------------------------------------------
// <auto-generated>
//     This code was generated from a template.
//
//     Manual changes to this file may cause unexpected behavior in your application.
//     Manual changes to this file will be overwritten if the code is regenerated.
// </auto-generated>
//------------------------------------------------------------------------------

namespace DiplomaDotNetApi.Models
{
    using System;
    using System.Collections.Generic;
    
    public partial class RANK
    {
        [System.Diagnostics.CodeAnalysis.SuppressMessage("Microsoft.Usage", "CA2214:DoNotCallOverridableMethodsInConstructors")]
        public RANK()
        {
            this.Diplomata = new HashSet<DIPLOMA>();
        }
    
        public int RankID { get; set; }
        public string RankName { get; set; }
        public Nullable<float> FromPoint { get; set; }
        public Nullable<float> ToPoint { get; set; }
    
        [System.Diagnostics.CodeAnalysis.SuppressMessage("Microsoft.Usage", "CA2227:CollectionPropertiesShouldBeReadOnly")]
        public virtual ICollection<DIPLOMA> Diplomata { get; set; }
    }
}
