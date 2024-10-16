using Newtonsoft.Json;
using System;
using System.Collections.Generic;

namespace DipplomaAppClient.Models;

public partial class User
{
    [JsonProperty("usersId")]
    public int UsersId { get; set; }

    [JsonProperty("userName")]
    public string? UserName { get; set; }

    /*
    [JsonProperty("userName")]
    public string? Password { get; set; }
    */
    [JsonProperty("discription")]
    public string? Discription { get; set; }
}
