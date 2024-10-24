using System;
using System.Collections.Generic;
using System.ComponentModel.DataAnnotations;
using System.Text.Json.Serialization;

namespace project02_datafirst.Models;

public partial class Nurse
{
    public int NurseId { get; set; }
    [Required]
    [StringLength(maximumLength: 120, ErrorMessage ="Name must be <= 120 characters")]
    public string Name { get; set; } = null!;

    public string Certification { get; set; } = null!;

    public int WardId { get; set; }

    [JsonIgnore]
    public virtual Ward Ward { get; set; } = null!;
}
