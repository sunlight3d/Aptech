using System;
using System.Collections.Generic;

namespace DipplomaApp.Models;

public partial class User
{
    public int UsersId { get; set; }

    public string? UserName { get; set; }

    public string? Password { get; set; }

    public string? Discription { get; set; }
}
