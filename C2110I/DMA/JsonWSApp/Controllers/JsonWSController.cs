
using JsonWSApp.Models;
using Newtonsoft.Json.Linq;
using System.Web.Http;
using Newtonsoft.Json;
using System.Collections.Generic;

namespace JsonWSApp.Controllers
{
    [RoutePrefix("api/[controller]")]    
    public class JsonWSController : ApiController
    {
        private readonly DataContext db;
        public JsonWSController(DataContext db) { 
            this.db = db;
        }
        [HttpGet]
        private JToken Get(int id)
        {
            return JToken.FromObject(db.Products.Where(p => p.Id == id).FirstOrDefault());
        }
        [HttpGet]
        private JToken Get() {
            return JToken.FromObject(db.Products.ToList());
        }
    }
}
