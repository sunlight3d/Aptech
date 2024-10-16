using System;
using System.Collections.Generic;

namespace DipplomaApp.Models;

public partial class DiplomaType
{
    public int DiplomaTypeId { get; set; }

    public string DilomaTypeName { get; set; } = null!;

    public string? OrganizationIssue { get; set; }

    public string? PersonIssue { get; set; }

    public string? Position { get; set; }

    public string? Language { get; set; }

    public string? Colour { get; set; }

    public string? Size { get; set; }

    public virtual ICollection<Diploma> Diplomas { get; } = new List<Diploma>();
}
