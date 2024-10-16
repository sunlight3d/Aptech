using MusicStore.Models;
using Newtonsoft.Json;
using Newtonsoft.Json.Linq;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;
using System.Web.Http;
using System.Web.Mvc;

namespace MusicStore.Controllers
{
    public class JsonWSController : ApiController
    {
        private DataContext db = new DataContext();
        [System.Web.Http.HttpGet]
        [System.Web.Http.Route("api/jsonws")]        
        public JToken Get() {
            var albumbs = db.Albums.ToList();
            var jsonResult = JsonConvert.SerializeObject(albumbs);
            return JToken.FromObject(jsonResult);
        }

        [System.Web.Http.HttpGet]
        [System.Web.Http.Route("api/jsonws/{id}")]
        public JToken Get(int id)
        {
            var albumb = db.Albums.Where(album => album.AlbumId == id);            
            return JToken.FromObject(JsonConvert.SerializeObject(albumb));
        }
    }
}