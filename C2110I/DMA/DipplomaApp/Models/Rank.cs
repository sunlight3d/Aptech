using System;
using System.Collections.Generic;

namespace DipplomaApp.Models;

public partial class Rank
{
    public int RankId { get; set; }

    public string? RankName { get; set; }

    public float? FromPoint { get; set; }

    public float? ToPoint { get; set; }

    public virtual ICollection<Diploma> Diplomas { get; } = new List<Diploma>();
}
