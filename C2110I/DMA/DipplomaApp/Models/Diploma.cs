using System;
using System.Collections.Generic;

namespace DipplomaApp.Models;

public partial class Diploma
{
    public int DiplomaId { get; set; }

    public string? FullName { get; set; }

    public DateTime? Dob { get; set; }

    public int? SexId { get; set; }

    public int? TrainingTypeId { get; set; }

    public int? TrainingProgramId { get; set; }

    public int? RankId { get; set; }

    public int? DiplomaTypeId { get; set; }

    public string? BirthPlace { get; set; }

    public string? VolumedBook { get; set; }

    public string? DecideCode { get; set; }

    public string? NumberSign { get; set; }

    public string? RegisterNumber { get; set; }

    public string? Language { get; set; }

    public string? Colour { get; set; }

    public string? Size { get; set; }

    public virtual DiplomaType? DiplomaType { get; set; }

    public virtual Rank? Rank { get; set; }

    public virtual Sex? Sex { get; set; }

    public virtual TrainingProgram? TrainingProgram { get; set; }

    public virtual TrainingType? TrainingType { get; set; }
}
