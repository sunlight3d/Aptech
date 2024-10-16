using System;
using System.Collections.Generic;
using System.Linq;
using System.Net;
using System.Web;
using System.Web.Http;
using System.Xml.Linq;

namespace RequestResponseFlow.Web.Controllers
{
    public class CountriesController:ApiController
    {
        // GET api/countries
        public IEnumerable<string> Get()
        {
            var result = GetCountries();
            //se debug
            return result.Descendants("{http://www.worldbank.org}name").Select(x => x.Value);
        }

        private XDocument GetCountries()
        {
            var client = (HttpWebRequest)WebRequest.Create("http://localhost:8371/api/countries");
            client.Accept = "application/xml";
            //client.Accept = "application/json";
            WebResponse response = client.GetResponse();
            //cac ham xu ly du lieu xml
            var document = XDocument.Load(response.GetResponseStream());
            return document;
        }
    }
}