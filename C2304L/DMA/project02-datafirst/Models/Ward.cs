using System;
using System.Collections.Generic;

namespace project02_datafirst.Models;

public partial class Ward
{
    public int WardId { get; set; }

    public string Name { get; set; } = null!;

    public int Capacity { get; set; }

    public virtual ICollection<Nurse> Nurses { get; set; } = new List<Nurse>();
}
