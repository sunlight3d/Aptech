using System;
using System.Collections.Generic;
using System.Linq;
using System.Net;
using System.Net.Http;
using System.Net.Http.Headers;
using System.Threading.Tasks;
using System.Web.Http;
using System.Xml.Linq;

namespace AsynchronousActions.Web.Controllers
{
    //phan consumer
    public class CountriesController : ApiController
    {
        // GET api/countries
        public async Task<IEnumerable<string>> Get()
        {
            var result = await GetCountries();
            var xx = result.Descendants("{http://www.worldbank.org}name");
            return result.Descendants("{http://www.worldbank.org}name").Select(x => x.Value);
        }

        private async Task<XDocument> GetCountries()
        {
            var client = new HttpClient();
            //client.Accept = "application/xml";
            client.DefaultRequestHeaders.Accept.Add(new MediaTypeWithQualityHeaderValue("application/xml"));
            var response = await client.GetAsync("http://localhost:8371/api/countries");
            var document = XDocument.Load(await response.Content.ReadAsStreamAsync());
            return document;
        }
    }
}
