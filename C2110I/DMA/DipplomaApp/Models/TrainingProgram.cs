using System;
using System.Collections.Generic;

namespace DipplomaApp.Models;

public partial class TrainingProgram
{
    public int TrainingProgramId { get; set; }

    public string? TrainingProgram1 { get; set; }

    public float? MaxPoint { get; set; }

    public float? AchievePoint { get; set; }

    public int? Achieve { get; set; }

    public int? TrainingTypeId { get; set; }

    public virtual ICollection<Diploma> Diplomas { get; } = new List<Diploma>();

    public virtual TrainingType? TrainingType { get; set; }
}
