using myapp.Models;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Net;
using System.Net.Http;
using System.Web;
using System.Web.Http;
using System.Web.Mvc;

namespace myapp.Controllers
{
    public class DestinationsController : ApiController
    {
        private List<Destination> _destinations = new List<Destination>();//_ : private 
        //eager initialization
        public DestinationsController() {
            _destinations.Add(new Destination { Id = 1, CityName = "Seattle", Airport = "Sea-Tac" });
            _destinations.Add(new Destination { Id = 2, CityName = "New-york", Airport = "JFK" });
            _destinations.Add(new Destination { Id = 3, CityName = "Amsterdam", Airport = "Schiphol" });
            _destinations.Add(new Destination { Id = 4, CityName = "London", Airport = "Heathrow" });
            _destinations.Add(new Destination { Id = 5, CityName = "Paris", Airport = "Charles De Gaulle" });
        }
        public Destination Get(int id)
        {
            var destination = _destinations
                .Where(eachDestination => eachDestination.Id == id)
                .FirstOrDefault();//LINQ

            if (destination == null)
                throw new HttpResponseException(
                   new HttpResponseMessage(HttpStatusCode.NotFound));
            return destination;
        }
        // GET api/destinations
        public List<Destination> Get()
        {
            Console.WriteLine("haha");
            return _destinations;
        }

        // DELETE api/destinations
        public void Delete(int id)
        {
            Console.WriteLine("Before delete");
            _destinations.Remove(Get(id));
            Console.WriteLine("After delete");
        }
    }
}