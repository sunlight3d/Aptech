using System;
using System.Collections.Generic;

namespace DipplomaApp.Models;

public partial class Sex
{
    public int SexId { get; set; }

    public string? SexName { get; set; }

    public virtual ICollection<Diploma> Diplomas { get; } = new List<Diploma>();
}
