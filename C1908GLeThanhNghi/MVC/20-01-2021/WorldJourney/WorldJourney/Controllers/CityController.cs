using Microsoft.AspNetCore.Hosting;
using Microsoft.AspNetCore.Mvc;
using System;
using System.Collections.Generic;
using System.IO;
using System.Linq;
using System.Threading.Tasks;
using WorldJourney.Models;

namespace WorldJourney.Controllers
{
    public class CityController : Controller
    {
        private IData _data;
        private IWebHostEnvironment _environment;
        public CityController(IData data, IWebHostEnvironment environment)
        {
            //Dependency injection
            _data = data;
            _environment = environment;
            _data.CityInitializeData();
        }
        public IActionResult Index()
        {
            ViewData["Page"] = "Search city";            
            return View();//Views/City/Index.cshtml
            //return RedirectToAction("Index", "City");
        }
        public IActionResult Details(int? id) {
            City city = _data.GetCityById(id);
            ViewBag.Title = city.CityName;               
            return View(city);//Views/City/Details.cshtml
            //View(@model)
        }
        public IActionResult GetImage(int? cityId)
        {
            ViewData["Message"] = "display Image";
            City requestedCity = _data.GetCityById(cityId);
            if (requestedCity != null)
            {
                string webRootpath = _environment.WebRootPath;
                string folderPath = "\\images\\";
                string fullPath = webRootpath + folderPath + requestedCity.ImageName;
                FileStream fileOnDisk = new FileStream(fullPath, FileMode.Open);
                byte[] fileBytes;
                using (BinaryReader br = new BinaryReader(fileOnDisk))
                {
                    fileBytes = br.ReadBytes((int)fileOnDisk.Length);
                }
                return File(fileBytes, requestedCity.ImageMimeType);
            }
            else
            {
                return NotFound();
            }
        }
    }
}
