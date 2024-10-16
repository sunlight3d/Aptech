using System;
using System.Collections.Generic;
using System.IO;
using System.Linq;
using System.Net;
using System.Net.Http;
using System.Web;
using System.Web.Http;
using System.Xml.Linq;

namespace DataServices.Controllers
{
    public class CountriesController : ApiController
    {
        // GET api/values
        public XElement Get()
        {
            //Doc du lieu tu file xml
            string path = Path.Combine(HttpContext.Current.Server.MapPath("~"), "Countries.xml");
            FileStream file = File.OpenRead(path);                        
            var document = XDocument.Load(file);
            file.Close();
            return document.Root;
        }
    }
}