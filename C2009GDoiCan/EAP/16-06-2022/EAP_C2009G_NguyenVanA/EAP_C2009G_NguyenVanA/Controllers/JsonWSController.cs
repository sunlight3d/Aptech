using EAP_C2009G_NguyenVanA.Models;
using Newtonsoft.Json.Linq;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Net;
using System.Web;
using System.Web.Http;
using System.Web.Mvc;
//using System.Web.Http.ApiController;
namespace EAP_C2009G_NguyenVanA.Controllers
{
    
    public class JsonWSController : ApiController
    {
        private DataContext db = new DataContext();
        // GET: JsonWS
        /*
        public ActionResult Index()
        {
            return new EmptyResult();
        }
        */
        public JToken Get()
        {
            var products = db.Products;
            return JToken.FromObject(products);
        }
        public JToken Get(int id)
        {            
            Product product = db.Products.Find(id);
            //convert object to json
            return JToken.FromObject(product);            
        }
    }
}