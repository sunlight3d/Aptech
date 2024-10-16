using EAP_C2103L_NguyenVanA.Models;
using Newtonsoft.Json.Linq;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;

namespace EAP_C2103L_NguyenVanA.Controllers
{
    public class JsonWSController: System.Web.Http.ApiController
    {
        private DataContext db = new DataContext();
        public JToken Get() {
            return JArray.FromObject(db.Products.ToList());
        }
        public JToken Get(int id)
        {
            Product product = db.Products.Where(p => p.ProductId == id).FirstOrDefault();
            if (product == null)
            {
                throw new Exception($"Cannot find product with id : {id}");
            }
            else {
                return JObject.FromObject(product);
            }
            
        }
    }
}