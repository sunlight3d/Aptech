using EAP_C2002L_NguyenVanA.Models;
using Newtonsoft.Json.Linq;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;
using System.Web.Http;

namespace EAP_C2002L_NguyenVanA.Controllers
{
    public class JsonWSController: ApiController
    {
        private DataContext db = new DataContext();

        //api/JsonWS
        public JToken Get() {
            List<Product> products = db.Products.ToList();
            
            return JToken.FromObject(products.Select(product => new {
                Name = product.Name,
                ProductId = product.ProductId,
                Price = product.Price,
                Quantity = product.Quantity
            }));
        }
        //api/JsonWS/1
        public JToken Get(int id)
        {
            Product product = db.Products
                .Where(item => item.ProductId == id)
                .FirstOrDefault();

            return JToken.FromObject(new {
                Name = product.Name,
                ProductId = product.ProductId,
                Price = product.Price,
                Quantity = product.Quantity
            });            

        }        
    }
}
