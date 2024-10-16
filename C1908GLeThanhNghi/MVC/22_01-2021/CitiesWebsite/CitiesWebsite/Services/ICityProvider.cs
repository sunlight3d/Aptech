using CitiesWebsite.Models;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Threading.Tasks;

namespace CitiesWebsite.Services
{
    public interface ICityProvider : IEnumerable<KeyValuePair<string, City>>
    {
        City this[string name] { get; }
    }
}
