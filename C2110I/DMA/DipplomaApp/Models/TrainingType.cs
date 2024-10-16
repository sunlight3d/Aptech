using System;
using System.Collections.Generic;

namespace DipplomaApp.Models;

public partial class TrainingType
{
    public int TrainingTypeId { get; set; }

    public string? TrainingTypeCode { get; set; }

    public string? TrainingTypeName { get; set; }

    public virtual ICollection<Diploma> Diplomas { get; } = new List<Diploma>();

    public virtual ICollection<TrainingProgram> TrainingPrograms { get; } = new List<TrainingProgram>();
}
